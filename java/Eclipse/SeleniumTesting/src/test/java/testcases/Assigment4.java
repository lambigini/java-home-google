package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assigment4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver  driver = new ChromeDriver();
		

		
		driver.get("https://jqueryui.com/resources/demos/resizable/default.html");

	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		for (int i = 300; i < 900; i+= 50) {
		Dimension	dimension = new Dimension(i, i);
			driver.manage().window().setSize(dimension);
			Thread.sleep(300);
		}
		
		

		Thread.sleep(5000);
		driver.quit();

	}

}
