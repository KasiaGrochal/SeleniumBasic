package pages.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.util.List;

public class IframesPage extends BasePage {
    Logger logger = LoggerFactory.getLogger(IframesPage.class);

    public IframesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[name= 'iframe1']")
    private WebElement iframe1;

    @FindBy(css = "[name= 'iframe2']")
    private WebElement iframe2;

    @FindBy(css = "#inputFirstName3")
    private WebElement firstNameBox;

    @FindBy(css = "#inputSurname3")
    private WebElement surNameBox;

    @FindBy(css = "#inputLogin")
    private WebElement loginBox;

    @FindBy(css = "#inputPassword")
    private WebElement passwordBox;

    @FindBy(css = "#inlineFormCustomSelectPref")
    private WebElement continentsDropdown;

    @FindBy(css = "[name='gridRadios']")
    private List<WebElement> yearOfExperienceList;

    public IframesPage switchToIframe1() {
        driver.switchTo().frame(iframe1);
        logger.info("Switched to iframe1");
        return this;
    }

    public IframesPage switchToIframe2() {
        driver.switchTo().frame(iframe2);
        logger.info("Switched to iframe2");
        return this;
    }

    public IframesPage switchToParentFrame() {
        driver.switchTo().parentFrame();
        logger.info("Switched to parentFrame");
        return this;
    }

    public IframesPage fillInFirstName(String firstName) {
        firstNameBox.sendKeys(firstName);
        logger.info("First name box filled in with: {}", firstName);
        return this;
    }

    public IframesPage fillInSurName(String surName) {
        surNameBox.sendKeys(surName);
        logger.info("Surname box filled in with: {}", surName);
        return this;
    }

    public IframesPage fillInLogin(String login) {
        loginBox.sendKeys(login);
        logger.info("Login box filled in with: {}", login);
        return this;
    }

    public IframesPage fillInPassword(String password) {
        passwordBox.sendKeys(password);
        logger.info("Password box filled in with: {}", password);
        return this;
    }

    public IframesPage selectRandomContinent() {
        String randomContinent = selectRandomOption(continentsDropdown, 1);
        logger.info("Selected random continent: {}", randomContinent);
        return this;
    }

    public IframesPage selectRandomYearOfExperience() {
        WebElement randomYearOfExp = getRandomWebElementFromList(yearOfExperienceList);
        randomYearOfExp.click();
        logger.info("Selected random year of experience: {}", randomYearOfExp.getAttribute("value"));
        return this;
    }


}
