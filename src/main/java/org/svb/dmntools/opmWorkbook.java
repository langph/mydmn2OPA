package org.svb.dmntools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.openxml4j.opc.OPCPackage;
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
    private XSSFCellStyle OPM_CONDITION_HEADING_STYLE;
    private XSSFCellStyle OPM_CONCLUSION_HEADING_STYLE;
    private XSSFCellStyle OPM_CONDITION_STYLE;
    private XSSFCellStyle OPM_CONCLUSION_STYLE;
    private XSSFCellStyle OPM_ELSE_STYLE;
    private int row;

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

    private void createTableHeaders(TDecisionTable dectable, XSSFSheet sheet){

        List<TInputClause> conditionheaders;
        List<TOutputClause> conclusionheaders;
        conditionheaders = dectable.getInput();
        conclusionheaders = dectable.getOutput();
        XSSFRow tableRow;
        XSSFCell condCell;
        XSSFCell conclCell;
        int rowcell = 1; // start from B = 1;

        // createHeaders
        tableRow = sheet.createRow(this.row++);
        for (TInputClause c : conditionheaders) {
            condCell = tableRow.createCell(rowcell++);
            condCell.setCellStyle(this.OPM_CONDITION_HEADING_STYLE);
            condCell.setCellValue(c.getInputExpression().getText());
        }
        if (conclusionheaders.size() == 1) {
            conclCell = tableRow.createCell(rowcell);
            conclCell.setCellStyle(this.OPM_CONCLUSION_HEADING_STYLE);
            conclCell.setCellValue(dectable.getOutputLabel());
        }
        if (conclusionheaders.size() > 1) {
            for (TOutputClause o : conclusionheaders){
                conclCell = tableRow.createCell(rowcell++);
                conclCell.setCellStyle(this.OPM_CONCLUSION_HEADING_STYLE);
                conclCell.setCellValue(o.getName());
            }
        }
    }

    private void createTableFields(TDecisionTable dectable, XSSFSheet sheet){

        List<TInputClause> conditionheaders;
        List<TOutputClause> conclusionheaders;
        conditionheaders = dectable.getInput();
        conclusionheaders = dectable.getOutput();
        List<TDecisionRule> decrules;
        decrules = dectable.getRule();
        XSSFRow tableRow;
        XSSFCell condCell;
        XSSFCell conclCell;
        int rowcell = 1; // start from B = 1;

        for (TDecisionRule r : decrules) {
            tableRow = sheet.createRow(this.row++);
            rowcell = 1;
            for (TUnaryTests t : r.getInputEntry()) {
                condCell = tableRow.createCell(rowcell++);
                condCell.setCellStyle(this.OPM_CONDITION_STYLE);
                if(t.getText().length() == 1 && t.getText().indexOf("-") == 0 ){
                    // Write nothing
                    System.out.println(t.getText() + "length " + t.getText().length() + t.getText().indexOf("-"));
                } else {
                    condCell.setCellValue(t.getText());
                }
               // System.out.println(t.getText() + " length " + t.getText().length() +" index  " + t.getText().indexOf("-"));
            }
            // 1 or more conclusion rows
            List<TLiteralExpression> llist = r.getOutputEntry();
            for (TLiteralExpression l : llist) {
                conclCell = tableRow.createCell(rowcell++);
                conclCell.setCellStyle(this.OPM_CONCLUSION_STYLE);
                conclCell.setCellValue(l.getText());
            }
        }
        // Else uncertain


        tableRow = sheet.createRow(this.row++);
        rowcell = 1; // start from B = 1

        for (TInputClause c : conditionheaders ) {
            condCell = tableRow.createCell(rowcell++);
        }
        // conclusion else
        for (TOutputClause o : conclusionheaders) {
            conclCell = tableRow.createCell(rowcell++);
            conclCell.setCellStyle(this.OPM_CONCLUSION_STYLE);
            conclCell.setCellValue("uncertain");
        }
        XSSFCell elseCell = tableRow.getCell((rowcell - conclusionheaders.size() - 1));
        elseCell.setCellStyle(this.OPM_ELSE_STYLE);
        elseCell.setCellValue("else");
    }
}
