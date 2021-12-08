package pages.others;

import handlers.DateHandler;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.io.File;
import java.io.IOException;


public class HighSitePage extends BasePage {

    Logger logger = LoggerFactory.getLogger(HighSitePage.class);


    public HighSitePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".show-button")
    private WebElement showSubmitButton;

    @FindBy(css = "#scroll-button")
    private WebElement submitButton;

    @FindBy(css = "#high-site>p:nth-child(10)")
    private WebElement proc90;


    public HighSitePage scrollDownToSubmitButton() {
        scrollDownTo(showSubmitButton);
        return this;
    }

    private HighSitePage scrollDownTo(WebElement webElement) {
        int webHeight = driver.manage().window().getSize().getHeight();
        int moveBy = webHeight / 4;
        int repeat = webElement.getLocation().getY() / moveBy;

        for (int i = 0; i < repeat; i++) {
            jsExecutor.executeScript("window.scrollBy(0,arguments[0])", moveBy);
        }

        return this;
    }

    public boolean isSubmitButtonVisible() throws IOException {
        if (submitButton.isDisplayed()) {
            File screenFile = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenFile, new File("src/test/highSiteTestScreenshots/" + DateHandler.getCurrentDateForFileNames() + ".png"));
            logger.info("Screenshot saved properly");
            return true;
        }
        return false;

    }
}
