package utils;

import java.io.IOException;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelsPath, String sheetName) {
		try {
			 workbook= new XSSFWorkbook(excelsPath);
		    sheet=workbook.getSheet(sheetName);
			
		} catch (Exception exp) {
			System.out.println(exp.getLocalizedMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		 
	}
	
 	
	public static void getCellData(int rowNum, int colNum) {
	 
			DataFormatter formatter= new DataFormatter();
			Object value=formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
			System.out.println(value);
		 
	}
	
	public static void getRowCount() {
		
			int rowcount=sheet.getPhysicalNumberOfRows();
			System.out.println("Num ber of row:  "+rowcount);
			 
	}

}
