package FrameworkApacha_POI_API;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public class DataDriven{

    public ArrayList<String> getDataDriven(String testcaseName) throws IOException {
        //fileInputStream argument
        ArrayList<String> a = new ArrayList<>();
        FileInputStream fis = new FileInputStream("C:\\Users\\abbey\\Documents\\testdata1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int sheets =  workbook.getNumberOfSheets();
        for (int i = 0; i < sheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("sample")){
                XSSFSheet sheet = workbook.getSheetAt(i);
                //Identify Testcases column by scanning the entire 1st row
                Iterator<Row> rows = sheet.iterator();  //sheet is collection of rows
                // Find Testcases column
                Row firstRow = rows.next();
                Iterator<Cell> ce = firstRow.cellIterator(); // row is collection of cells
                int k = 0;
                int column = 0;
                while (ce.hasNext()){
                    Cell cell = ce.next();
                    if(cell.getStringCellValue().equalsIgnoreCase("Testcases")){
                        //desire column
                        column = k;
                        break;
                    }
                    k++;
                }
                System.out.println(column);

                //once column is identified then scan the entire testcase column to identify purchase testcase row
                while (rows.hasNext()){
                    Row row = rows.next();
                    if(row.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)){
                        //after you grab the purchase testcae row = pull all the data of that row and feed into test
                        Iterator<Cell> cv = row.cellIterator();
                        while (cv.hasNext()){
                            Cell cel = cv.next();
                            if (cel.getCellType()== CellType.STRING){
                                a.add(cel.getStringCellValue());
                            } else if (cel.getCellType()== CellType.NUMERIC){
                                // because the method getdata is arraylist<String>
                                a.add(NumberToTextConverter.toText(cel.getNumericCellValue()));
                            }
                        } break;
                    }
                }
            };
        }
        return a;
    }
}
