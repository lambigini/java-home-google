package testcases;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.omg.CORBA.Current;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver  driver = new ChromeDriver();
	
		
		driver.get("https://www.jobserve.com/in/en/Job-Search/");

//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[contains(text(),'27 Industries Selected')]")).click();
		driver.findElement(By.xpath("//input[@id='ddcl-selInd-i0']")).click();

		List<WebElement>  allIndustriesElements = driver.findElements(By.xpath("//div[@id='industryDisplay']/div/div/div/label"));
		String industry = "Education";
		for (WebElement webElement : allIndustriesElements) {
//			System.out.println(webElement.getText());
		if (webElement.getText().equalsIgnoreCase(industry))
		webElement.click();
		}
		
			//	driver.close();
	
	}

}
