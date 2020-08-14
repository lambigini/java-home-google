package testcases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTabAndPopUp {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver  driver = new ChromeDriver();
		
		driver.get("https://bettermoneyhabits.bankofamerica.com/en");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//first window
		System.out.println("first window ----------------------");
		Set<String> windowIdSet = driver.getWindowHandles();         
		Iterator<String> iterator =  windowIdSet.iterator();
		String firstWindowString = iterator.next();
		System.out.println(firstWindowString);
		
		
		driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
	 	
		
		//second window
		
		windowIdSet = driver.getWindowHandles();
		iterator =  windowIdSet.iterator();
		System.out.println(iterator.next());
		String SecondWindowString = iterator.next();
		System.out.println(SecondWindowString);
		
		
		driver.switchTo().window(SecondWindowString);
		System.out.println("second window ----------------------");
		System.out.println(driver.getTitle().contains("Sign in to Bank of America Online")); 
		driver.findElement(By.xpath("//a[@id='locations-route-to']")).click();
		 
		

		 driver.switchTo().window(firstWindowString);
		 System.out.println("first window ----------------------");
		Thread.sleep(5000);
		driver.quit();
	}

}
