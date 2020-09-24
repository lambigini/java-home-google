package com.w2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.base.Page;

public class LoginPage extends Page {

	
	public void doLogin(String username, String password) {
		driver.findElement(By.cssSelector("#login_id")).sendKeys(username);
		driver.findElement(By.cssSelector("#nextbtn")).click();
		
		
		driver.findElement(By.cssSelector("#password")).sendKeys(password);
		driver.findElement(By.cssSelector("#nextbtn")).click();
		
			
	}
	
	public void gotoSaleandMarketing() {
		
	}
	
	public void gotoFinance() {
		
	}
}
