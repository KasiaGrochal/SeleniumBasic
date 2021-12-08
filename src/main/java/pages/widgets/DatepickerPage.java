package pages.widgets;

import handlers.DateHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class DatepickerPage extends BasePage {

    Logger logger = LoggerFactory.getLogger(DatepickerPage.class);

    public DatepickerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#datepicker")
    private WebElement dateBox;

    @FindBy(css = ".ui-state-highlight")
    private WebElement currentDate;

    @FindBy(css = ".ui-datepicker-month")
    private WebElement visibleMonth;

    @FindBy(css = ".ui-datepicker-year")
    private WebElement visibleYear;

    @FindBy(css = ".ui-icon-circle-triangle-w")
    private WebElement calendarLeftArrow;

    @FindBy(css = ".ui-icon-circle-triangle-e")
    private WebElement calendarRightArrow;

    @FindBy(css = ".ui-state-default")
    private List<WebElement> calendarAllVisibleDays;


    private List<WebElement> getAllCurrentMonthDays() {
        List<WebElement> currentMonthDays = new ArrayList<>();
        for (WebElement day : calendarAllVisibleDays) {
            if (!day.getAttribute("class").contains("ui-priority-secondary")) {
                currentMonthDays.add(day);
            }
        }
        return currentMonthDays;
    }

    public DatepickerPage selectDayOfMonth(int day, List<String> expectedDateBoxText) throws ParseException {
        WebElement selectedDay = getAllCurrentMonthDays().get(day - 1);
        selectedDay.click();
        expectedDateBoxText.removeAll(expectedDateBoxText);
        expectedDateBoxText.add(getSelectedDateInFormatMMddYYYY(selectedDay));
        logger.info("Selected day: {}", expectedDateBoxText);
        return this;
    }

    public DatepickerPage selectRandomDayOfMonth(List<String> expectedDateBoxText) throws ParseException {
        WebElement selectedDay = getRandomWebElementFromList(getAllCurrentMonthDays());
        expectedDateBoxText.removeAll(expectedDateBoxText);
        expectedDateBoxText.add(getSelectedDateInFormatMMddYYYY(selectedDay));
        selectedDay.click();
        logger.info("Selected day: {}", expectedDateBoxText);
        return this;
    }

    public DatepickerPage goToRandomMonth() {
        clickOnCalendarLeftArrow(getRandomInt(12));
        return this;
    }


    public DatepickerPage clickOnDateBox() {
        dateBox.click();
        logger.info("Clicked on date box");
        return this;
    }

    public DatepickerPage selectCurrentDate(List<String> expectedDateBoxText) throws ParseException {
        currentDate.click();
        expectedDateBoxText.removeAll(expectedDateBoxText);
        expectedDateBoxText.add(getSelectedDateInFormatMMddYYYY(currentDate));
        logger.info("Selected date: {}", expectedDateBoxText);
        return this;
    }

    public String getDateBoxText() {
        String dateBoxText = dateBox.getAttribute("value");
        logger.info("Displayed date in date box: {}", dateBoxText);
        return dateBoxText;
    }

    private int getVisibleYearAsInt() {
        return Integer.parseInt(getVisibleYear());
    }

    private String getVisibleMonth() {
        waitForWebElementToBeVisable(visibleMonth);
        return visibleMonth.getText();
    }

    private String getVisibleYear() {
        waitForWebElementToBeVisable(visibleYear);
        return visibleYear.getText();
    }

    private String getSelectedDateInFormatMMddYYYY(WebElement selectedDay) throws ParseException {
        String dateInFormat = DateHandler.formatDateToMMddYYYY(DateHandler.formatDateFromString(getSelectedDateAsShown(selectedDay)));
        return dateInFormat;
    }

    public String getSelectedDateAsShown(WebElement selectedDay) {
        String date = getVisibleMonth() + "/" + selectedDay.getText() + "/" + getVisibleYear();
        return date;
    }


    public DatepickerPage clickOnCalendarRightArrow(int repeat) {
        for (int i = 0; i < repeat; i++) {
            waitForWebElementToBeClickable(calendarRightArrow);
            calendarRightArrow.click();
            logger.info("Clicked on calendar's right arrow.");
        }
        return this;
    }

    public DatepickerPage clickOnCalendarLeftArrow(int repeat) {
        for (int i = 0; i < repeat; i++) {
            waitForWebElementToBeClickable(calendarLeftArrow);
            calendarLeftArrow.click();
            logger.info("Clicked on calendar's left arrow.");
        }
        return this;
    }

    public DatepickerPage goToCurrentYear() {
        moveToYear(DateHandler.getCurrentYearAsInt());
        return this;
    }

    public DatepickerPage goToNextYear() {
        moveToYear(DateHandler.getCurrentYearAsInt() + 1);
        return this;
    }

    public DatepickerPage goToPreviousYear() {
        moveToYear(DateHandler.getCurrentYearAsInt() + -1);
        return this;
    }

    private DatepickerPage moveToYear(int expectedYear) {
        while (expectedYear != getVisibleYearAsInt()) {
            clickOnCalendarArrow(expectedYear, getVisibleYearAsInt());
        }
        return this;
    }

    public DatepickerPage goToNextMonth() throws ParseException {
        goToCurrentMonth();
        clickOnCalendarRightArrow(1);
        return this;
    }

    public DatepickerPage goToPreviousMonth() throws ParseException {
        goToCurrentMonth();
        clickOnCalendarLeftArrow(1);
        return this;
    }

    public DatepickerPage goToMonth(int expectedMonthAsInt) throws ParseException {
        moveToMonth(expectedMonthAsInt - 1);
        return this;
    }

    private DatepickerPage moveToMonth(int expectedMonth) throws ParseException {
        while (expectedMonth != getVisibleMonthAsInt()) {
            clickOnCalendarArrow(expectedMonth, getVisibleMonthAsInt());
        }
        return this;
    }

    private DatepickerPage clickOnCalendarArrow(int expectedCondition, int currentState) {
        if (expectedCondition > currentState) {
            clickOnCalendarRightArrow(1);
        } else if (expectedCondition < currentState) {
            clickOnCalendarLeftArrow(1);
        }
        return this;
    }


    private int getVisibleMonthAsInt() throws ParseException {
        return DateHandler.getMonthAsInt(getVisibleMonth(), Locale.UK);
    }

    public DatepickerPage goToCurrentMonth() throws ParseException {
        goToCurrentYear();
        moveToMonth(DateHandler.getCurrentMonthAsInt());
        return this;
    }


}
