package parameterization;

import org.testng.annotations.Test;

public class TestLoginTest {

	@Test(dataProvider = "dp1",dataProviderClass = DataProviders.class)
	public void testLogin(String username, String password) {
		
		System.out.println(username + " ---- " + password);
		
	}
	
	
	@Test(dataProvider = "dp1",dataProviderClass = DataProviders.class)
	public void testUserRegis(String username, String password, String email) {
		
		System.out.println(username + " ---- " + password+ " ---- " + email);
		
	}
	
}
