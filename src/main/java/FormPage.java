import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class FormPage extends BasePage {

    public FormPage(WebDriver driver) {
        super(driver);
    }
    private static final String formPageUrl = "https://seleniumui.moderntester.pl/form.php";
    protected static final String expectedSuccessMessage = "Form send with success";

    public FormPage openWebsite() {
        driver.get(formPageUrl);
        return this;
    }

    @FindBy(css = "#inputFirstName3")
    private WebElement firstNameBox;

    public FormPage fillInFirstName() {
        firstNameBox.sendKeys(FakeDataGenerator.getFakeFirstName());
        return this;
    }

    @FindBy(css = "#inputLastName3")
    private WebElement lastNameBox;

    public FormPage fillInLastName() {
        lastNameBox.sendKeys(FakeDataGenerator.getFakeLastName());
        return this;
    }

    @FindBy(css = "#inputEmail3")
    private WebElement emailBox;

    public FormPage fillInEmail() {
        emailBox.sendKeys(FakeDataGenerator.getFakeEmail());
        return this;
    }

    @FindBy(name = "gridRadiosSex")
    private List<WebElement> sexList;

    public FormPage selectRandomSex() {
        selectRandomOptionFromList(sexList);
        return this;
    }

    @FindBy(css = "#inputAge3")
    private WebElement ageBox;

    public FormPage fillInAge() {
        ageBox.sendKeys(FakeDataGenerator.getFakeAdultAge());
        return this;
    }

    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> yearsOfExperienceList;

    public FormPage selectRandomYearOfExperience() {
        selectRandomOptionFromList(yearsOfExperienceList);
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
        Select select = new Select(continentsDropDown);
        List<WebElement> allContinents = select.getOptions();
        continentsDropDown.click();
        selectRandomOptionFromList(allContinents);
        return this;
    }

    @FindBy(css = "[value='switch-commands']")
    private WebElement seleniumSwitchCommand;
    @FindBy(css = "[value='wait-commands']")
    private WebElement seleniumWaitCommand;

    public FormPage selectSeleniumCommands() {
        seleniumSwitchCommand.click();
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

    public String successMessageText() {
        return signInSuccessMessage.getText();
    }

    public String expectedMessageText(String expectedMessage) {
        return expectedMessage;
    }

    @FindBy(css = "[class= 'btn btn-secondary btn-lg active']")
    private WebElement testFileToDownloadButton;

    public FormPage clickTestFileDownloadButton() {
        testFileToDownloadButton.click();
        return this;
    }

   public boolean verifyIfFileIsDownloadedByFolderSize(int folderSizeBeforeDownload) {
        waitForFile(driver, FileHandler.downloadedFile);
        int folderSizeAfterDownload = FileHandler.getCurrentFolderSize(FileHandler.downloadedFilesFolder);
        if (folderSizeBeforeDownload + 1 == folderSizeAfterDownload) {
            FileHandler.downloadedFile.delete();
            return true;
        }
        return false;
    }

    public boolean verifyIfFileIsDownloadedByFileName(String expectedFileName) {
        waitForFile(driver, FileHandler.downloadedFile);
        List<File> listOfFiles = Arrays.asList(FileHandler.downloadedFilesFolder.listFiles());
        boolean found = false;
        for (File file : listOfFiles) {
            if (FormatTextHandler.formatFilename(file).equals(expectedFileName)) {

                found = true;
            }
        }
        if (found) {
            FileHandler.downloadedFile.delete();
            return true;
        }
        return false;
    }

    private void selectRandomOptionFromList(List<WebElement> list) {
        int randomNumber = new Random().nextInt(list.size());
        list.get(randomNumber).click();
    }


}
