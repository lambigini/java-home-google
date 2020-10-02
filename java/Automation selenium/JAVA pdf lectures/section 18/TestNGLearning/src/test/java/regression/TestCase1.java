package regression;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 {
	
	@BeforeTest
	public void createDBConn() {
		
		System.out.println("Creating db conn");
	}
	
	@AfterTest
	public void closeDBConn() {
		
		System.out.println("Closing DB Conn");
	}
	
	@BeforeMethod
	public void launchBrowser() {
		
		System.out.println("Launching browser");
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		
		System.out.println("Closing the browser");
	}
	
	@Test(priority=1)
	public void doUserReg() {
		
		System.out.println("Executing User Reg test");
		
	}
	
	@Test(priority=2)
	public void doLogin() {
		
		System.out.println("Executing login test");
		
	}
	
	
	

}
