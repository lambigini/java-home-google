package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMouseOver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver  driver = new ChromeDriver();
		

		
		driver.get("https://google.com");

//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.name("q")).sendKeys("way2automation");
		driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']")).click();
		
		driver.findElement(By.xpath("//div[@class='g']//div//div[@class='rc']//h3[@class='LC20lb DKV0Md'][contains(text(),'Way2Automation')]")).click();

		Actions actions = new Actions(driver);
		  WebElement resourceMenu =  driver.findElement(By.xpath("//a[contains(text(),'Resources')]"));
		actions.moveToElement(resourceMenu).perform();;
		driver.findElement(By.partialLinkText("Practice site 1")).click();
	}

}
