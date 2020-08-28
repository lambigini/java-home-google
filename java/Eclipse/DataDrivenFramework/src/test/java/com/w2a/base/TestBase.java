package com.w2a.base;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.w2a.utilities.ExcelReader;

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

	}
	
	public static Boolean isElementPresent(By by) {
		
		
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
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
