package widgets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.Website;
import testBase.TestBase;

public class SelectMenuTest extends TestBase {

    @Test
    @DisplayName("Verify select menu options")
    @Tag("regression")
    @Tag("selectMenu")
    void selectDifferentOptions() {
        Website website = new Website(driver);

        website.
                openWebsite().
                navigateToTopBarPage().
                clickOnTopMenuWidgetsButton().
                clickOnSelectMenuButton().
                clickOnSelectSpeedDropdown().
                selectRandomSpeed().
                clickOnSelectFileButton().
                chooseFileByVisibleText("ui.jQuery.js").
                clickOnSelectNumberButton().
                chooseNumberByIndex(18).
                clickOnSelectTitleButton().
                chooseRandomTitle();
    }
}
