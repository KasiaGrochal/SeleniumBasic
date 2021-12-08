package pages.interactions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class ResizablePage extends BasePage {

    Logger logger = LoggerFactory.getLogger(ResizablePage.class);

    public ResizablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".ui-resizable-e")
    private WebElement resizeHorizontalHandle;

    @FindBy(css = ".ui-resizable-s")
    private WebElement resizeVerticalHandle;

    @FindBy(css = ".ui-icon")
    private WebElement resizeCornerHandle;

    public ResizablePage resizeHorizontally(int xOffset) {
        action.dragAndDropBy(resizeHorizontalHandle, xOffset, 0).build().perform();
        logger.info("Resized the box horizontally by {} px", xOffset);
        return this;
    }

    public ResizablePage resizeVertically(int yOffset) {
        action.dragAndDropBy(resizeVerticalHandle, 0, yOffset).build().perform();
        logger.info("Resized the box vertically by {} px", yOffset);
        return this;
    }

    public ResizablePage resizeToTheCorner(int offset) {
        action.dragAndDropBy(resizeCornerHandle, offset, offset).build().perform();
        logger.info("Resized the box by {} px both horizontally and vertically", offset);
        return this;
    }
}
