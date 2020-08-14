package parallelTest;

import org.testng.annotations.Test;

public class TestInvocation extends BaseTest {
	@Test (invocationCount = 3, threadPoolSize = 3 )
	public void executeTest() throws InterruptedException{
//		System.out.println("test");
		driver = getBrowser("chrome");
		
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
//		Thread.sleep(3000);
//		driver.quit();
		
		
	}
}
