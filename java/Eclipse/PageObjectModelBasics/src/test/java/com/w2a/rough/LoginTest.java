 package com.w2a.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.w2a.pages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
public static void main(String[] args) {
	
	WebDriverManager.firefoxdriver().setup();
	
	WebDriver driver = new FirefoxDriver();
	driver.get("https://www.zoho.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	HomePage home = new HomePage();
	home.goToLogin();
	lm
	driver.quit();
}
}
