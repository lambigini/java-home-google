 package parameterization;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameterFromXML {
	@Parameters({"browser", "env"})
	@Test
	public void getBrowser(String browser, String env) {
		System.out.println(browser + "---"+ env);
	}
}
