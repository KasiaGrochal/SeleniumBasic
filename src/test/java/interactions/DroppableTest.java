package interactions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Website;
import pages.interactions.DroppablePage;
import testBase.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DroppableTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(DroppableTest.class);

    @Test
    @DisplayName("Validate if proper success message appears after dropping the box to target")
    @Tag("regression")
    @Tag("drop")
    void validateSuccessDroppingMessage() {
        Website website = new Website(driver);

        assertThat(
                website.
                        openWebsite().
                        navigateToTopBarPage().
                        clickOnTopMenuInteractionsButton().
                        clickOnDroppableButton().
                        dropElementToDestination().getSuccessMessage(), equalTo(DroppablePage.expectedSuccessMessage));
        logger.info("Expected success message: {} Test validateSuccessDroppingMessage() completed successfully.", DroppablePage.expectedSuccessMessage);
    }


}
