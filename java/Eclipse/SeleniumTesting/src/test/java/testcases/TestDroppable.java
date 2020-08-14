package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDroppable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver  driver = new ChromeDriver();
		

		
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");

	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	WebElement draggabElement =	driver.findElement(By.id("draggable"));
	WebElement dropableElement =	driver.findElement(By.id("droppable"));
	
	Actions actions = new Actions(driver);
	actions.dragAndDrop(draggabElement, dropableElement).perform();

		Thread.sleep(5000);
		driver.quit();

	}
}
