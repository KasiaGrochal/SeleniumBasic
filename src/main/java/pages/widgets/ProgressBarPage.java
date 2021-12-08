package pages.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class ProgressBarPage extends BasePage {

    Logger logger = LoggerFactory.getLogger(ProgressBarPage.class);

    public ProgressBarPage(WebDriver driver) {
        super(driver);
    }

    public static String expectedText = "Complete!";

    @FindBy(css = "#progressbar")
    private WebElement progressBar;

    public String getProgressBarLoadedText() {
        waitForWebElementAttributeToBe(progressBar, "aria-valuenow", "100");
        String loadedText = progressBar.getText();
        logger.info("Displayed text after progressbar is loaded: {} ", loadedText);
        return loadedText;
    }


}
