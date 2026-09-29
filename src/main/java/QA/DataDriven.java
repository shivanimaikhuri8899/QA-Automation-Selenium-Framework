package QA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

public class DataDriven {
    public static XSSFWorkbook wb;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static FileInputStream fis;

    public static void main(String[] args) throws IOException {
// TODO Auto-generated method stub
        String value = getCelldata(2, 2);
        System.out.println(value);
        String value1 = getCelldata(1, 2);
        System.out.println(value1);
        value = setCelldata("automation", 2, 2);
        System.out.println(value);
    }

    private static String setCellvalue(int i, int j) {
// TODO Auto-generated method stub
        return null;
    }
    public static String getCelldata(int rownum, int col) throws IOException {
        fis = new FileInputStream("D:\\data.xlsx");
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet("script");
        row = sheet.getRow(2);
        cell = row.getCell(2);
        return cell.getStringCellValue();
    }

    public static String setCelldata(String text, int rownum, int col) throws IOException {
        fis = new FileInputStream("D:\\data.xlsx");
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet("script");
        row = sheet.getRow(2);
        cell = row.getCell(2);
        cell.setCellValue(text);
        String celldata1 = cell.getStringCellValue();
        return celldata1;
    }

    @DataProvider(name="test")
    public Object[][] getData() throws FileNotFoundException,IOException {
        DataFormatter formatter=new DataFormatter();
        FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\Desktop\\Sheet.xlsx");
        XSSFWorkbook wb=new XSSFWorkbook(fis);
        XSSFSheet sheet=wb.getSheetAt(0);
        int rowCount=sheet.getPhysicalNumberOfRows();
        XSSFRow row=sheet.getRow(0);
        int colCount=row.getLastCellNum();
        Object[][] object=new Object[rowCount-1][colCount];
        for(int i=0;i<rowCount-1;i++){
            row=sheet.getRow(i+1);
            for(int j=0;j<colCount;j++){
                XSSFCell cell=row.getCell(j);
                object[i][j]=formatter.formatCellValue(cell);
            }
        }
        return object;

    }
}
