package widgets;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Website;
import pages.widgets.SliderPage;
import testBase.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class SliderTest extends TestBase {

    Logger logger = LoggerFactory.getLogger(SliderTest.class);

    @Test
    @DisplayName("Validate slider values")
    @Tag("regression")
    @Tag("slider")
    void checkSliderValues() {
        Website website = new Website(driver);
        SliderPage sliderPage = new SliderPage(driver);

        int moveTo1 = 50;
        int moveTo2 = 80;
        int moveTo3 = 20;
        int moveTo4 = 0;


        assertThat(
                website.
                        openWebsite().
                        navigateToTopBarPage().
                        clickOnTopMenuWidgetsButton().
                        clickOnSliderButton().
                        moveSliderToValue(moveTo1).
                        getCurrentSliderValue(), equalTo(moveTo1));
        logger.info("Expected slider value was: {}.Test checkSliderValues() completed successfully", moveTo1);

        assertThat(
                sliderPage.
                        moveSliderToValue(moveTo2).
                        getCurrentSliderValue(), equalTo(moveTo2));
        logger.info("Expected slider value was: {}.Test checkSliderValues() completed successfully", moveTo2);

        assertThat(
                sliderPage.
                        moveSliderToValue(moveTo2).
                        getCurrentSliderValue(), equalTo(moveTo2));
        logger.info("Expected slider value was: {}.Test checkSliderValues() completed successfully", moveTo2);

        assertThat(
                sliderPage.
                        moveSliderToValue(moveTo3).
                        getCurrentSliderValue(), equalTo(moveTo3));
        logger.info("Expected slider value was: {}. Test checkSliderValues() completed successfully", moveTo3);

        assertThat(
                sliderPage.
                        moveSliderToValue(moveTo4).
                        getCurrentSliderValue(), equalTo(moveTo4));
        logger.info("Expected slider value was: {}. Test checkSliderValues() completed successfully", moveTo4);
    }
}

