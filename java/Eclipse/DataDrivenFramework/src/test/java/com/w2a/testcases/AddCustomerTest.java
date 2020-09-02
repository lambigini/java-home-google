package com.w2a.testcases;


import org.testng.annotations.Test;

import org.openqa.selenium.Alert;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class AddCustomerTest extends TestBase {

	@Test (dataProviderClass = TestUtil.class ,dataProvider = "dp")
	public void addCustomer(String firstName, String lastName, String postalCode, String alertText) throws InterruptedException {
		click("bmlBtn_CSS");
		click("addCustBtn_CSS");
		type("firstname_CSS", firstName);
		type("lastname_XPATH", lastName);
		type("postcode_CSS", postalCode);
		click("addbtn_CSS");
		
		wait = new WebDriverWait(driver, 5);
		
	Alert alert =	wait.until(ExpectedConditions.alertIsPresent());
	Assert.assertTrue(alert.getText().contains(alertText));
	
	Thread.sleep(2000);
	alert.accept();
	Thread.sleep(2000);
	
	Assert.fail("add customer not succeful");
	}
	
	
	
}
