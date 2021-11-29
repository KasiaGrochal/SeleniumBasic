package pages;

import basePage.BasePage;
import handlers.FileHandler;
import models.WebElementsActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.List;


public class FormPage extends BasePage {

    public FormPage(WebDriver driver) {
        super(driver);
    }
    public  final String expectedFileName = "test-file-to-download.xlsx";
    private static final String formPageUrl = "https://seleniumui.moderntester.pl/form.php";
    public static final String expectedSuccessMessage = "Form send with success";


    public FormPage openWebsite() {
        driver.get(formPageUrl);
        return this;
    }

    @FindBy(css = "#inputFirstName3")
    private WebElement firstNameBox;

    public FormPage fillInFirstName(String firstName) {
        firstNameBox.sendKeys(firstName);
        return this;
    }

    @FindBy(css = "#inputLastName3")
    private WebElement lastNameBox;

    public FormPage fillInLastName(String lastName) {
        lastNameBox.sendKeys(lastName);
        return this;
    }

    @FindBy(css = "#inputEmail3")
    private WebElement emailBox;

    public FormPage fillInEmail(String email) {
        emailBox.sendKeys(email);
        return this;
    }

    @FindBy(name = "gridRadiosSex")
    private List<WebElement> sexList;

    public FormPage selectRandomSex() {
        WebElementsActions.getRandomWebElementFromList(sexList).click();
        return this;
    }

    @FindBy(css = "#inputAge3")
    private WebElement ageBox;

    public FormPage fillInAge(String age) {
        ageBox.sendKeys(age);
        return this;
    }

    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> yearsOfExperienceList;

    public FormPage selectRandomYearOfExperience() {
        WebElementsActions.getRandomWebElementFromList(yearsOfExperienceList).click();
        return this;
    }

    @FindBy(css = "#gridCheckAutomationTester")
    private WebElement automationTesterCheckbox;

    public FormPage selectAutomationTesterProfession() {
        automationTesterCheckbox.click();
        return this;
    }

    @FindBy(css = "#selectContinents")
    private WebElement continentsDropDown;

    public FormPage selectRandomContinent() {
        List<WebElement> allContinents = WebElementsActions.getWebelementListFromDropdownList(continentsDropDown);
        for (int i = 0; i < 1; i++) {
            WebElement randomContinent = WebElementsActions.getRandomWebElementFromList(allContinents);
            if (randomContinent.getAttribute("value").isEmpty()) {
                i--;
            }
            randomContinent.click();
        }
        return this;
    }

    @FindBy(css = "[value='switch-commands']")
    private WebElement seleniumSwitchCommand;
    @FindBy(css = "[value='wait-commands']")
    private WebElement seleniumWaitCommand;

    public FormPage selectSeleniumSwitchCommand() {
        seleniumSwitchCommand.click();
        return this;
    }

    public FormPage selectSeleniumWaitCommand() {
        seleniumWaitCommand.click();
        return this;
    }


    @FindBy(css = "#chooseFile")
    private WebElement chooseFileBox;

    public FormPage uploadFile(File file) {
        chooseFileBox.sendKeys(file.getAbsolutePath());
        return this;
    }

    @FindBy(css = "[class= 'btn btn-primary']")
    private WebElement signInButton;

    public FormPage clickSignIn() {
        signInButton.click();
        return this;
    }

    @FindBy(css = "[class= 'col-sm-12 success']")
    private WebElement signInSuccessMessage;

    public String displayedSuccessMessageText() {
        waitForWebElement(driver, signInSuccessMessage);
        return signInSuccessMessage.getText();
    }

    public String expectedMessageText(String expectedMessage) {
        return expectedMessage;
    }

    @FindBy(css = "[class= 'btn btn-secondary btn-lg active']")
    private WebElement testFileToDownloadButton;

    public FormPage clickTestFileDownloadButton() {
        testFileToDownloadButton.click();
        waitForFile(driver, FileHandler.downloadedFile);
        return this;
    }

}
