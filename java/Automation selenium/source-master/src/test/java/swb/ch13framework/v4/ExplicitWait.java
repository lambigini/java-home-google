package swb.ch13framework.v4;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public interface ExplicitWait extends SearchScope {

    default Element await(Supplier<By> by) {  // <2>
        return new FluentWait<>(this)
            .withTimeout(1, SECONDS)
            .pollingEvery(10, MILLISECONDS)
            .ignoring(NoSuchElementException.class)
            .until((SearchScope e) -> findElement(by)); // <3>
    }

    default void await(Predicate<SearchScope> predicate) {
        new FluentWait<>(this)
            .withTimeout(1, SECONDS)
            .pollingEvery(10, MILLISECONDS)
            .ignoring(NoSuchElementException.class)
            .until(
                (SearchScope where) -> predicate.test(where)
            );
    }

    default void click(Supplier<By> by) {
        await(by).click();
    }

    default String getText(Supplier<By> by) {
        return await(by).getText();
    }
}
