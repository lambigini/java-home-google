package com.w2a.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page {
	
	public static WebDriver driver;
	
	public Page() {
		
		if (driver == null) {
			
			WebDriverManager.firefoxdriver().setup();
			
			 driver = new FirefoxDriver();
			
			driver.get("https://www.zoho.com/");
			
			//driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}
		
		
	}

	
	
	
	
}
