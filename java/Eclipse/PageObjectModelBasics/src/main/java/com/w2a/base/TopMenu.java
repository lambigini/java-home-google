package com.w2a.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.ClickAction;

import com.w2a.pages.crm.accounts.AccountsPage;

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

	public AccountsPage gotoAccounts() {
		Page.click("accountstab_XPATH");
		//driver.findElement(By.cssSelector("#tab_Accounts")).click();

		return new AccountsPage();
	}

	public void gotoContacts() {

	}

	public void signOut() {

	}



}
