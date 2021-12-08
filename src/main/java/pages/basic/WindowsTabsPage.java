package pages.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class WindowsTabsPage extends BasePage {
    Logger logger = LoggerFactory.getLogger(WindowsTabsPage.class);

    public WindowsTabsPage(WebDriver driver) {
        super(driver);
    }

    private String parent = switchWindow();

    @FindBy(css = "#newBrowserWindow")
    private WebElement newBrowserWindowButton;

    @FindBy(css = "#newMessageWindow")
    private WebElement newMessageWindowButton;

    @FindBy(css = "#newBrowserTab")
    private WebElement newBrowserTabButton;

    public WindowsTabsPage clickOnNewBrowserWindowButton() {
        newBrowserWindowButton.click();
        logger.info("Clicked on 'New Browser Window' button");
        return this;
    }

    public WindowsTabsPage clickOnNewMessageWindowButton() {
        newMessageWindowButton.click();
        logger.info("Clicked on 'New Message Window' button");
        return this;
    }

    public WindowsTabsPage clickOnNewBrowserTabButton() {
        newBrowserTabButton.click();
        logger.info("Clicked on 'New Browser Tab' button");
        return this;
    }

    public NewBrowserWindow switchToNewBrowserWindow() {
        switchWindow();
        String newWindow = driver.getCurrentUrl();
        logger.info("Switched to the new window: {}", newWindow);
        return new NewBrowserWindow(driver);
    }

    public MessageWindow switchToMessageWindow() {
        switchWindow();
        return new MessageWindow(driver);
    }


    public WindowsTabsPage switchToParentWindow() {
        driver.switchTo().window(parent);
        return this;
    }

    private String switchWindow() {
        String orgWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!orgWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        return orgWindow;
    }


}
