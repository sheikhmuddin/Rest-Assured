package utils;

import java.io.IOException;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils_V1 {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	// remove this if it not working  (ExcelUtils_V1) 
	public ExcelUtils_V1(String excelsPath, String sheetName) {
		try {
			 workbook= new XSSFWorkbook(excelsPath);
		    sheet=workbook.getSheet(sheetName);
			
		} catch (Exception exp) {
			System.out.println(exp.getLocalizedMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		
		
	}
	
 	public static void main(String[] args) {
		getRowCount();
		getCellData();
		
	}
	
	public static void getCellData() {
		
		try {
			String excelsPath="./TestData/TestDataPal.xlsx";
			
			XSSFWorkbook workbook= new XSSFWorkbook(excelsPath);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			
			DataFormatter formatter= new DataFormatter();
			Object value=formatter.formatCellValue(sheet.getRow(1).getCell(1));
			
					
			//double  value=sheet.getRow(1).getCell(0).getStringCellValue();   no need
			System.out.println(value);
			
		}catch (Exception exp) {
			System.out.println(exp.getLocalizedMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		
	}
	
	public static void getRowCount() {
		
		try {
//			don't need
//			String proPath=System.getProperty("user.dir");
//			System.out.println(proPath);
//			
			//String excelsPath=proPath+"./TestData/TestDataPal.xlsx";
			String excelsPath="./TestData/TestDataPal.xlsx";
			
			XSSFWorkbook workbook= new XSSFWorkbook(excelsPath);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			int rowcount=sheet.getPhysicalNumberOfRows();
			System.out.println("Num ber of row:  "+rowcount);
			
		} catch (Exception exp) {
			System.out.println(exp.getLocalizedMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}

}
