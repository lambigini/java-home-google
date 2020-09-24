package com.w2a.pages;

import org.openqa.selenium.By;


import com.w2a.base.Page;

public class ZohoAppPage extends Page {


	public void gotoChat() {

		driver.findElement(By.cssSelector("._logo-chat._logo-x96.zod-app-logo")).click();

	}

	public void gotoCRM() {

		driver.findElement(By.cssSelector("._logo-crm._logo-x96.zod-app-logo")).click();

	}

	public void gotoSaleIQ() {

		driver.findElement(By.cssSelector("#all-apps")).click();

		driver.findElement(By.cssSelector("._logo-x48._logo-salesiq.zod-app-logo")).click();

	}
}
