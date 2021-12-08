package pages.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class MenuPage extends BasePage {

    Logger logger = LoggerFactory.getLogger(MenuPage.class);

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#ui-id-9")
    private WebElement musicTab;

    @FindBy(css = "#ui-id-13")
    private WebElement jazzTab;

    @FindBy(css = "#ui-id-16")
    private WebElement modernTab;

    public MenuPage clickOnMusicTab() {
        musicTab.click();
        logger.info("Clicked on Music tab");
        return this;
    }

    public MenuPage clickOnJazzTab() {
        waitForWebElementToBeClickable(jazzTab);
        jazzTab.click();
        logger.info("Clicked on Jazz tab");
        return this;
    }

    public MenuPage clickOnModernTab() {
        waitForWebElementToBeClickable(modernTab);
        modernTab.click();
        logger.info("Clicked on Modern tab");
        return this;
    }


}
