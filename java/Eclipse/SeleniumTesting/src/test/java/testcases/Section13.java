package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Section13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		
		ChromeOptions opsChromeOptions = new ChromeOptions();
		opsChromeOptions.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();	

		WebDriver driver = null;	
		
		driver = new ChromeDriver(opsChromeOptions);

		driver.get("http://cleartrip.com");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@class='display']//form//input")).click();
		
		System.out.println(driver.switchTo().alert().getText());
	
	}

}
