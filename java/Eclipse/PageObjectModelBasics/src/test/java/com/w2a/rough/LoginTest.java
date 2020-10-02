package com.w2a.rough;

import com.w2a.base.Page;
import com.w2a.pages.HomePage;
import com.w2a.pages.LoginPage;
import com.w2a.pages.ZohoAppPage;
import com.w2a.pages.crm.accounts.AccountsPage;
import com.w2a.pages.crm.accounts.CreateAccountPage;


public class LoginTest extends Page {

	public static void main(String[] args) throws InterruptedException {


		HomePage home = new HomePage();
		
		LoginPage lp = home.goToLogin();


		ZohoAppPage zp = lp.doLogin("support@wonpros.com", "100Millionby2030");

		zp.gotoCRM();


		AccountsPage account =	Page.menu.gotoAccounts();


		CreateAccountPage cap = account.gotoCreateAccounts();

		cap.createAccount("Raman");

		Thread.sleep(4000);
		driver.quit();
	}
}
