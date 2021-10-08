package base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Excel {

    private static final Log logger = LogFactory.getLog(Excel.class);

    private static Date date = new Date();
    private static SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmss");

    public String timeStamp() {
        return sdf.format(date);
    }

    public int lastRowNumber(String fileName, String sheetName) throws IOException {
        File file = new File("src/test/resources/config/GM/TestData/Excel/Input/" + fileName + ".xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        int rowNum = sheet.getLastRowNum();
        return rowNum;
    }

    public void writeExcel(String fileName, String sheetName, List<String> value) throws IOException {
        File file = new File("src/test/resources/config/GM/TestData/Excel/Output/" + fileName + ".xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = wb.getSheet(sheetName);
        Cell cell = null;

        int rowNum = sheet.getLastRowNum() + 1;

        Row row = sheet.createRow(rowNum);

        for (int j = 0; j < value.size(); j++) {
            cell = row.createCell(j);
            cell.setCellValue(value.get(j));
            logger.info("Values-------" + value.get(j));

        }
        FileOutputStream fileOut = new FileOutputStream("src/test/resources/config/GM/TestData/Excel/Output/" + fileName + ".xlsx");
        wb.write(fileOut);
    }

    public String readExcel(String fileName, String sheet, int row, int col) throws IOException {
        File f = new File("src/test/resources/config/GM/TestData/Excel/Input/" + fileName + ".xlsx");
        FileInputStream stream = new FileInputStream(f);
        Workbook w = new XSSFWorkbook(stream);
        Sheet s = w.getSheet(sheet);
        String name = null;
        Row r = s.getRow(row);
        Cell c = r.getCell(col);
        CellType type = c.getCellType();
        if (type == CellType.STRING) {
            name = c.getStringCellValue();
        } else if (type == CellType.NUMERIC) {
            double d = c.getNumericCellValue();
            long l = (long) d;
            name = String.valueOf(l);
        }
        return name;
    }

    public String getData(int row, int col) throws IOException {

        String fileName = "JLRMP_InputData";
        String sheet = "Data";
        File f = new File("src/test/resources/config/JLR/Input/" + fileName + ".xlsx");
        FileInputStream stream = new FileInputStream(f);
        Workbook w = new XSSFWorkbook(stream);
        Sheet s = w.getSheet(sheet);
        String name = null;
        Row r = s.getRow(row);
        Cell c = r.getCell(col);
        CellType type = c.getCellType();
        if (type == CellType.STRING) {
            name = c.getStringCellValue();
        } else if (type == CellType.NUMERIC) {
            double d = c.getNumericCellValue();
            long l = (long) d;
            name = String.valueOf(l);
        }
        return name;
    }

    public void writeExcel(String fileName, String sheetName, String downloadedFileName) throws IOException {
        File file = new File("src/test/resources/config/GM/TestData/Excel/Input/" + fileName + ".xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = wb.getSheet(sheetName);
        Cell cell = null;
        int rowNum = sheet.getLastRowNum();
        Row row = sheet.createRow(rowNum);
        cell = row.createCell(0);
        cell.setCellValue(downloadedFileName);
        logger.info("Values-------" + downloadedFileName);
        FileOutputStream fileOut = new FileOutputStream("src/test/resources/config/GM/TestData/Excel/Input/" + fileName + ".xlsx");
        wb.write(fileOut);
        wb.close();
    }
}