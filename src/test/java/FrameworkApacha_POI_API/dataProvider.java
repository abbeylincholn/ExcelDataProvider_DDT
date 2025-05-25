/*
package FrameworkApacha_POI_API;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class dataProvider {
    //multiple sets of data to our tests
    //arraypublic
    //5 sets of data as 5 arrays from data provider to your tests
    //then your test will run 5 times with 5 separate sets of data (arrays)

    DataFormatter formatter = new DataFormatter();
    @Test(dataProvider = "driveTest")
    public void testCaseData(String greeting, String communication, String id) {

        System.out.println(greeting + " " + communication + " " + id);
    }

    @DataProvider(name="driveTest")
    public Object[][] getData() throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\abbey\\Documents\\testdata1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet =  workbook.getSheetAt(2);
        int rowCounts = sheet.getPhysicalNumberOfRows();
        XSSFRow row = sheet.getRow(0);
        int colCount = row.getLastCellNum();
        Object[][] data = new Object[rowCounts-1][colCount];
        for (int i = 0; i < rowCounts-1; i++) {
            row = sheet.getRow(i+1);        // Skip header row (i+1)
            if (row == null ) {
                // Skip null rows or handle as needed
                continue;
            }
                for (int j = 0; j < colCount; j++) {
                    XSSFCell cell = row.getCell(j, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                    if (cell != null) {
                        data[i][j] = formatter.formatCellValue(cell);
                    } */
/*else {
                        data[i][j] = "";  // or null, depending on your needs
                    }*//*

            }
        }
        workbook.close();
        fis.close();
        return data;
    }


}
*/

package FrameworkApacha_POI_API;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class dataProvider {

    DataFormatter formatter = new DataFormatter();

    @Test(dataProvider = "driveTest")
    public void testCaseData(String greeting, String communication, String id) {
        System.out.println(greeting + " " + communication + " " + id);
    }

    @DataProvider(name = "driveTest")
    public Object[][] getData() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\abbey\\Documents\\testdata1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(2); // Change sheet index as needed

        int rowCount = sheet.getPhysicalNumberOfRows();
        XSSFRow headerRow = sheet.getRow(0);
        int colCount = headerRow.getLastCellNum();

        List<Object[]> dataList = new ArrayList<>();

        for (int i = 1; i < rowCount; i++) { // start from row 1 (skip header)
            XSSFRow row = sheet.getRow(i);
            if (row == null || rowIsEmpty(row)) {
                continue; // skip null or empty rows
            }

            Object[] rowData = new Object[colCount];
            for (int j = 0; j < colCount; j++) {
                XSSFCell cell = row.getCell(j, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                rowData[j] = (cell != null) ? formatter.formatCellValue(cell) : "";
            }
            dataList.add(rowData);
        }

        workbook.close();

        // Convert List to Object[][]
        Object[][] dataArray = new Object[dataList.size()][colCount];
        for (int i = 0; i < dataList.size(); i++) {
            dataArray[i] = dataList.get(i);
        }

        return dataArray;
    }

    private boolean rowIsEmpty(Row row) {
        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            if (row.getCell(c, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL) != null) {
                return false;
            }
        }
        return true;
    }
}
