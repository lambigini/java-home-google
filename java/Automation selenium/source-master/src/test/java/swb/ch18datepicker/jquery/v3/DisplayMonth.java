package swb.ch18datepicker.jquery.v3;

import swb.framework.Browser;

import java.time.Month;
import java.util.function.Function;

import static swb.locators.jquery.JQueryByClassName.MONTH;
import static swb.locators.jquery.JQueryById.CALENDAR;

public class DisplayMonth implements Function<Browser, Integer> {

    @Override
    public Integer apply(Browser browser) {
        String text = browser.await(CALENDAR).getUpperText(MONTH);
        return Month.valueOf(text).ordinal();
    }
}
