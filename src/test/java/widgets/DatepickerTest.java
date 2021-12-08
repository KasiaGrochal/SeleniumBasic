package widgets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Website;
import pages.widgets.DatepickerPage;
import testBase.TestBase;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DatepickerTest extends TestBase {

    Logger logger = LoggerFactory.getLogger(DatepickerTest.class);

    @Test
    @DisplayName("Validate picked dates in calendar")
    @Tag("regression")
    @Tag("datepicker")
    void datePickerTest() throws ParseException {
        Website website = new Website(driver);
        DatepickerPage datepickerPage = new DatepickerPage(driver);
        List<String> expectedDateBoxText = new ArrayList<>();

        int january = 1;

        website.
                openWebsite().
                navigateToTopBarPage().
                clickOnTopMenuWidgetsButton().
                clickOnDatepickerButton().
                clickOnDateBox().
                selectCurrentDate(expectedDateBoxText);
        assertThat(expectedDateBoxText.contains(datepickerPage.getDateBoxText()), equalTo(true));
        logger.info("Date shown in the box same as date picked: {}, Test completed successfully.", expectedDateBoxText);

        datepickerPage.
                clickOnDateBox().
                goToNextMonth().
                selectDayOfMonth(1, expectedDateBoxText);
        assertThat(expectedDateBoxText.contains(datepickerPage.getDateBoxText()), equalTo(true));
        logger.info("Date shown in the box same as date picked: {}, Test completed successfully.", expectedDateBoxText);

        datepickerPage.
                clickOnDateBox().
                goToNextYear().
                goToMonth(january).
                selectDayOfMonth(31, expectedDateBoxText);
        assertThat(expectedDateBoxText.contains(datepickerPage.getDateBoxText()), equalTo(true));
        logger.info("Date shown in the box same as date picked: {}, Test completed successfully.", expectedDateBoxText);

        datepickerPage.
                clickOnDateBox().
                selectDayOfMonth(31, expectedDateBoxText);
        assertThat(expectedDateBoxText.contains(datepickerPage.getDateBoxText()), equalTo(true));
        logger.info("Date shown in the box same as date picked: {}, Test completed successfully.", expectedDateBoxText);

        datepickerPage.
                clickOnDateBox().
                goToPreviousMonth().
                selectRandomDayOfMonth(expectedDateBoxText);
        assertThat(expectedDateBoxText.contains(datepickerPage.getDateBoxText()), equalTo(true));
        logger.info("Date shown in the box same as date picked: {}, Test completed successfully.", expectedDateBoxText);

        datepickerPage.
                clickOnDateBox().
                goToPreviousYear().
                goToRandomMonth().
                selectRandomDayOfMonth(expectedDateBoxText);
        assertThat(expectedDateBoxText.contains(datepickerPage.getDateBoxText()), equalTo(true));
        logger.info("Date shown in the box same as date picked: {}, Test completed successfully.", expectedDateBoxText);


    }

}
