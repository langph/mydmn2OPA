package org.svb.dmntools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
    private List<String> enumerationIDs;



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

    private void createOpmWorkbook(File fileNametemplate, File fileNameOut, List<JAXBElement <? extends TDRGElement>> jes) throws IOException {

        try{
            //use template
            OPCPackage pkg = OPCPackage.open(fileNametemplate);
            this.workbook = new XSSFWorkbook(pkg);
            // get the styles
            getOpaStyles();
            for (JAXBElement i :  jes) {
                if (i.getValue().getClass() == TDecision.class) {
                    this.row = 1;
                    this.createOpmSheet( (TDecision) i.getValue());
                }
            }
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

        this.enumerationIDs = new ArrayList<>();

        if (expr.getValue().getClass() == TDecisionTable.class) {
            TDecisionTable dectable = (TDecisionTable) expr.getValue();
            XSSFSheet sheet = this.workbook.createSheet(dec.getName());
            // Hitpolicy moet unique zijn
            this.getIntervalHeaders(dectable);
            this.createCommentaryID(dectable,sheet);
            this.createTableHeaders(dectable, sheet);
            this.createTableFields(dectable, sheet);
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

    private void createCommentaryID(TDecisionTable d, XSSFSheet s) {

        int rowCell = 1;
        XSSFCell commentCell;

        this.tableRow = s.createRow(this.row++);
        commentCell = this.tableRow.createCell(rowCell);
        commentCell.setCellStyle(this.OPM_COMMENTARY_STYLE);
        commentCell.setCellValue(d.getId());

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
                   this.enumerationIDs.add(c.getId());
               }
           }
            if (intervalHeaders != null) {
                if (intervalHeaders.contains(c))
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

    private void createConditionRow(TDecisionTable d, TDecisionRule r, XSSFSheet s){

        XSSFCell conditionCell;
        int testIndex;
        int rowCell = 1;
        List<String> intervalSet;
        List<TInputClause> conditionHeaders = d.getInput();

        this.tableRow = s.createRow(this.row++);

        for (TUnaryTests t : r.getInputEntry()) {
            conditionCell = this.tableRow.createCell(rowCell++);
            testIndex = r.getInputEntry().indexOf(t);

            if(!this.intervalHeaders.isEmpty()) { //there are intervals
                if (this.intervalHeaders.contains(conditionHeaders.get(testIndex))){
                    //there are intervals in this column

                    if (t.getText().contains("..")) {

                        intervalSet = this.setIntervalCells(t);
                        // write left part
                        this.formatConditionCell(conditionCell, intervalSet.get(0));
                        // create cell, write left part
                        conditionCell = this.tableRow.createCell(rowCell++);
                        this.formatConditionCell(conditionCell, intervalSet.get(1));

                    } else {
                        // one with value, one empty
                        this.formatConditionCell(conditionCell, t.getText());
                        conditionCell = this.tableRow.createCell(rowCell++);
                        this.formatConditionCell(conditionCell, t.getText());
                    }
                } else { this.formatConditionCell(conditionCell, t.getText()); }
            } else { this.formatConditionCell(conditionCell, t.getText()); }
        }
    }



    private List<String> setIntervalCells(TUnaryTests t) {

        List<String> intervals = new ArrayList<>();

        Pattern pattern = Pattern.compile("(\\(|\\[)([0-9]+)\\.\\.([0-9]+)(\\)|])");
        Matcher matcher = pattern.matcher(t.getText());

        if (matcher.find()) {
            if (matcher.group(1).equals("[")) intervals.add(">=" + matcher.group(2));
            if (matcher.group(1).equals("(")) intervals.add(">" + matcher.group(2));
            if (matcher.group(4).equals("]")) intervals.add("<=" + matcher.group(3));
            if (matcher.group(4).equals(")")) intervals.add("<" + matcher.group(3));
        }

        return intervals;
    }

    private void formatConditionCell(XSSFCell c,  String s){

        if( s.length() == 1 && s.indexOf("-") == 0 ){
            c.setCellStyle(this.OPM_CONDITION_STYLE);
        } else {
            c.setCellValue(ft.transformFunctions(s));
            c.setCellStyle(this.OPM_CONDITION_STYLE);
        }
    }

    private void createConclusionRow(TDecisionRule r){

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

    private void createTableFields(TDecisionTable d, XSSFSheet s){

        int rowCell = this.conditionRows + 1;

        List<TDecisionRule> decisionRules = d.getRule();
        for (TDecisionRule r : decisionRules) {
            this.createConditionRow(d,r,s);
            //this.createConditionRows(d, r, s);
            this.createConclusionRow(r);
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
}
