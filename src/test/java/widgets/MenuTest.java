package widgets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.Website;
import testBase.TestBase;

public class MenuTest extends TestBase {

    @Test
    @DisplayName("Validate music options")
    @Tag("regression")
    @Tag("menu")
    void clickOnMusicOptions() {
        Website website = new Website(driver);

        website.
                openWebsite().
                navigateToTopBarPage().
                clickOnTopMenuWidgetsButton().
                clickOnMenuButton().
                clickOnMusicTab().
                clickOnJazzTab().
                clickOnModernTab();
    }
}
