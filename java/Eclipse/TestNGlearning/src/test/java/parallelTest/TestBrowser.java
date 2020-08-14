package parallelTest;



import java.util.Date;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestBrowser {

	@Parameters({"browser"})
	@Test
	public void testLogin(String browser) throws InterruptedException {
		
		Date date = new Date();
		
		System.out.println("browser name " + browser + date);
		Thread.sleep(2000);
	}
}
