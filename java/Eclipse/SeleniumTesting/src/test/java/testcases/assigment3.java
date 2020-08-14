package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class assigment3 {

	private static long x;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver  driver = new ChromeDriver();
		

		
		driver.get("https://timesofindia.indiatimes.com/poll.cms");

//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String que = driver.findElement(By.xpath("//*[@id=\"mathq2\"]")).getText();

		String[] question = que.split(" ");
		for (String string : question) {
			System.out.println(string);
		}

		//Performing operations

		if(question[1].equalsIgnoreCase("+")) {

		x = Long.parseLong(question[0]) + Long.parseLong(question[2]);

		}else if(question[1].equalsIgnoreCase("-")) {

		x = Long.parseLong(question[0]) - Long.parseLong(question[2]);

		}else {

		x = Long.parseLong(question[0]) * Long.parseLong(question[2]);

		}

		String str = Long.toString(x);

		//Setting answer to captch result box

		driver.findElement(By.xpath("//*[@id=\"mathuserans2\"]")).sendKeys(str);
		
	// SECOND WAY TO SOLVE IT	
//		String text = driver.findElement(By.xpath("//*[@id=\"mathq2\"]")).getText();
//        String[] values =text.split(" ");
//        
//        int numberOne = Integer.valueOf(values[0]);
//        int numberTwo = Integer.valueOf(values[2]);
//        String islem = values[1];
//        int total = 0;
// 
//        switch (islem) {
//            case "+":
//                total = numberOne + numberTwo;
//                break;
//            case "-":
//                total = numberOne - numberTwo;
//                break;
//            case "*":
//                total = numberOne * numberTwo;
//                break;
//        }
// 
//        driver.findElement(By.xpath("//*[@id=\"mathuserans2\"]")).sendKeys(String.valueOf(total));
 

	}
}
