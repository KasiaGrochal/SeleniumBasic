package interactions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Website;
import pages.interactions.SortablePage;
import testBase.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SortableTest extends TestBase {

    Logger logger = LoggerFactory.getLogger(SortableTest.class);

    @Test
    @DisplayName("Shuffle elements")
    @Tag("regression")
    @Tag("shuffle")
    void sortElementsAsRequired() {
        Website website = new Website(driver);
        assertThat(
                website.
                        openWebsite().
                        navigateToTopBarPage().
                        clickOnTopMenuInteractionsButton().
                        clickOnSortableButton().shuffleItems().getCurrentItemListOrder(), equalTo(SortablePage.shuffledList));
        logger.info("Displayed item list order as expected: {} Test sortElementsAsRequired completed successfully", SortablePage.shuffledList);
    }
}
