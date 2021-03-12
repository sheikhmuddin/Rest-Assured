package utils;

public class ExclUtilsTest {
	
	public static void main(String[] args) {
		
	String excelsPath="./TestData/TestDataPal.xlsx";
	//String excelsPath="./TestData/TestData1.xlsx";  // this is for test other file
	String sheetName="Sheet1";
	
	ExcelUtils excels =new ExcelUtils(excelsPath, sheetName);
	excels.getRowCount();
	//excels.getCellData(rowNum,colNum);
	excels.getCellData(2,0);
	excels.getCellData(2,1);
	excels.getCellData(2,2);
	}
}
