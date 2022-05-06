package jxls.tool;

import jxls.Report;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jxls.common.Context;
import org.jxls.transform.poi.WritableCellValue;

public class WritableCell implements WritableCellValue {

    private Report report;

    WritableCell(Report report) {
        this.report = report;
    }

    @Override
    public Object writeToCell(Cell cell, Context context) {
        System.out.println("writeToCell");
        //  获取该单元格
        XSSFCell xssfCell = (XSSFCell) cell;
        //  获取该Sheet页
        XSSFSheet xssfSheet = xssfCell.getSheet();
        //  获取整个xlsx文件
        XSSFWorkbook xssfWorkbook = xssfSheet.getWorkbook();
        cell.setCellValue(report.getReportName());

        //  todo 判断有创建过标题的row
        if (null == context.getVar("isCreateRow")) {
            context.putVar("isCreateRow", "yes");
            int maxHeight = (int) context.getVar("maxHeight");
            /*for (int i = 0; i < maxHeight; i++) {
                xssfSheet.createRow(2);
            }*/
            //当前的row
            int currentRow = xssfCell.getRowIndex();
            int currentColumn = xssfCell.getColumnIndex();

            //xssfSheet.shiftRows(currentRow+1, xssfSheet.getLastRowNum(), 2, true, false);
//            XSSFRow row = xssfSheet.getRow(currentRow + 1);
//            if (null == row) {
//                row = xssfSheet.createRow(currentRow + 1);
//            }

            XSSFRow row = xssfSheet.createRow(currentRow + 1);


            XSSFCell sonCell = row.getCell(currentColumn);
            if (null == sonCell) {
                sonCell = row.createCell(currentColumn);
            }
            sonCell.setCellValue("XXXXXX");

        }
        return cell;
    }
}
