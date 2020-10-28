

package com.w2a.base;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.ExtentManager;
import com.w2a.utilities.TestUtil;

public class TestBase {
	/*
	 * WebDriver
	 * Properties
	 * Logs - log4j jar, .log, log4j.properties, Logger
	 * ExtentReports
	 * DB
	 * Excel
	 * Mail
	 * ReportNG, ExtentReports
	 * Jenkins
	 * 
	 */

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = org.apache.log4j.Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "/src/test/resources/excel/testData.xlsx");
	public static WebDriverWait wait ;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
	
	public void click(String locator) {
		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
			test.log(LogStatus.INFO, "click on " + locator);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
			test.log(LogStatus.INFO, "click on " + locator);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
			test.log(LogStatus.INFO, "click on " + locator);
		}
		
	}
	
	public void type(String locator, String value) {
		
		if(locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
			test.log(LogStatus.INFO, "type in " + locator +" enter value as " + value);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
			test.log(LogStatus.INFO, "type in " + locator +" enter value as " + value);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
			test.log(LogStatus.INFO, "type in " + locator +" enter value as " + value);
		}
		
	}
	
public static void verifyEqual(String expected, String actual) throws IOException {
	try {
		Assert.assertEquals(actual, expected);
	} catch ( Throwable t) {
		
		TestUtil.captureScreenshot();
		//report ng
		
		Reporter.log("<br>" + "Verification failure: " +t.getMessage() + "br");
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+"></img></a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		
		//extent reports
		test.log(LogStatus.FAIL, " Verificatin failed with exception" +  t.getMessage());
		
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
		
	}
}

static WebElement dropdown;

public void select(String locator, String value) {
	
	if(locator.endsWith("_CSS")) {
		
		dropdown = 	driver.findElement(By.cssSelector(OR.getProperty(locator)));
		
	} else if (locator.endsWith("_XPATH")) {
		dropdown = 	driver.findElement(By.xpath(OR.getProperty(locator)));
	} else if (locator.endsWith("_ID")) {
		dropdown = 	driver.findElement(By.id(OR.getProperty(locator)));
	}
	
	Select select = new Select(dropdown);
	
	select.selectByVisibleText(value);
	test.log(LogStatus.INFO, "select from dropdown" + locator + " value as " + value);
}

public static Boolean isElementPresent(By by) {
	
	
	try {
		driver.findElement(by);
		return true;
	} catch (NoSuchElementException e) {
		return false;
	}
}

	
	@BeforeMethod
	@BeforeSuite
	public void setUp() throws IOException {

		if (driver == null) {
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/Config.properties");
			config.load(fis);
			log.debug("config file loaded");


			fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/OR.properties");
			OR.load(fis);
			log.debug("OR file loaded");
		}
		
		if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {
			
			browser = System.getenv("browser");
			
		} else {
			
			browser = config.getProperty("browser");
		}
		
		config.setProperty("browser", browser);

		if (config.getProperty("browser").equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/executables/geckodriver");
			driver = new FirefoxDriver();

		} else if (config.getProperty("browser").equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/executables/chromedriver");
			driver = new ChromeDriver();
			log.debug("Chrome launched");

		}

		driver.get(config.getProperty("testsiteurl"));
		log.debug("Navigated to: " + config.getProperty("testsiteurl"));
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
		//wait = new WebDriverWait(driver, 5);
	}
	


	
	@AfterMethod
	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
		
		log.debug("Test excecute completed");
	}
	
	


}