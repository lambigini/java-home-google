package com.w2a.testcases;


import org.testng.annotations.Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;


import com.w2a.base.TestBase;

public class AddCustomerTest extends TestBase {

	@Test (dataProvider = "getData")
	public void addCustomer(String firstName, String lastName, String postalCode, String alertText) throws InterruptedException {
		driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		driver.findElement(By.cssSelector(OR.getProperty("addCustBtn"))).click();
		driver.findElement(By.cssSelector(OR.getProperty("firstname"))).sendKeys(firstName);
		driver.findElement(By.cssSelector(OR.getProperty("lastname"))).sendKeys(lastName);
		driver.findElement(By.cssSelector(OR.getProperty("postcode"))).sendKeys(postalCode);
		driver.findElement(By.cssSelector(OR.getProperty("addbtn"))).click();
		
		wait = new WebDriverWait(driver, 5);
		
	Alert alert =	wait.until(ExpectedConditions.alertIsPresent());
	Assert.assertTrue(alert.getText().contains(alertText));
	
	Thread.sleep(2000);
	alert.accept();
	Thread.sleep(2000);
	
	Assert.fail("add customer not succeful");
	}
	
	@DataProvider
	
	public Object[][] getData() {
		
		String sheetName = "AddCustomerTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][cols];
		
		for (int rowNum = 2; rowNum <= rows; rowNum++) { //2
			
			for (int colNum = 0; colNum < cols; colNum++) {
				//data[0][0]
				data[rowNum-2][colNum] = excel.getCellData(sheetName, colNum, rowNum); 
			}
			
		}
		
		return data;
	}
	
}
