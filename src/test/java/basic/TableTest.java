package basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Website;
import pages.basic.tablePage.TablePage;
import testBase.TestBase;

public class TableTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(TableTest.class);

    @RepeatedTest(5)
    @DisplayName("Print results as filtered")
    @Tag("regression")
    @Tag("table")
    void printFilterResults() {
        Website website = new Website(driver);
        TablePage tablePage = new TablePage(driver);
        website.
                openWebsite().
                navigateToTopBarPage().
                clickOnTopMenuBasicButton().
                clickOnTableButton().
                printFilteredList(tablePage.filterByHeightAndState());
        logger.info("Printing results finished.");
    }
}
