package swb.ch17jquerydatepicker.jquery.v1_5;

import swb.framework.Browser;

import static swb.locators.jquery.JQueryByClassName.*;
import static swb.locators.jquery.JQueryById.CALENDAR;

public class JQueryYearPicker {

    private final Browser browser;

    public JQueryYearPicker(Browser browser) {
        this.browser = browser;
    }

    public void pickYear(int year) {
        int difference = displayYear() - year;
        if (difference < 0) {
            for (int i = difference; i < 0; i++) {
                nextYear();
            }
        } else if (difference > 0) {
            for (int i = 0; i < difference; i++) {
                previousYear();
            }
        }
    }

    private void previousYear() {
        for (int i = 0; i < 12; i++) {
            previousMonth();
        }
    }

    private void nextYear() {
        for (int i = 0; i < 12; i++) {
            nextMonth();
        }
    }

    private int displayYear() {
        String text = browser.await(CALENDAR).getText(YEAR);
        return Integer.parseInt(text);
    }

    private void previousMonth() {
        browser.await(CALENDAR).click(PREV_MONTH_BUTTON);  //<3>
    }

    private void nextMonth() {
        browser.await(CALENDAR).click(NEXT_MONTH_BUTTON);  //<4>
    }

}
