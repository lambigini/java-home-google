package com.w2a.base;

import java.awt.Menu;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.ExtentManager;

import com.w2a.utilities.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page {
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = org.apache.log4j.Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "/src/test/resources/com/w2a/excel/testData.xlsx");
	public static WebDriverWait wait ;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
	public static TopMenu menu;
	
	public Page() {
		
		if (driver == null) {
			
			if (driver == null) {
				try {
					fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/com/w2a/properties/Config.properties");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					config.load(fis);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				log.debug("config file loaded");


				try {
					fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/com/w2a/properties/OR.properties");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					OR.load(fis);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				log.debug("OR file loaded");
			}
			
			//Jenkins Browser filter configuration
			
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
			
			WebDriverManager.chromedriver().setup();
			
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			
			 driver = new ChromeDriver(options);
			
			
			
		}
			driver.get(config.getProperty("testsiteurl"));
			log.debug("Navigated to: " + config.getProperty("testsiteurl"));
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 5);
			
			menu = new TopMenu(driver);
		
	}

	
	
}
	
	public static void quit() {
		driver.quit();
	}
	
	
	// common keyword
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
		
		Utilities.captureScreenshot();
		//report ng
		
		Reporter.log("<br>" + "Verification failure: " +t.getMessage() + "br");
		Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+"><img src="+Utilities.screenshotName+"></img></a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		
		//extent reports
		test.log(LogStatus.FAIL, " Verificatin failed with exception" +  t.getMessage());
		
		test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenshotName));
		
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

public boolean isElementPresent(By by) {

	try {

		driver.findElement(by);
		return true;

	} catch (NoSuchElementException e) {

		return false;

	}

}
}
