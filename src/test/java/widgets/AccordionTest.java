package widgets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.Website;
import testBase.TestBase;

public class AccordionTest extends TestBase {

    @Test
    @DisplayName("Check each section text")
    @Tag("regression")
    @Tag("accordion")
    void validateSectionsText() {
        Website website = new Website(driver);

        website.
                openWebsite().
                navigateToTopBarPage().
                clickOnTopMenuWidgetsButton().
                clickOnAccordionButton().
                getCurrentSectionText().
                clickOnSection2Button().getCurrentSectionText().
                clickOnSection3Button().getCurrentSectionText().
                clickOnSection4Button().
                getCurrentSectionText();
    }
}
