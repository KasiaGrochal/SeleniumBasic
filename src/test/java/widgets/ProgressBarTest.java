package widgets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Website;
import pages.widgets.ProgressBarPage;
import testBase.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ProgressBarTest extends TestBase {

    Logger logger = LoggerFactory.getLogger(ProgressBarTest.class);

    @Test
    @DisplayName("Validate progress bar message when it's loaded")
    @Tag("regression")
    @Tag("progressBar")
    void validateProgressBarCompleteMessage() {
        Website website = new Website(driver);
        assertThat(
                website.
                        openWebsite().
                        navigateToTopBarPage().
                        clickOnTopMenuWidgetsButton().
                        clickOnProgressBarButton().getProgressBarLoadedText(), equalTo(ProgressBarPage.expectedText));
        logger.info("Displayed progress bar text as expected: {}", ProgressBarPage.expectedText);

    }
}
