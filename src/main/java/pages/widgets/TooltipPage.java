package pages.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class TooltipPage extends BasePage {
    Logger logger = LoggerFactory.getLogger(TooltipPage.class);

    public TooltipPage(WebDriver driver) {
        super(driver);
    }

    public static String expectedTooltipText = "We ask for your age only for statistical purposes.";

    @FindBy(css = ".ui-helper-hidden-accessible")
    WebElement toolTip;

    @FindBy(css = "#age")
    WebElement ageBox;

    public TooltipPage moveToAgeBox() {
        action.moveToElement(ageBox).build().perform();
        logger.info("Moved mouse to age box");
        return this;
    }

    public String getTooltipText() {
        String text = toolTip.getText();
        logger.info("Displayed tooltip text: {}", text);
        return text;
    }

}
