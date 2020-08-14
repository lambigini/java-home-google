package testcases;


import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestElementScreenShot {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver  driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"hplogo\"]/div[2]"));
		
	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	
	BufferedImage fullImage = ImageIO.read(screenshotFile);
	
	org.openqa.selenium.Point point = element.getLocation();
	
	 int imageWidth =  element.getSize().getWidth();
	 
	 int imageHeight = element.getSize().getHeight();
	 
	 BufferedImage subImage = fullImage.getSubimage(point.x, point.y, imageWidth, imageHeight);
	 
	ImageIO.write(subImage, "jpg", screenshotFile);
	 
	 FileUtils.copyFile(screenshotFile , new File("./screenshot/logo123.jpg" ));
		

	
	
		Thread.sleep(5000);
		driver.quit();
	}

}
