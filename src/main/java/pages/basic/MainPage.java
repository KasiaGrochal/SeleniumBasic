package pages.basic;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;
import pages.TopBarPage;

public class MainPage extends BasePage {
    Logger logger = LoggerFactory.getLogger(MainPage.class);

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public TopBarPage navigateToTopBarPage() {
        logger.info("Navigating to TopBarPage");
        return new TopBarPage(driver);
    }
}
