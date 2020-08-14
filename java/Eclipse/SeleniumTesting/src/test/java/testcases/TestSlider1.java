package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSlider1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver  driver = new ChromeDriver();
		

		
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");

//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement sliderBar = driver.findElement(By.id("slider"));
		 int width =(int) sliderBar.getSize().width;
		
		
	WebElement sliderElement = 	driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
	Actions actions = new Actions(driver);
	
	actions.dragAndDropBy(sliderElement, width/5, 0).perform();
	
	Thread.sleep(500);
	driver.close();
		
	}

}
