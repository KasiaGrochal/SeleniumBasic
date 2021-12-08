package pages.basic;

import handlers.FileHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.io.File;
import java.util.List;


public class FormPage extends BasePage {
    Logger logger = LoggerFactory.getLogger(FormPage.class);

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public static final String expectedFileName = "test-file-to-download.xlsx";
    private static final String formPageUrl = "https://seleniumui.moderntester.pl/form.php";
    public static final String expectedSuccessMessage = "Form send with success";


    @FindBy(css = "#inputFirstName3")
    private WebElement firstNameBox;

    @FindBy(css = "#inputLastName3")
    private WebElement lastNameBox;

    @FindBy(css = "#inputEmail3")
    private WebElement emailBox;

    @FindBy(name = "gridRadiosSex")
    private List<WebElement> sexList;

    @FindBy(css = "#inputAge3")
    private WebElement ageBox;

    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> yearsOfExperienceList;

    @FindBy(css = "#gridCheckAutomationTester")
    private WebElement automationTesterCheckbox;

    @FindBy(css = "#selectContinents")
    private WebElement continentsDropDown;

    @FindBy(css = "[value='switch-commands']")
    private WebElement seleniumSwitchCommand;

    @FindBy(css = "[value='wait-commands']")
    private WebElement seleniumWaitCommand;

    @FindBy(css = "#chooseFile")
    private WebElement chooseFileBox;

    @FindBy(css = "[class= 'btn btn-primary']")
    private WebElement signInButton;

    @FindBy(css = "[class= 'col-sm-12 success']")
    private WebElement signInSuccessMessage;

    @FindBy(css = "[class= 'btn btn-secondary btn-lg active']")
    private WebElement testFileToDownloadButton;

    public FormPage openWebsite() {
        driver.get(formPageUrl);
        logger.info("{} -website opened successfully", formPageUrl);
        return this;
    }

    public FormPage fillInFirstName(String firstName) {
        firstNameBox.sendKeys(firstName);
        logger.info("First name box filled in with: {}", firstName);
        return this;
    }

    public FormPage fillInLastName(String lastName) {
        lastNameBox.sendKeys(lastName);
        logger.info("Last name box filled in with: {}", lastName);
        return this;
    }

    public FormPage fillInEmail(String email) {
        emailBox.sendKeys(email);
        logger.info("Email box filled in with: {}", email);
        return this;
    }

    public FormPage selectRandomSex() {
        WebElement randomSex = getRandomWebElementFromList(sexList);
        randomSex.click();
        logger.info("Selected random sex: {}", randomSex.getAttribute("value"));
        return this;
    }

    public FormPage fillInAge(String age) {
        ageBox.sendKeys(age);
        logger.info("Age box filled in with: {}", age);
        return this;
    }

    public FormPage selectRandomYearOfExperience() {
        WebElement randomYearOfExp = getRandomWebElementFromList(yearsOfExperienceList);
        randomYearOfExp.click();
        logger.info("Selected random Year of Experience: {}", randomYearOfExp.getAttribute("value"));
        return this;
    }

    public FormPage selectAutomationTesterProfession() {
        automationTesterCheckbox.click();
        logger.info("Selected Automation Tester Profession");
        return this;
    }

    public FormPage selectRandomContinent() {
        String randomContinent = selectRandomOption(continentsDropDown, 1);
        logger.info("Selected random continent: {}", randomContinent);
        return this;
    }

    public FormPage selectSeleniumSwitchCommand() {
        seleniumSwitchCommand.click();
        logger.info("Selected Selenium Switch Command");
        return this;
    }

    public FormPage selectSeleniumWaitCommand() {
        seleniumWaitCommand.click();
        logger.info("Selected Selenium Wait Command");
        return this;
    }

    public FormPage uploadFile(File file) {
        chooseFileBox.sendKeys(file.getAbsolutePath());
        logger.info("Uploaded file from: {}", file.getAbsolutePath());
        return this;
    }

    public FormPage clickSignIn() {
        signInButton.click();
        logger.info("Clicked on Sign in button");
        return this;
    }

    public String displayedSuccessMessageText() {
        waitForWebElementToBeVisable(signInSuccessMessage);
        String successMessage = signInSuccessMessage.getText();
        logger.info("Success message displayed: '{}'", successMessage);
        logger.info("Expected success message: '{}'", expectedSuccessMessage);
        return successMessage;
    }

    public FormPage clickTestFileDownloadButton() {
        testFileToDownloadButton.click();
        logger.info("Clicked on 'Test File to Download' button");
        waitForFile(driver, FileHandler.downloadedFile);
        return this;
    }

}
