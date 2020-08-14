package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestKeyboardEvents {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		WebDriverManager.chromedriver().setup();
//		WebDriver  driver = new ChromeDriver();
//		
//
//		
//		driver.get("http://gmail.com");
//
//	
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//	driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("lambigini87");
//	
////	driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(Keys.ENTER);
//	
//	driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]")).click();
//	
//	Actions action = new Actions(driver);
//	
//	
//	action.keyDown(Keys.CONTROL).sendKeys(Keys.chord("a")).keyUp(Keys.CONTROL).perform();
//	 
//	action.keyDown(Keys.CONTROL).sendKeys(Keys.chord("c")).keyUp(Keys.CONTROL).perform();
//	 
//	        driver.findElement(By.id("identifierId")).click();
//	 
//	        action.keyDown(Keys.CONTROL).sendKeys(Keys.chord("v")).keyUp(Keys.CONTROL).perform();
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://gmail.com");
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
		 driver.findElement(By.id("identifierId")).sendKeys("hasdfjsdf");
		 Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]")).click();
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		 
		Thread.sleep(1000);
		 
		action.keyDown(Keys.COMMAND).sendKeys(Keys.chord("a")).keyUp(Keys.COMMAND).build().perform();
		Thread.sleep(1000);
		 
		action.keyDown(Keys.COMMAND).sendKeys(Keys.chord("c")).keyUp(Keys.COMMAND).build().perform();
		 
		        driver.findElement(By.id("identifierId")).click();
		 
		        action.keyDown(Keys.COMMAND).sendKeys(Keys.chord("v")).keyUp(Keys.COMMAND).build().perform();

 
		

	
	

	
		Thread.sleep(5000);
		driver.quit();

	}

}
