package interactions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Website;
import pages.interactions.SelectablePage;
import testBase.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SelectableTest extends TestBase {

    Logger logger = LoggerFactory.getLogger(SelectableTest.class);

    @Test
    @DisplayName("Validate selected items text")
    @Tag("regression")
    @Tag("selectableItems")
    void validateYouSelectedText() {
        Website website = new Website(driver);
        assertThat(
                website.
                        openWebsite().
                        navigateToTopBarPage().
                        clickOnTopMenuInteractionsButton().
                        clickOnSelectableButton().
                        selectItem(1).
                        selectItem(3).
                        selectItem(4).
                        getYouSelectedText(), equalTo(SelectablePage.expectedText));
        logger.info("Expected text: {} Test validateYouSelectedText() completed successfully", SelectablePage.expectedText);

    }
}
