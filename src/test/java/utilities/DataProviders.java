package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		
		String path = ".\\testData\\LoginDetails.xlsx";
		
		ExcelUtility xlUtil = new ExcelUtility(path);
		
		int totalRows = xlUtil.getRowCount("Sheet1");
		int totalCells = xlUtil.getCellCount("Sheet1", 1);
		
		String[][] loginData = new String[totalRows][totalCells];
		
		for(int i=1; i<=totalRows; i++) {
			for(int j=0; j<totalCells; j++) {
				loginData[i-1][j] = xlUtil.getCellData("Sheet1", i, j);
			}
		}
		
		return loginData;
	}
}
