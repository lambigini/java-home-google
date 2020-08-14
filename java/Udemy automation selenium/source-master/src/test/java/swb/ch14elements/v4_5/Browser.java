package swb.ch14elements.v4_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import swb.ch13framework.v4.DelegatingWebDriver;
import swb.ch13framework.v4.Element;

import java.util.function.Supplier;

public class Browser extends DelegatingWebDriver {

    public Browser(WebDriver driver) {
        super(driver);
    }

    public void setInputText(Supplier<By> by, String value) {
        Element element = await(by);
        element.clear();
        element.sendKeys(value);
    }
}