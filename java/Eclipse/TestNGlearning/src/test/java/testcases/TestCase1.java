package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


public class TestCase1 extends BaseTest{
	@BeforeTest
	public void createDBconn() {
		System.out.println("Creating db conn");
	}
	
	@AfterTest
	public void closeDBconn() {
		System.out.println("Closing db conn");
	}
	
	@BeforeMethod
	public void launchBrowser() {
		System.out.println("Launching browser");
	}
	
	@AfterMethod
	public void closeBrowser() {
		System.out.println("Closing browser");
	}
	
	@Test ( priority = 1, groups = "functional")
	public void doUserReg() {
		System.out.println("Executing User Reg test");
	}
	
	@Test( priority = 2, groups = "functional")
	public void doLogin() {
		System.out.println("Executing login test");
	}
	
	
}
