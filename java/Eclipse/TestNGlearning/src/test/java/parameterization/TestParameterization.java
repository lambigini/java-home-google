package parameterization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterization {

	@Test(dataProvider = "getData")
	public void doLogin(String username, String password) {
		System.out.println(username + "---" + password);
	}
	
	@DataProvider 
	public Object[][] getData() {
		
		Object[][] data = new Object[3][2];
		data[0][0] = "harrison";
		data[0][1] = "tran";
		
		data[1][0] = "alex";
		data[1][1] = "dsf";
		
		data[2][0] = "buyhouse";
		data[2][1] = "234";
		return data;
	}
}
