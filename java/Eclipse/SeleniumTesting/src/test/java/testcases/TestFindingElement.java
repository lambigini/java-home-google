package testcases;

import java.time.Duration;



import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestFindingElement {
	

	public static void main(String[] args) {
		
 		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
//		
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://gmail.com");

//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//	WebDriverWait wait = new WebDriverWait(driver, 7);
		
		  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(30))
			       .pollingEvery(Duration.ofSeconds(5))
			       .withMessage("User define method: Time out")
			       .ignoring(NoSuchElementException.class);
			       
		
		//driver.findElement(By.cssSelector("#identifierId")).sendKeys("lambigini87@gmail.com");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#identifierId"))).sendKeys("lambigini87@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();
		

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("dfgdg");
		
		//driver.findElement(By.name("password")).sendKeys("dfgdgdfg");
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/span/span")).click();
//		System.out.println(driver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]/div[2]/span")).getText());
		System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]/div[2]/span"))).getText());
	}

}
