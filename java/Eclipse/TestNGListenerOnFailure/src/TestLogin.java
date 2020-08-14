import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin {

	@Test (priority = 1)
	public void login() {
		System.out.println("Login");
	}
	static int count = 0;
	@Test (priority = 2)
	public void userRegis() {
		count++;
		Assert.assertEquals(count, 4);
	}
}
