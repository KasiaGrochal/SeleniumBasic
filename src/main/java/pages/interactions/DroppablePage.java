package pages.interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class DroppablePage extends BasePage {
    Logger logger = LoggerFactory.getLogger(DroppablePage.class);

    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    public static String expectedSuccessMessage = "Dropped!";

    @FindBy(css = "#draggable")
    private WebElement draggableElement;

    @FindBy(css = "#droppable")
    private WebElement droppableElement;

    @FindBy(css = "[class= 'ui-widget-header ui-droppable ui-state-highlight']")
    private WebElement droppableSuccessMessage;

    public DroppablePage dropElementToDestination() {
        action.dragAndDrop(draggableElement, droppableElement).build().perform();
        logger.info("Moved droppable element to destination box");
        return this;
    }

    public String getSuccessMessage() {
        String successMessage = droppableSuccessMessage.getText();
        logger.info("Displayed success message: {}", successMessage);
        return successMessage;
    }


}
