package FrameworkApacha_POI_API;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.Iterator;

public class Data {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\abbey\\Documents\\testdata1.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            int sheets =  workbook.getNumberOfSheets();
            System.out.println("Total sheets: " + sheets);

            for (int i = 0; i < sheets; i++) {
                String sheetName = workbook.getSheetName(i);
                System.out.println("Sheet #" + i + ": " + sheetName);

                if (sheetName.equalsIgnoreCase("sample")) {
                    System.out.println("Found target sheet: " + sheetName);

                    XSSFSheet sheet = workbook.getSheetAt(i);
                    Iterator<Row> rows = sheet.iterator();
                    if (!rows.hasNext()) {
                        System.out.println("Sheet is empty.");
                        return;
                    }

                    Row firstRow = rows.next();
                    Iterator<Cell> ce = firstRow.cellIterator();
                    int k = 0;
                    int column = -1;

                    while (ce.hasNext()) {
                        Cell cell = ce.next();
                        String cellValue = cell.getStringCellValue();
                        System.out.println("Checking cell: '" + cellValue + "' at index " + k);

                        if (cellValue.equalsIgnoreCase("TestCases")) {
                            column = k;
                            System.out.println("Found 'Data1' at column index: " + column);
                        }
                        k++;
                    }

                    if (column == -1) {
                        System.out.println("'Data1' column not found.");
                    }

                    // Print the final column index
                    System.out.println("Final column index: " + column);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
