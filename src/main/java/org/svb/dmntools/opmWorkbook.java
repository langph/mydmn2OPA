package org.svb.dmntools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyle;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyles;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf;
import org.svb.dmn11.*;
import javax.xml.bind.JAXBElement;

public class opmWorkbook {

    private XSSFWorkbook workbook;
    private XSSFRow tableRow; // the current row
    private XSSFCellStyle OPM_CONDITION_HEADING_STYLE;
    private XSSFCellStyle OPM_CONCLUSION_HEADING_STYLE;
    private XSSFCellStyle OPM_CONDITION_STYLE;
    private XSSFCellStyle OPM_CONCLUSION_STYLE;
    private XSSFCellStyle OPM_ELSE_STYLE;
    private int row; // the current row number
    private List<TInputClause> intervalHeaders; // headers from conditions with intervals -> i.e. [19..25] or (19..25]
    private int condRows; //number of condition rows

    static XSSFCellStyle getNamedCellStyle(XSSFWorkbook workbook, String name) {

        StylesTable stylestable = workbook.getStylesSource();
        CTStylesheet ctstylesheet = stylestable.getCTStylesheet();
        CTCellStyles ctcellstyles = ctstylesheet.getCellStyles();
        if (ctcellstyles != null) {
            int i = 0;
            XSSFCellStyle style = null;
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

    public void createOpmWorkbook(File fileNametemplate, File fileNameOut, List<JAXBElement <? extends TDRGElement>> jes) throws IOException {

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
        if (expr.getValue().getClass() == TDecisionTable.class) {
            TDecisionTable dectable = (TDecisionTable) expr.getValue();
            XSSFSheet sheet = this.workbook.createSheet(dec.getName());
            // Hitpolicy moet unique zijn
            this.getIntervalHeaders(dectable);
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
    }

    private void getIntervalHeaders(TDecisionTable dectable){

        // find intervals, they will lead to an extra column in OPA
        List<TDecisionRule> decrules = dectable.getRule();
        List<TInputClause> conditionheaders = dectable.getInput();
        int testIndex;

        for (TDecisionRule r : decrules) {
            for (TUnaryTests t : r.getInputEntry()) {
                if (t.getText().contains("..")) {
                    testIndex = decrules.indexOf(r);
                    intervalHeaders.add(conditionheaders.get(testIndex));
                }
            }
        }
    }

    private void createTableHeaders(TDecisionTable dectable, XSSFSheet sheet){

        List<TInputClause> conditionheaders;
        List<TOutputClause> conclusionheaders;
        conditionheaders = dectable.getInput();
        conclusionheaders = dectable.getOutput();
        XSSFCell condCell;
        XSSFCell conclCell;
        CellRangeAddress headerRegion;

        int rowcell = 1; // start from B = 1;
        this.condRows = conditionheaders.size();
        // createHeaders
        this.tableRow = sheet.createRow(this.row++);
        for (TInputClause c : conditionheaders) {
            condCell = this.tableRow.createCell(rowcell++);
            condCell.setCellStyle(this.OPM_CONDITION_HEADING_STYLE);
            condCell.setCellValue(c.getInputExpression().getText());
            if (intervalHeaders != null) {
                if (intervalHeaders.contains(c))
                // create extra column for interval
                {
                    this.condRows++;
                    condCell = this.tableRow.createCell(rowcell++);
                    condCell.setCellStyle(this.OPM_CONDITION_HEADING_STYLE);
                    headerRegion = new CellRangeAddress(1, 1, rowcell - 1, rowcell);
                    sheet.addMergedRegion(headerRegion);
                }
            }
        }
        if (conclusionheaders.size() == 1) {
            conclCell = this.tableRow.createCell(rowcell);
            conclCell.setCellStyle(this.OPM_CONCLUSION_HEADING_STYLE);
            conclCell.setCellValue(dectable.getOutputLabel());
        }
        if (conclusionheaders.size() > 1) {
            for (TOutputClause o : conclusionheaders){
                conclCell = this.tableRow.createCell(rowcell++);
                conclCell.setCellStyle(this.OPM_CONCLUSION_HEADING_STYLE);
                conclCell.setCellValue(o.getName());
            }
        }
    }

    private void createConditionRow(TDecisionRule r, XSSFSheet sheet){

        XSSFCell condCell;
        String leftPart;
        String rightPart;
        String leftInterval;
        String rightInterval;
        int dashIndex;
        int rowcell = 1;

        this.tableRow = sheet.createRow(this.row++);

        for (TUnaryTests t : r.getInputEntry()) {
            condCell = this.tableRow.createCell(rowcell++);
            condCell.setCellStyle(this.OPM_CONDITION_STYLE);

            if(t.getText().length() == 1 && t.getText().indexOf("-") == 0 ){
                // Write nothing
            } else if(t.getText().contains("..")) {
                // interval - make to parts
                //TODO  interval <= < etc   --- "[" = ">=", "]" = "<="  "(" = ">" , ")" = "<"
                dashIndex = t.getText().indexOf("..");
                if ((t.getText().substring(0,1)) == "[") {
                    leftInterval = ">=";
                } else { leftInterval = ">";}

                if ((t.getText().substring(dashIndex+1,dashIndex+2)) == "]") {
                    rightInterval = "<=";

                } else { rightInterval = "<";}

                leftPart = t.getText().substring(1,dashIndex -1);
                condCell.setCellValue(leftInterval+leftPart);
                rightPart = t.getText().substring(dashIndex+2,t.getText().length()-1);
                condCell = this.tableRow.createCell(rowcell++);
                condCell.setCellStyle(this.OPM_CONDITION_STYLE);
                condCell.setCellValue(rightInterval+rightPart);

            } else { condCell.setCellValue(t.getText());}
        }
    }

    private void createConclusionRow(TDecisionTable dectable, TDecisionRule r, XSSFSheet sheet){

        XSSFCell conclCell;
        int rowcell = this.condRows + 1;
        // 1 or more conclusion rows
        List<TLiteralExpression> llist = r.getOutputEntry();
        for (TLiteralExpression l : llist) {
            conclCell = this.tableRow.createCell(rowcell++);
            conclCell.setCellStyle(this.OPM_CONCLUSION_STYLE);
            conclCell.setCellValue(l.getText());
        }
    }

    private void createTableFields(TDecisionTable dectable, XSSFSheet sheet){

        int rowcell = this.condRows + 1;

        List<TDecisionRule> decrules = dectable.getRule();
        for (TDecisionRule r : decrules) {
            this.createConditionRow(r, sheet);
            this.createConclusionRow(dectable, r, sheet);
        }

        // Else uncertain
        List<TOutputClause> conclusionheaders;
        conclusionheaders = dectable.getOutput();
        this.tableRow = sheet.createRow(this.row++);
        XSSFCell conclCell;
        // conclusion else
        for (TOutputClause o : conclusionheaders) {
            conclCell = this.tableRow.createCell(rowcell++);
            conclCell.setCellStyle(this.OPM_CONCLUSION_STYLE);
            conclCell.setCellValue("uncertain");
        }
        XSSFCell elseCell = this.tableRow.createCell(this.condRows);
        elseCell.setCellStyle(this.OPM_ELSE_STYLE);
        elseCell.setCellValue("else");
    }
}
