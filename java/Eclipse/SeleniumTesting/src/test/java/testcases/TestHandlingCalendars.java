package testcases;


import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestHandlingCalendars {

	static int targetDay = 0, targetMonth = 0, targetYear = 0;
	static int currentDay = 0, currentMonth = 0, currentYear = 0;

	static int jumpMonthsBy = 0;

	static boolean increment = true;

	public static void main(String[] args) throws InterruptedException {

		String dateToSetString = "16/10/2015";

		GetCurrentDateMonthAndYear();

		System.out.println(currentDay + " " + currentMonth + " " + currentYear);
		
		GetTargetDayMonthAndYear(dateToSetString);
		
		System.out.println(targetDay + " " + targetMonth + " " + targetYear);
		
		 CalculateHowManyMonthsToJump();
		 System.out.println(jumpMonthsBy);
		System.out.println(increment);
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver  driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> framesElements1 =	driver.findElements(By.tagName("iframe"));
		
		System.out.println(framesElements1.size());

		for (int i = 0; i < framesElements1.size(); i++) {
			System.out.println(i);
			
		}
		driver.switchTo().frame(0);
		System.out.println("frame 0");
		driver.findElement(By.id("datepicker")).click();
		
		for (int i = 0; i < jumpMonthsBy; i++) {
			if (increment) {
				
				
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
			} else {
			
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.linkText(Integer.toString(targetDay))).click();
		
		Thread.sleep(5000);
		driver.quit();
	}

	public static void GetCurrentDateMonthAndYear() {

		Calendar cal = Calendar.getInstance();

		currentDay = cal.get(Calendar.DAY_OF_MONTH);
		currentMonth = cal.get(Calendar.MONTH) + 1;
		currentYear = cal.get(Calendar.YEAR);

	}

	public static void GetTargetDayMonthAndYear(String dateString) {

		int firstIndex = dateString.indexOf("/");
		System.out.println("firstIndex " +firstIndex);
		
		int lastIndex = dateString.lastIndexOf("/");
		
		System.out.println("lastIndex " + lastIndex);

		String day = dateString.substring(0, firstIndex);
		
		targetDay = Integer.parseInt(day);
		
		String yearString = dateString.substring(lastIndex + 1, dateString.length());
		
		targetYear = Integer.parseInt(yearString);
		
		String monthString = dateString.substring(firstIndex+1, lastIndex);
		
		targetMonth = Integer.parseInt(monthString);


	}
	
	public static void CalculateHowManyMonthsToJump() {
		
		if ((targetMonth - currentMonth) > 0) {
			jumpMonthsBy = targetMonth - currentMonth;
		} else {
			jumpMonthsBy =  currentMonth - targetMonth;
			increment = false;
		}
		
	}

}
