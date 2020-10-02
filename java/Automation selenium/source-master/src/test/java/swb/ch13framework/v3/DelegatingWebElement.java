package swb.ch13framework.v3;

import org.openqa.selenium.*;
import org.openqa.selenium.internal.WrapsElement;

import java.util.List;

public class DelegatingWebElement implements WebElement, WrapsElement {
    protected final WebElement delegate;

    public DelegatingWebElement(WebElement delegate) {
        this.delegate = delegate;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return delegate.findElements(by);
    }

    @Override
    public Element findElement(By by) {
        return new Element(delegate.findElement(by));
    }

    @Override
    public void click() {
        delegate.click();
    }

    @Override
    public void submit() {
        delegate.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        delegate.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        delegate.clear();
    }

    @Override
    public String getTagName() {
        return delegate.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return delegate.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return delegate.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return delegate.isEnabled();
    }

    @Override
    public String getText() {
        return delegate.getText();
    }

    @Override
    public boolean isDisplayed() {
        return delegate.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return delegate.getLocation();
    }

    @Override
    public Dimension getSize() {
        return delegate.getSize();
    }

    @Override
    public Rectangle getRect() {
        return delegate.getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return delegate.getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return delegate.getScreenshotAs(outputType);
    }

    @Override
    public WebElement getWrappedElement() {
        return ((WrapsElement)delegate).getWrappedElement();
    }
}

