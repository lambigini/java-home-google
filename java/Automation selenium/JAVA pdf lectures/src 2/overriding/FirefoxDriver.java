package overriding;

public class FirefoxDriver extends WebDriver {

	public void click() {

		System.out.println("Clicking in Firefox");

	}

	public void sendKeys() {

		System.out.println("Typing in Firefox");
	}

}
