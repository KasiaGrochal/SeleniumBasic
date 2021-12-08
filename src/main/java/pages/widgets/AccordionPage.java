package pages.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class AccordionPage extends BasePage {

    private Logger logger = LoggerFactory.getLogger(AccordionPage.class);

    public AccordionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#ui-id-1")
    WebElement section1Button;

    @FindBy(css = "#ui-id-3")
    WebElement section2Button;

    @FindBy(css = "#ui-id-5")
    WebElement section3Button;

    @FindBy(css = "#ui-id-7")
    WebElement section4Button;

    @FindBy(css = ".ui-accordion-content-active")
    WebElement activeTextBox;

    public AccordionPage clickOnSection1Button() {
        clickOnSection(section1Button);
        return this;
    }

    public AccordionPage clickOnSection2Button() {
        clickOnSection(section2Button);
        return this;
    }

    public AccordionPage clickOnSection3Button() {
        clickOnSection(section3Button);
        return this;
    }

    public AccordionPage clickOnSection4Button() {
        clickOnSection(section4Button);
        return this;
    }

    private void clickOnSection(WebElement button) {
        button.click();
        logger.info("Clicked on: {}", button.getText());
    }

    public AccordionPage getCurrentSectionText() {
        waitForWebElementAttributeToBe(activeTextBox, "aria-hidden", "false");
        System.out.println(activeTextBox.getText());
        logger.info("Printed Section text");
        return this;
    }
}
