package Excel_Sheet_Data;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
public class excel_Data_Match {

    private static excel_Data_Match instance = null;
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;

    // Singleton Pattern
    public static excel_Data_Match getInstance() {
        if (instance == null) {
            instance = new excel_Data_Match();
        }
        return instance;
    }

    // Static block to initialize the Excel workbook and sheet
    static {
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\AA\\Downloads\\demo_Excel.xlsx");
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load the Excel file.");
        }
    }

    // Variables to hold Excel data
    static String MU1;
    static String MU2;
    static String MU3;
    static String MU4;
    static String MU5;
    static String MU6;

    @Test(priority=0)
    public void excelData() throws IOException {    	
    	        // Read data from the Excel file
    	        MU1 = sheet.getRow(1).getCell(2).getStringCellValue();
    	        MU2 = sheet.getRow(2).getCell(2).getStringCellValue();
    	        MU3 = sheet.getRow(3).getCell(2).getStringCellValue();
    	        MU4 = sheet.getRow(4).getCell(2).getStringCellValue();
    	        MU5 = sheet.getRow(5).getCell(2).getStringCellValue();

    	        System.out.println("1st Name = " + MU1);
    	        System.out.println("2nd Name = " + MU2);
    	        System.out.println("3rd Name = " + MU3);
    	        System.out.println("4th Name = " + MU4);
    	        System.out.println("5th Name = " + MU5);
    }
    }
	
  
    
 
    
  


