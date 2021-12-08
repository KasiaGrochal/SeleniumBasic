package basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Website;
import pages.basic.AlertsPage;
import testBase.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static pages.basic.AlertsPage.getExpectedPromptPopUpAcceptMessage;

public class AlertsTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(AlertsTest.class);

    @Test
    @DisplayName("Validate if appropriate alert message appears")
    @Tag("regression")
    @Tag("alerts")
    void validateSimpleAlertAcceptMessage() {
        Website website = new Website(driver);
        assertThat(
                website.
                        openWebsite().
                        navigateToTopBarPage().
                        clickOnTopMenuBasicButton().
                        clickOnAlertsButton().
                        clickSimpleAlertButton().
                        switchToAlertWindowAndAccept().
                        getSimpleAlertAcceptMessage(), equalTo(AlertsPage.expectedSimpleAlertAcceptMessage));
        logger.info("Accept message as expected. Test verifySimpleAlertAcceptMessage completed successfully.");

    }

    @Test
    @DisplayName("Validate if appropriate alert message appears")
    @Tag("regression")
    @Tag("alerts")
    void validatePromptPopUpAcceptMessage() {
        Website website = new Website(driver);
        String alertSentText = "Lord Vader";
        assertThat(
                website.
                        openWebsite().
                        navigateToTopBarPage().
                        clickOnTopMenuBasicButton().
                        clickOnAlertsButton().
                        clickPromptPopUpButton().
                        switchToAlertWindowSendText(alertSentText).
                        switchToAlertWindowAndAccept().
                        getPromptPopUpAcceptMessage(), equalTo(getExpectedPromptPopUpAcceptMessage(alertSentText)));
        logger.info("Accept message as expected. Test verifyPromptPopUpAcceptMessage completed successfully.");

    }

    @Test
    @DisplayName("Validate if appropriate alert message appears")
    @Tag("regression")
    @Tag("alerts")
    void validateConfirmPopUpAcceptCancelMessages() {
        Website website = new Website(driver);
        AlertsPage alertsPage = new AlertsPage(driver);
        assertThat(
                website.
                        openWebsite().
                        navigateToTopBarPage().
                        clickOnTopMenuBasicButton().
                        clickOnAlertsButton().
                        clickConfirmPopUpButton().
                        switchToAlertWindowAndAccept().
                        getConfirmPopUpMessage(), equalTo(AlertsPage.expectedConfirmAcceptMessage));
        logger.info("Expected accept message: '{}.", AlertsPage.expectedConfirmAcceptMessage);

        assertThat(alertsPage.clickConfirmPopUpButton().
                switchToAlertWindowAndDismiss().
                getConfirmPopUpMessage(), equalTo(AlertsPage.expectedConfirmCancelMessage));
        logger.info("Cancel message expected: '{}' Test verifyConfirmPopUpCancelMessageAfterAcceptMessage completed successfully.", AlertsPage.expectedConfirmCancelMessage);
    }

    @Test
    @DisplayName("Validate if appropriate alert message appears")
    @Tag("regression")
    @Tag("alerts")
    void validateDelayedAlertAcceptMessage() {
        Website website = new Website(driver);
        assertThat(
                website.
                        openWebsite().
                        navigateToTopBarPage().
                        clickOnTopMenuBasicButton().
                        clickOnAlertsButton().
                        clickOnDelayedAlertButton().
                        switchToAlertWindowAndAccept().
                        getDelayedAlertMessage(), equalTo(AlertsPage.expectedSimpleAlertAcceptMessage));
        logger.info("Expected message: '{}' Test validateDelayedAlertAcceptMessage completed successfully.", AlertsPage.expectedSimpleAlertAcceptMessage);
    }


}
