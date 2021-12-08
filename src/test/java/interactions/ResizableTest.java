package interactions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.Website;
import testBase.TestBase;

public class ResizableTest extends TestBase {

    @Test
    @DisplayName("Resize bos")
    @Tag("regression")
    @Tag("resize")
    void checkResizableOptions() {
        Website website = new Website(driver);

        website.
                openWebsite().
                navigateToTopBarPage().
                clickOnTopMenuInteractionsButton().
                clickOnResizableButton().
                resizeHorizontally(10).
                resizeVertically(10).
                resizeToTheCorner(10);
    }
}
