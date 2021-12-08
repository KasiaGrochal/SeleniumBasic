package others;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.Website;
import testBase.TestBase;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HighSiteTest extends TestBase {

    @Test
    @DisplayName("Validate if submit button appears after scrooling down")
    @Tag("regression")
    @Tag("scroll")
    void validateSubmitButtonVisibility() throws IOException {
        Website website = new Website(driver);
        assertThat(
                website.
                        openWebsite().
                        navigateToTopBarPage().
                        clickOnTopMenuOthersButton().
                        clickOnHighSiteButton().scrollDownToSubmitButton().isSubmitButtonVisible(), equalTo(true));
    }
}
