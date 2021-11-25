import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;


import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Random;



public class FormPage extends BasePage {

    private final String downloadPath = "src/test/downloadedTestFiles";
    private final String downloadedFileName = "test-file-to-download.xlsx";
    private File downloadedFilesFolder = new File(downloadPath);
    File downloadedFile =new File("src/test/downloadedTestFiles/test-file-to-download.xlsx");

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public FormPage openWebsite(String webUrl){
        driver.get(webUrl);
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
        selectRandomOptionFromList(sexList);
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

    public FormPage selectSeleniumCommands(){
    seleniumSwitchCommand.click();
    seleniumWaitCommand.click();
    return this;
    }

    @FindBy(css = "#chooseFile")
    private WebElement chooseFileBox;

    public FormPage uploadFile(){
        File file = new File("src/test/testFilesToUpload/test1");
        chooseFileBox.sendKeys(file.getAbsolutePath());
        return this;
    }

    @FindBy (css = "[class= 'btn btn-primary']")
    private WebElement signInButton;

    public FormPage clickSignIn() {
        signInButton.click();
        return this;
    }

    @FindBy (css = "[class= 'col-sm-12 success']")
    private WebElement signInSuccessMessage;

    public String successMessageText(){
        return signInSuccessMessage.getText();
    }

    public String expectedMessageText(String expectedMessage){
        return expectedMessage;
    }

    @FindBy (css = "[class= 'btn btn-secondary btn-lg active']")
    private WebElement testFileToDownloadButton;

    public FormPage clickTestFileDownloadButton(){
        testFileToDownloadButton.click();
        return this;
    }

    public boolean verifyIfFileIsDownloadedByFolderSize() {
        int before =getCurrentFolderSize(downloadedFilesFolder);
        clickTestFileDownloadButton();
        waitForFile(driver,downloadedFile);

                int after = getCurrentFolderSize(downloadedFilesFolder);
                if (before+1==after){
                    downloadedFile.delete();
                    return true;
                }           return false;
    }

    public int getCurrentFolderSize(File file){
        return file.list().length;
    }

    public boolean checkIfFileIsDownloadedByFileName(String fileName){
        waitForFile(driver,downloadedFile);
        List<File> listOfFiles = Arrays.asList(downloadedFilesFolder.listFiles());
        boolean found=false;
        for (File file: listOfFiles) {
            if (FormatTextHelper.formatFilename(file).equals(fileName)){
                file.delete();
                found=true;
            }
        }
        if (found){
            return true;
        }
        return false;
    }

    private void selectRandomOptionFromList(List<WebElement> list) {
        int randomNumber = new Random().nextInt(list.size());
        list.get(randomNumber).click();
    }



}
