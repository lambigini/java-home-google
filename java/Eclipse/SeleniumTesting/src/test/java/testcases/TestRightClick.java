package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRightClick {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver  driver = new ChromeDriver();
		

		
		driver.get("http://deluxe-menu.com/popup-mode-sample.html");

	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	WebElement rightClickElement = driver.findElement(By.xpath("//p[contains(text(),'Click the image to show the menu')]"));
	
	Actions actions = new Actions(driver);
	
	actions.contextClick(rightClickElement).perform();
	
	WebElement productInfoElement = driver.findElement(By.xpath("//td[@id='dm2m1i1tdT']"));
	actions.moveToElement(productInfoElement).perform();
	actions.moveToElement(driver.findElement(By.xpath("//img[@id='dm2m2i1ddiI']"))).perform();

	driver.findElement(By.xpath("//td[@id='dm2m3i1tdT']")).click();
	
	
		Thread.sleep(5000);
		driver.quit();

	}

}
