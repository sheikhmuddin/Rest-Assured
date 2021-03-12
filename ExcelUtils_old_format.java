package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.stream.FileImageInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils_old_format {
	static HSSFWorkbook workbook;
	static HSSFSheet sheet;
	
	public ExcelUtils_old_format(String excelsPath, String sheetName) {
		try {
			
			InputStream file= new FileInputStream(excelsPath);
			
			 workbook= new HSSFWorkbook(new POIFSFileSystem(file));
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
