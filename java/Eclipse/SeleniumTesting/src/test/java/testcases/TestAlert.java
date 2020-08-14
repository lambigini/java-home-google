package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAlert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver  driver = new ChromeDriver();
		
		driver.get("http://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("proceed")).click();;
		
//	Alert alert =	driver.switchTo().alert();
//
//	System.out.println(alert.getText());
//	alert.accept();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
	Alert alert =	wait.until(ExpectedConditions.alertIsPresent());
	
	System.out.println(alert.getText());
	alert.accept();
	
		Thread.sleep(5000);
		driver.quit();

	}
}
