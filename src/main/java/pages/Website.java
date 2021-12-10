package pages;


import org.openqa.selenium.WebDriver;
import pages.basic.MainPage;

public class Website extends BasePage {


    public Website(WebDriver driver) {
        super(driver);
    }
    private final String webUrl = "https://seleniumui.moderntester.pl";

    public MainPage openWebsite(){
        driver.get(webUrl);
        logger.info("Website {}, opened successfully on the Main Page.", webUrl);
        return new MainPage(driver);
    }

}
