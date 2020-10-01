 package com.w2a.rough;

import com.w2a.base.Page;
import com.w2a.pages.HomePage;
import com.w2a.pages.LoginPage;
import com.w2a.pages.ZohoAppPage;


public class LoginTest extends Page {
	
public static void main(String[] args) throws InterruptedException {
	
	
	HomePage home = new HomePage();
	home.goToLogin();
	
	
	LoginPage loginPage = new LoginPage();
	loginPage.doLogin("harrison.tran@mfactors.com", "Emvatoi2018");
	
	ZohoAppPage zp = new ZohoAppPage();
	zp.gotoCRM();
	
	
	Page.menu.gotoAccounts();
	
	Thread.sleep(4000);
	driver.quit();
}
}
