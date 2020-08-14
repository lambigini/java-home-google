package parameterization;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider( name = "dp1")
	public Object[][] getData(Method m) {
		Object[][] data = null;
		
		if (m.getName().equals("testLogin")) {
			data = new Object[2][2];
			
			data[0][0] = "harrison";
			data[0][1] = "234234";
			
			data[1][0] = "alex";
			data[1][1] = "123456";
		} else if(m.getName().equals("testUserRegis")) {
			 data = new Object[2][3];
			
			data[0][0] = "harrison";
			data[0][1] = "234234";
			data[0][2] = "sfsd@gmail";
			
			data[1][0] = "alex";
			data[1][1] = "123456";
			data[1][2] = "ertre@yahoomail";
		}
		
		
		
		return data;
	}
}
