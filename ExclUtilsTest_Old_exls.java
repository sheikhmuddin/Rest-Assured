package utils;

public class ExclUtilsTest_Old_exls {
	
	public static void main(String[] args) {
		
	String excelsPath="./TestData/TestDataPal.xls";
	String sheetName="Sheet1";
	
	ExcelUtils_old_format excels =new ExcelUtils_old_format(excelsPath, sheetName);
	excels.getRowCount();
	//excels.getCellData(rowNum,colNum);
	excels.getCellData(1,0);
	excels.getCellData(1,1);
	excels.getCellData(1,2);
	}
}
