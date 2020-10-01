package com.w2a.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopMenu {
	
	WebDriver driver;
	
	public TopMenu (WebDriver driver) {
		
		this.driver = driver;
		
	}

	public void gotoHome() {

	}

	public void gotoFeeds() {

	}

	public void gotoLeads() {

	}

	public void gotoAccounts() {
		
		driver.findElement(By.cssSelector("#tab_Accounts")).click();

	}

	public void gotoContacts() {

	}

	public void signOut() {

	}



}
