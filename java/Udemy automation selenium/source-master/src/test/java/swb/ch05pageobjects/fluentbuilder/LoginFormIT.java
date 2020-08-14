package swb.ch05pageobjects.fluentbuilder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import swb.framework.WebDriverRunner;

import javax.inject.Inject;

@RunWith(WebDriverRunner.class)
public class LoginFormIT {
    @Inject
    private WebDriver driver;

    @Test
    public void checkLoginForm() throws Exception {
        driver.get("/login.html");

        new LoginForm(driver.findElement(By.id("login")))
                .username("foo@bar.com")
                .password("secret")
                .submit();

        new WebDriverWait(driver, 2)
                .until((WebDriver input) -> "You Are Logged In".equals(driver.getTitle()));
    }
}
