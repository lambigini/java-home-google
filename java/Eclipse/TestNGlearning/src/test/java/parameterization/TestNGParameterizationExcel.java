package parameterization;

import java.util.Hashtable;
import java.util.Set;

import org.apache.poi.ss.formula.functions.Rows;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.Table;

public class TestNGParameterizationExcel {

	public static ExcelReader exel = null;
	
	
	
	
	@Test(dataProvider = "getData")
	public void testData(Hashtable<String, String> data) {
		System.out.println(data.get("username")+ "---" + data.get("password") + "---" + data.get("is_correct"));
	}
	
	@DataProvider 
	public Object[][] getData() {
		
		if (exel == null) {
			exel = new ExcelReader("/Users/harrisontranimac/Desktop/testData/TestDataExcel.xlsx");
		}
		
		String sheetName="loginTest";
		int rows =  exel.getRowCount(sheetName);
		int columns = exel.getColumnCount(sheetName);
		
		
		
		Object[][] data = new Object[rows -1][1];
		Hashtable<String, String> table = null;
				
				
		for (int rowNums = 2; rowNums <= rows; rowNums++) {
			
			table = new Hashtable<String, String>();
			
			for (int colNUm = 0; colNUm < columns; colNUm++) {
//			data[rowNums -2][colNUm] =	exel.getCellData(sheetName, colNUm, rowNums);
				table.put(exel.getCellData(sheetName, colNUm, 1), exel.getCellData(sheetName, colNUm, rowNums));
				data[rowNums-2][0] = table;
		
			}
			

			
		}
	
		
	

		return data;
	}
}
