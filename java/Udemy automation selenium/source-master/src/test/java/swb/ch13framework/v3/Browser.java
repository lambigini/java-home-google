package swb.ch13framework.v3;

import org.openqa.selenium.WebDriver;

public class Browser extends DelegatingWebDriver {

    public Browser(WebDriver driver) {
        super(driver);
    }

}
