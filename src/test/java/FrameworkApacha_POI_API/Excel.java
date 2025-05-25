package FrameworkApacha_POI_API;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Excel {

    @Test
    public void excelTest() throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\abbey\\Documents\\testdata1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheets =  workbook.getSheetAt(2);
        int rowCounts = sheets.getPhysicalNumberOfRows();
        XSSFRow row = sheets.getRow(0);
        int colCount = row.getLastCellNum();
        Object[][] data = new Object[rowCounts-1][colCount];
        for (int i = 0; i < rowCounts; i++) {
            System.out.println("outer loop started");
            row = sheets.getRow(i+1);
            for (int j = 0; j < colCount; j++) {
                //row.getCell(j);
               // System.out.println(row.getCell(j));
            }
            System.out.println("outer loop ended");
        }
    }
}

//Object[][] data={{"hello","text",1},{"bye","message",143},{"solo","call",453}};
// every row of excel should be seent to 1 array
//        data[0][0] = "hello";
//        data[0][1] = "text";
//        data[0][2] = "1";
//
//        data[1][0] = "bye";
//        data[1][1] = "message";
//        data[1][2] = "143";
//
//        data[2][0] = "solo";
//        data[2][1] = "call";
//        data[2][2] = "453";
