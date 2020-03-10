package org.svb.dmntools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyle;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyles;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf;
import org.svb.dmn12.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

public class opmWorkbookDmn12 {

    private XSSFWorkbook workbook;
    private XSSFRow tableRow; // the current row
    private XSSFCellStyle OPM_CONDITION_HEADING_STYLE;
    private XSSFCellStyle OPM_CONCLUSION_HEADING_STYLE;
    private XSSFCellStyle OPM_CONDITION_STYLE;
    private XSSFCellStyle OPM_CONCLUSION_STYLE;
    private XSSFCellStyle OPM_ELSE_STYLE;
    private XSSFCellStyle OPM_COMMENTARY_STYLE;
    private int row; // the current row number
    private List<TInputClause> intervalHeaders = new ArrayList<>(); // headers from conditions with intervals -> i.e. [19..25] or (19..25]
    private int conditionRows; //number of condition rows
    private FunctionTranslator ft;
    private List<TInputClause> enumerationColumns = new ArrayList<>();


    public static void startConversion(File opaExcelTemplate, File opaExcelfile,File xmlFile, FunctionTranslator ft){

        opmWorkbookDmn12 work = new opmWorkbookDmn12();
        work.ft = ft;

        try {

            JAXBContext jc = JAXBContext.newInstance("org.svb.dmn12");
            Unmarshaller u = jc.createUnmarshaller();
            JAXBElement je = (JAXBElement) u.unmarshal(xmlFile);
            TDefinitions dmndef = (TDefinitions) je.getValue();
            List<JAXBElement<? extends TDRGElement>> jes;
            jes = dmndef.getDrgElement();
            work.createOpmWorkbook(opaExcelTemplate, opaExcelfile, jes);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void createOpmWorkbook(File fileNameTemplate, File fileNameOut, List<JAXBElement <? extends TDRGElement>> jes) throws IOException {

        try{
            //use template
            OPCPackage pkg = OPCPackage.open(fileNameTemplate);
            this.workbook = new XSSFWorkbook(pkg);
            // get the styles
            getOpaStyles();
            for (JAXBElement i :  jes) {
                if (i.getValue().getClass() == TDecision.class) {
                    this.row = 1;
                    this.createOpmSheet( (TDecision) i.getValue());
                }
            }
            // remove templates
            this.removeTemplates();
            // write to new file
            FileOutputStream fos = new FileOutputStream(fileNameOut);
            this.workbook.write(fos);
            fos.flush();
            fos.close();
        }catch(Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private void createOpmSheet(TDecision dec){

        JAXBElement<? extends TExpression> expr = dec.getExpression();
        XSSFSheet sheet;

        if (expr.getValue().getClass() == TDecisionTable.class) {

            TDecisionTable dectable = (TDecisionTable) expr.getValue();
            //System.out.println(dec.getName());
            // sheets will have no name set, it leads to duplicate sheets errors, when the length of the name exceeds
            // a certain amount of characters and the characters before it are the same between tables
            sheet = this.workbook.createSheet();

            this.createCommentaryID(dectable,sheet);
            this.createTableHeaders(dectable, sheet);
            this.createTableFields(dectable, sheet);
        }
    }

    private void getIntervalHeaders(TDecisionTable d){

        // find intervals, they will lead to an extra column in OPA
        List<TDecisionRule> decisionRules = d.getRule();
        List<TInputClause> conditionHeaders = d.getInput();
        int testIndex;

        for (TDecisionRule r : decisionRules) {
            for (TUnaryTests t : r.getInputEntry()) {
                if (t.getText().contains("..")) {
                    testIndex = r.getInputEntry().indexOf(t);
                    if (!this.intervalHeaders.contains(conditionHeaders.get(testIndex))){
                        this.intervalHeaders.add(conditionHeaders.get(testIndex));
                    }
                }
            }
        }
    }

    private void createCommentaryID(TDecisionTable d, XSSFSheet s) {

        int rowCell = 1;
        XSSFCell commentCell;

        this.tableRow = s.createRow(this.row++);
        commentCell = this.tableRow.createCell(rowCell);
        commentCell.setCellStyle(this.OPM_COMMENTARY_STYLE);
        commentCell.setCellValue(d.getId());

    }

    private void createTableHeaders(TDecisionTable d, XSSFSheet s){

        List<TInputClause> conditionHeaders;
        List<TOutputClause> conclusionHeaders;
        conditionHeaders = d.getInput();
        conclusionHeaders = d.getOutput();
        XSSFCell conditionHeaderCell;
        XSSFCell conclusionHeaderCell;
        CellRangeAddress headerRegion;

        int rowCell = 1; // start from B = 1;
        this.conditionRows = conditionHeaders.size();
        // createHeaders
        this.tableRow = s.createRow(this.row++);
        for (TInputClause c : conditionHeaders) {
            conditionHeaderCell = this.tableRow.createCell(rowCell++);
            conditionHeaderCell.setCellStyle(this.OPM_CONDITION_HEADING_STYLE);
            conditionHeaderCell.setCellValue(c.getInputExpression().getText());

            TUnaryTests t = c.getInputValues();

            if (t != null) {
                if (t.getOtherAttributes().containsValue("enumeration")) {
                    this.enumerationColumns.add(c);
                }
            }
            if (this.intervalHeaders != null) {
                if (this.intervalHeaders.contains(c))
                // create extra column for interval
                {
                    this.conditionRows++;
                    conditionHeaderCell = this.tableRow.createCell(rowCell++);
                    conditionHeaderCell.setCellStyle(this.OPM_CONDITION_HEADING_STYLE);
                    headerRegion = new CellRangeAddress(2, 2, rowCell - 2, rowCell - 1);
                    s.addMergedRegion(headerRegion);
                }
            }
        }
        if (conclusionHeaders.size() == 1) {
            conclusionHeaderCell = this.tableRow.createCell(rowCell);
            conclusionHeaderCell.setCellStyle(this.OPM_CONCLUSION_HEADING_STYLE);
            conclusionHeaderCell.setCellValue(d.getOutputLabel());
        }
        if (conclusionHeaders.size() > 1) {
            for (TOutputClause o : conclusionHeaders){
                conclusionHeaderCell = this.tableRow.createCell(rowCell++);
                conclusionHeaderCell.setCellStyle(this.OPM_CONCLUSION_HEADING_STYLE);
                conclusionHeaderCell.setCellValue(o.getName());
            }
        }
    }

    private void createTableFields(TDecisionTable d, XSSFSheet s){

        int rowCell = this.conditionRows + 1;

        List<TDecisionRule> decisionRules = d.getRule();
        for (TDecisionRule r : decisionRules) {
            this.createRow(d, r, s, null, null);
        }

        // Else uncertain
        List<TOutputClause> conclusionHeaders;
        conclusionHeaders = d.getOutput();
        this.tableRow = s.createRow(this.row++);
        XSSFCell c;
        // conclusion else
        for (TOutputClause ignored : conclusionHeaders) {
            c = this.tableRow.createCell(rowCell++);
            c.setCellStyle(this.OPM_CONCLUSION_STYLE);
            c.setCellValue("uncertain");
        }
        XSSFCell elseCell = this.tableRow.createCell(this.conditionRows);
        elseCell.setCellStyle(this.OPM_ELSE_STYLE);
        elseCell.setCellValue("else");
    }

    private void createRow(TDecisionTable d, TDecisionRule r, XSSFSheet s, TUnaryTests enumT, String enumValue){

        XSSFCell conditionCell;
        int testIndex;
        int rowCell = 1;
        List<String> intervalSet;
        List<TInputClause> conditionHeaders = d.getInput();

        int rowsToCreate;
        TUnaryTests enumCell = null;


        List<String> stringEnumerations = new ArrayList<>();
        List<String> theOneEnumList = new ArrayList<>(); // hack

        final class enumField {
            private int index;
            private List<String> enumerationValues = new ArrayList<>();
        }

        List<enumField> efs =new ArrayList<>();

        this.tableRow = s.createRow(this.row++);

        for (TUnaryTests t : r.getInputEntry()) {
            conditionCell = this.tableRow.createCell(rowCell++);
            testIndex = r.getInputEntry().indexOf(t);

            switch (this.getAction(conditionHeaders,testIndex)){

                case "interval":
                    if (t.getText().contains("..")) {
                        intervalSet = this.getIntervalCells(t);
                        // write left part
                        this.formatAndSetConditionCell(conditionCell, intervalSet.get(0));
                        // create cell, write right part
                        conditionCell = this.tableRow.createCell(rowCell++);
                        this.formatAndSetConditionCell(conditionCell, intervalSet.get(1));
                    } else {
                        // one with value, one empty
                        this.formatAndSetConditionCell(conditionCell, t.getText());
                        conditionCell = this.tableRow.createCell(rowCell++);
                        this.formatAndSetConditionCell(conditionCell, "-");
                    }
                    break;

                case "enumeration":
                    if (enumT != null && enumT == t) {
                        this.formatAndSetConditionCell(conditionCell, enumValue);
                    } else {
                        Pattern p = Pattern.compile("(\"[\\w\\s]+\")");
                        Matcher m = p.matcher(t.getText());

                        if (m.find()) {
                            enumCell = t;
                            m.reset();
                            while (m.find()) {
                                stringEnumerations.add(m.group(1));
                            }
                            // to get one row with more than one enumvalue in the same column working, this hack is necessary

                            if ( stringEnumerations.size() > 1)
                            { theOneEnumList.addAll(stringEnumerations);}

                            enumField ef = new enumField();
                            ef.index = testIndex;
                            ef.enumerationValues = stringEnumerations;
                            efs.add(ef);

                            //      no matter what, select first find and put it in the row
                            this.formatAndSetConditionCell(conditionCell, stringEnumerations.get(0));
                            stringEnumerations.clear();
                        } else {  this.formatAndSetConditionCell(conditionCell, "-"); }
                    }
                    break;
                case "normal":
                    this.formatAndSetConditionCell(conditionCell, t.getText());
            }
            // if last cell is written, then write extra rows if needed
            createConclusionCell(r); // conclude last row
            if (r.getInputEntry().indexOf(t) == r.getInputEntry().size() - 1) { // all elements of the row have been processed
                // this is not a nice solution, but because of the complexity of this feature, it will have to do for now.
                rowsToCreate = theOneEnumList.size() - 1;
                if (rowsToCreate > 0) {

                    for (int i = 1; i <= rowsToCreate ; i++) {
                        createRow(d, r, s, enumCell, theOneEnumList.get(i));
                        createConclusionCell(r);
                    }
                }
            }
        }
    }

    private void createConclusionCell(TDecisionRule r){

        XSSFCell conclusionCell;
        int rowCell = this.conditionRows + 1;
        // 1 or more conclusion rows
        List<TLiteralExpression> expressionList = r.getOutputEntry();
        for (TLiteralExpression l : expressionList) {
            conclusionCell = this.tableRow.createCell(rowCell++);
            conclusionCell.setCellStyle(this.OPM_CONCLUSION_STYLE);
            conclusionCell.setCellValue(ft.transformFunctions(l.getText()));
        }
    }

    private void removeTemplates(){

        int index;
        XSSFSheet sheet;

        sheet = this.workbook.getSheet("Regeltabel");
        if(sheet != null)   {
            index = workbook.getSheetIndex(sheet);
            workbook.removeSheetAt(index);
        }

        sheet = this.workbook.getSheet("Declaraties");
        if(sheet != null)   {
            index = workbook.getSheetIndex(sheet);
            workbook.removeSheetAt(index);
        }
    }
    private void getOpaStyles(){

        this.OPM_CONCLUSION_HEADING_STYLE = getNamedCellStyle(this.workbook, "OPM - Conclusion Heading");
        this.OPM_CONDITION_HEADING_STYLE = getNamedCellStyle(this.workbook, "OPM - Condition Heading");
        this.OPM_CONCLUSION_STYLE = getNamedCellStyle(this.workbook, "OPM - Conclusion");
        this.OPM_CONDITION_STYLE = getNamedCellStyle(this.workbook, "OPM - Condition");
        this.OPM_ELSE_STYLE = getNamedCellStyle(this.workbook, "OPM - Else");
        this.OPM_COMMENTARY_STYLE = getNamedCellStyle(this.workbook, "OPM - Commentary");
    }

    private static XSSFCellStyle getNamedCellStyle(XSSFWorkbook workbook, String name) {

        StylesTable stylestable = workbook.getStylesSource();
        CTStylesheet ctstylesheet = stylestable.getCTStylesheet();
        CTCellStyles ctcellstyles = ctstylesheet.getCellStyles();


        if (ctcellstyles != null) {
            int i = 0;
            XSSFCellStyle style;
            while((style = stylestable.getStyleAt(i++)) != null) {
                CTXf ctxfcore = style.getCoreXf();
                long xfid = ctxfcore.getXfId();
                for (CTCellStyle ctcellstyle : ctcellstyles.getCellStyleList()) {
                    if (ctcellstyle.getXfId() == xfid && name.equals(ctcellstyle.getName())) {
                        return style;
                    }
                }
            }
        }
        return workbook.getCellStyleAt(0); //if nothing found return default cell style
    }

    private String getAction(List<TInputClause> ch, int t){


        if(!this.intervalHeaders.isEmpty() && this.intervalHeaders.contains(ch.get(t))){
            return "interval";
        }

        if (!this.enumerationColumns.isEmpty()&& this.enumerationColumns.contains(ch.get(t))) {
            return "enumeration";
        }

        return "normal";
    }

    private List<String> getIntervalCells(TUnaryTests t) {

        List<String> intervals = new ArrayList<>();

        Pattern p= Pattern.compile("(\\(|\\[)([0-9]+)\\.\\.([0-9]+)(\\)|])");
        Matcher m = p.matcher(t.getText());

        if (m.find()) {
            if (m.group(1).equals("[")) intervals.add(">=" + m.group(2));
            if (m.group(1).equals("(")) intervals.add(">" + m.group(2));
            if (m.group(4).equals("]")) intervals.add("<=" + m.group(3));
            if (m.group(4).equals(")")) intervals.add("<" + m.group(3));
        }

        return intervals;
    }

    private void formatAndSetConditionCell(XSSFCell c,  String s){

        if( s.length() == 1 && s.indexOf("-") == 0 ){
            c.setCellStyle(this.OPM_CONDITION_STYLE);
        } else {
            c.setCellValue(ft.transformFunctions(s));
            c.setCellStyle(this.OPM_CONDITION_STYLE);
        }
    }
}
