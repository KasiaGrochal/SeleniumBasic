package basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.TopBarPage;
import pages.Website;
import pages.basic.MainPage;
import pages.basic.tablePage.TablePage;
import testBase.TestBase;

public class TableTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(TableTest.class);

    @RepeatedTest(5)
    @DisplayName("Print results as filtered")
    @Tag("regression")
    @Tag("table")
    void printFilterResults() {

        TablePage tablePage = new TablePage(driver);

        new Website(driver).
                openWebsite();
        new MainPage(driver).
                navigateToTopBarPage();
        new TopBarPage(driver).
                clickOnTopMenuBasicButton().
                clickOnTableButton();
        tablePage.
                printFilteredList(tablePage.filterByHeightAndState());
        logger.info("Printing results finished.");
    }
}
