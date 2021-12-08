package widgets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Website;
import pages.widgets.TooltipPage;
import testBase.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TooltipTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(TooltipTest.class);

    @Test
    @DisplayName("Validate tooltip message")
    @Tag("regression")
    @Tag("tooltip")
    void validateTooltipMessage() {
        Website website = new Website(driver);
        assertThat(
                website.
                        openWebsite().
                        navigateToTopBarPage().
                        clickOnTopMenuWidgetsButton().
                        clickOnTooltipButton().moveToAgeBox().getTooltipText(), equalTo(TooltipPage.expectedTooltipText));
        logger.info("Expected tooltip text: {} Test validateTooltipMessage() completed successfully.", TooltipPage.expectedTooltipText);
    }
}
