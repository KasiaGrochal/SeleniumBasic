package pages.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.util.List;

public class AutocompletePage extends BasePage {

    Logger logger = LoggerFactory.getLogger(AutocompletePage.class);

    public AutocompletePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#search")
    WebElement searchBox;

    @FindBy(css = ".ui-menu-item")
    List<WebElement> searchHints;

    public AutocompletePage typeLetters(String letters) {
        searchBox.sendKeys(letters);
        logger.info("Typed in letters: '{}'", letters);
        return this;
    }

    public AutocompletePage printAllAvailableOptions() {
        for (WebElement hint : searchHints) {
            System.out.println(hint.getText());
        }
        logger.info("Printed all available options");
        return this;
    }

    public AutocompletePage selectRandomAvailableOption(List<String> selected) {
        WebElement randomElement = getRandomWebElementFromList(searchHints);
        String randomElementText = randomElement.getText();
        selected.removeAll(selected);
        selected.add(randomElementText);
        randomElement.click();
        logger.info("Selected random option: {}", randomElementText);
        return this;
    }

    public String getCurrentSearchBoxText() {
        String text = searchBox.getAttribute("value");
        return text;
    }
}
