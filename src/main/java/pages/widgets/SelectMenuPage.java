package pages.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class SelectMenuPage extends BasePage {

    Logger logger = LoggerFactory.getLogger(SelectMenuPage.class);

    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#speed-menu .ui-menu-item")
    private List<WebElement> dropdownSpeedOptions;

    @FindBy(css = "#files-menu .ui-menu-item")
    private List<WebElement> dropdownFileOptions;

    @FindBy(css = "#number-menu .ui-menu-item")
    private List<WebElement> dropdownNumberOptions;

    @FindBy(css = "#salutation-menu .ui-menu-item")
    private List<WebElement> dropdownTitleOptions;


    @FindBy(css = "#speed-button")
    private WebElement speedButton;

    @FindBy(css = "#files-button")
    private WebElement filesButton;

    @FindBy(css = "#number-button")
    private WebElement numberButton;

    @FindBy(css = "#salutation-button")
    private WebElement titleButton;


    public SelectMenuPage clickOnSelectSpeedDropdown() {
        waitForWebElementToBeClickable(speedButton);
        speedButton.click();
        logger.info("Clicked on select speed dropdown");
        return this;
    }

    public SelectMenuPage selectRandomSpeed() {
        waitForWebElementToBeVisable(dropdownSpeedOptions.get(0));
        getRandomWebElementFromList(dropdownSpeedOptions).click();
        logger.info("Selected random speed option");
        return this;
    }

    public SelectMenuPage clickOnSelectFileButton() {
        filesButton.click();
        logger.info("Clicked on select file button");
        return this;
    }

    public SelectMenuPage clickOnSelectNumberButton() {
        numberButton.click();
        logger.info("Clicked on Select a Number button");
        return this;
    }

    public SelectMenuPage clickOnSelectTitleButton() {
        titleButton.click();
        logger.info("Clicked on Select a Title button");
        return this;
    }


    public SelectMenuPage chooseFileByVisibleText(String text) {
        waitForWebElementToBeVisable(dropdownFileOptions.get(0));
        for (WebElement element : dropdownFileOptions) {
            if (element.getText().equals(text)) {
                element.click();
                logger.info("Clicked on file {}", text);
            }
        }
        return this;
    }

    public SelectMenuPage chooseNumberByIndex(int index) {
        waitForWebElementToBeVisable(dropdownNumberOptions.get(0));
        WebElement option = dropdownNumberOptions.get(index);
        option.click();
        logger.info("Clicked on element with index {}", index);
        return this;
    }

    private List<WebElement> getAvailableTitleList() {
        List<WebElement> availableTitles = new ArrayList<>();
        for (WebElement webElement : dropdownTitleOptions) {
            if (!webElement.getAttribute("class").contains("ui-state-disabled")) {
                availableTitles.add(webElement);
            }
        }
        return availableTitles;
    }

    public SelectMenuPage chooseRandomTitle() {
        waitForWebElementToBeVisable(dropdownTitleOptions.get(0));
        List<WebElement> availableTitles = getAvailableTitleList();
        WebElement option = getRandomWebElementFromList(availableTitles);
        String optionTitle = option.getText();
        option.click();
        logger.info("Chose random title: {}", optionTitle);
        return this;
    }


}
