package basic;

import handlers.FakeDataGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.TopBarPage;
import pages.Website;
import testBase.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class IframesTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(IframesTest.class);

    @Test
    @DisplayName("Fill in Iframe forms")
    @Tag("regression")
    @Tag("iframe")
    void fillInIframeForms() {
        Website website = new Website(driver);
        TopBarPage topBarPage = new TopBarPage(driver);
        FakeDataGenerator faker = new FakeDataGenerator();

        website.
                openWebsite().
                navigateToTopBarPage().
                clickOnTopMenuBasicButton().
                clickOnIframesButton().
                switchToIframe1().
                fillInFirstName(faker.getFakeFirstName()).
                fillInSurName(faker.getFakeLastName()).
                switchToParentFrame().
                switchToIframe2().
                fillInLogin(faker.getFakeLogin()).
                fillInPassword(faker.getFakePassword()).
                selectRandomContinent().
                selectRandomYearOfExperience().
                switchToParentFrame();

        assertThat(
                topBarPage.
                        clickOnTopMenuBasicButton().
                        checkIfBasicDropDownMenuIsDisplayed(), equalTo(true));
        logger.info("Basic Dropdown Menu is displayed. Test fillInIframeForms completed successfully");

    }
}
