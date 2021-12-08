package pages.basic;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class AlertsPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(AlertsPage.class);

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public static final String expectedSimpleAlertAcceptMessage = "OK button pressed";
    public static final String expectedConfirmAcceptMessage = "You pressed OK!";
    public static final String expectedConfirmCancelMessage = "You pressed Cancel!";


    @FindBy(css = "#simple-alert")
    private WebElement simpleAlertButton;

    @FindBy(css = "#simple-alert-label")
    private WebElement simpleAlertMessage;

    @FindBy(css = "#prompt-alert")
    private WebElement promptPopUpButton;

    @FindBy(css = "#prompt-label")
    private WebElement promptPopUpMessage;

    @FindBy(css = "#confirm-alert")
    private WebElement confirmPopUpButton;

    @FindBy(css = "#confirm-label")
    private WebElement confirmPopUpMessage;

    @FindBy(css = "#delayed-alert")
    private WebElement delayedAlertButton;

    @FindBy(css = "#delayed-alert-label")
    private WebElement delayedAlertMessage;


    public AlertsPage clickSimpleAlertButton() {
        simpleAlertButton.click();
        logger.info("Clicked on 'Simple Alert' button");
        return this;
    }

    public String getSimpleAlertAcceptMessage() {
        String acceptMessage = simpleAlertMessage.getText();
        logger.info("Simple alert accept message displayed: '{}'", acceptMessage);
        logger.info("Expected simple alert accept message: '{}'", expectedSimpleAlertAcceptMessage);
        return acceptMessage;
    }

    public AlertsPage clickPromptPopUpButton() {
        promptPopUpButton.click();
        logger.info("Clicked on 'Prompt Pop up' button");
        return this;
    }


    public String getPromptPopUpAcceptMessage() {
        String acceptMessage = promptPopUpMessage.getText();
        logger.info("Prompt Pop up accept message displayed: '{}'", acceptMessage);

        return acceptMessage;
    }

    public String getConfirmPopUpMessage() {
        String message = confirmPopUpMessage.getText();
        logger.info("Confirm Pop Up message displayed: '{}'", message);
        return message;
    }

    public String getDelayedAlertMessage() {
        String message = delayedAlertMessage.getText();
        logger.info("Displayed message: {}", message);
        return message;
    }

    public AlertsPage clickConfirmPopUpButton() {
        confirmPopUpButton.click();
        logger.info("Clicked on 'Confirm Pop Up' button");
        return this;
    }

    public AlertsPage clickOnDelayedAlertButton() {
        delayedAlertButton.click();
        logger.info("Clicked on 'Delayed alert' button");
        waitForAlertWindow();
        return this;
    }

    public AlertsPage switchToAlertWindowAndAccept() {
        driver.switchTo().alert().accept();
        logger.info("Switched to alert window and accepted");
        return this;
    }

    public AlertsPage switchToAlertWindowAndDismiss() {
        driver.switchTo().alert().dismiss();
        logger.info("Switched to alert window and cancelled");
        return this;
    }


    public AlertsPage switchToAlertWindowSendText(String text) {
        driver.switchTo().alert().sendKeys(text);
        logger.info("Switched to alert window and typed in text: {}", text);
        return this;
    }

    public static String getExpectedPromptPopUpAcceptMessage(String text) {
        String message = "Hello " + text + "! How are you today?";
        logger.info("Expected Prompt Pop up accept message: '{}'", message);
        return message;
    }

}
