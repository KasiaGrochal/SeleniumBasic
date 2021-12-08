package interactions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Website;
import testBase.TestBase;

public class DraggableTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(DraggableTest.class);

    @Test
    @DisplayName("Dragging element around")
    @Tag("regression")
    @Tag("dragdrop")
    void dragElement() {
        Website website = new Website(driver);

        website.
                openWebsite().
                navigateToTopBarPage().
                clickOnTopMenuInteractionsButton().
                clickOnDraggableButton().dragElementToRightTop().dragElementToRightBottom().dragElementToTheCenter().dragElementToLeftBottom();

    }
}
