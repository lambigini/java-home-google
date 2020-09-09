
package com.w2a.testcases;


import org.testng.annotations.Test;

import java.util.Hashtable;

import org.openqa.selenium.Alert;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class AddCustomerTest extends TestBase {

	@Test (dataProviderClass = TestUtil.class ,dataProvider = "dp")
	public void addCustomerTest (Hashtable<String, String> data) throws InterruptedException {		
		
	if(!data.get("runmode").equals("Y")){
		
		throw new SkipException("Skipping the test case as the Run mode for data set is NO");
	}
	
		click("bmlBtn_CSS");
		click("addCustBtn_CSS");
		type("firstname_CSS",data.get("firstName") );
		type("lastname_XPATH",data.get("lastName") );
		type("postcode_CSS",data.get("postalCode") );
		click("addbtn_CSS");
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, 5);
		
	Alert alert =	wait.until(ExpectedConditions.alertIsPresent());
	Assert.assertTrue(alert.getText().contains(data.get("alerttext") ));
	Thread.sleep(2000);
	//driver.switchTo().alert().accept();
	alert.accept();

	Thread.sleep(2000);
	
	}
	
	
	
}