package parallelTest;

import java.util.Date;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParallelDP {
	
	@Test(dataProvider = "getData")
	public void testLogin(String browser) throws InterruptedException {
		
		Date date = new Date();
		
		System.out.println("browser name " + browser + date);
		Thread.sleep(2000);
	}
	
	@DataProvider (parallel = true)
	public Object[][] getData() {
		
		Object[][] data = new Object[2][1];
		
		data[0][0] = "chrome";
		data[1][0] = "firefox";
		return data;
		
	}
}
