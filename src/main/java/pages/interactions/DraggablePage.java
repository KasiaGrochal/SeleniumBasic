package pages.interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class DraggablePage extends BasePage {
    Logger logger = LoggerFactory.getLogger(DraggablePage.class);

    public DraggablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#draggable")
    WebElement draggableElement;

    @FindBy(css = ".navbar")
    WebElement navigationBar;

    @FindBy(css = ".display-4")
    WebElement header;

    public DraggablePage dragElementTo(int x, int y) {
        action.dragAndDropBy(draggableElement, x, y).build().perform();
        return this;
    }

    public DraggablePage dragElementToRightBottom() {
        dragElementTo(getRightPageEnd(),getPageBottom());
        logger.info("Moved element to the right bottom of the page.");
        return this;
        }

    public DraggablePage dragElementToRightTop() {
        dragElementTo(getRightPageEnd(),getPageTop());
        logger.info("Moved element to the right top of the page.");
        return this;
    }

    public DraggablePage dragElementToLeftBottom() {
        dragElementTo(getLeftPageEnd(),getPageBottom());
        logger.info("Moved element to the left bottom of the page.");
        return this;
    }

    public DraggablePage dragElementToTheCenter() {
        int moveX = (getPageWidth() / 2 - getCurrentLocationX() - getElementWidth() / 2);
        int moveY = (getPageHeight() / 2 - getCurrentLocationY() - getElementHeight() / 2);
        dragElementTo(moveX,moveY);
        logger.info("Moved element to the center of the page.");
        return this;
    }



    private int getPageWidth() {
        return driver.manage().window().getSize().getWidth();
    }

    private int getPageHeight() {
        return driver.manage().window().getSize().getHeight();
    }

    private int getCurrentLocationX() {
        return draggableElement.getLocation().getX();
    }

    private int getCurrentLocationY() {
        return draggableElement.getLocation().getY();
    }

    private int getNavigationBarHeight() {
        return navigationBar.getSize().getHeight();
    }

    private int getHeaderHeight() {
        return header.getSize().getHeight();
    }

    private int getElementWidth() {
        return draggableElement.getSize().getWidth();
    }

    private int getElementHeight() {
        return draggableElement.getSize().getHeight();
    }

    private int getRightPageEnd() {
        return (getPageWidth() - getCurrentLocationX() - getElementWidth());
    }

    private int getLeftPageEnd() {
        return (0 - getCurrentLocationX());
    }

    private int getPageTop() {
        return (0 - getCurrentLocationY());
    }

    private int getPageBottom() {
        return (getPageHeight() - getCurrentLocationY() - getElementHeight() / 2 - getNavigationBarHeight() - getHeaderHeight());
    }


}
