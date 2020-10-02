package overriding;

public class TestCase1 extends Base {
	
	String browserName="chrome";

	public static void main(String[] args) {

		TestCase1 tc = new TestCase1();
		tc.initBrowser();

	}
	
	public void initBrowser(){
		
		WebDriver driver = getBrowserInstance(browserName);
		driver.click();
		driver.sendKeys();
		driver.getTitle();
		
	}

}
