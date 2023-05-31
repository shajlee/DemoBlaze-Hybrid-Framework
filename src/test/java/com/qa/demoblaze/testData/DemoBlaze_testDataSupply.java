package com.qa.demoblaze.testData;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DemoBlaze_testDataSupply {
	public static Properties dataprop;
	public static FileInputStream ip;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	
	public DemoBlaze_testDataSupply() throws Exception {
		dataprop = new Properties();
		FileInputStream ip1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\demoblaze\\properties\\demoblazetestData.properties");
		dataprop.load(ip1);
	}

	@DataProvider(name = "demoBlazeDataProviderSupply") 
	public static Object[][] dataSupplyFrom2DimentionalObjectArray() {
		Object[][] data = {{dataprop.getProperty("dataProvideUsername1"), dataprop.getProperty("dataProvidePassword1")},
				            {dataprop.getProperty("dataProvideUsername2"), dataprop.getProperty("dataProvidePassword2")},
			                {dataprop.getProperty("dataProvideUsername3"), dataprop.getProperty("dataProvidePassword3")}};
		return data;
}
	
	@DataProvider(name = "demoBlazeExcelDataWithDataProvider")
	public static Object[][] excelSheetDataSupply() throws Exception{
	Object[][] data = DemoBlaze_testDataSupply.getDemoBlazeTestDataFromExcellSheet("Login");
	return data;
}

	public static Object[][] getDemoBlazeTestDataFromExcellSheet(String sheetName) throws Exception{
	ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\qa\\demoblaze\\testData\\DemoBlaze TestData.xlsx");
	workbook = new XSSFWorkbook(ip) ;
	sheet = workbook.getSheet(sheetName);
	int rows = sheet.getLastRowNum();
	int cols = sheet.getRow(0).getLastCellNum();
	
	Object[][] data = new Object[rows][cols];
	
	for(int i=0; i<rows; i++) {
		XSSFRow row = sheet.getRow(i+1);
		 
		for(int j=0; j<cols; j++) {
			XSSFCell cell = row.getCell(j);
			CellType celltype = cell.getCellType();
			
			switch(celltype) {
			
			case STRING:
				data[i][j] = cell.getStringCellValue();
				break;
				
			case NUMERIC:
				data[i][j] = Integer.toString((int)cell.getNumericCellValue());
				break;
				
			case BOOLEAN:
				data[i][j] = cell.getBooleanCellValue();
				break;
			}
		}
	}
	return data;
	
	
	
		
	}
}
	





