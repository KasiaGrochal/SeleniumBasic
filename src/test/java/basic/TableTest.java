package basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.Website;
import testBase.TestBase;

public class TableTest extends TestBase {

    @Test
    @DisplayName("Print results as filtered")
    @Tag("regression")
    @Tag("table")
    void printFilterResults() {
        Website website = new Website(driver);
        website.
                openWebsite().
                navigateToTopBarPage().
                clickOnTopMenuBasicButton().
                clickOnTableButton().
                filterTableByStateAndHeight();
    }
}
