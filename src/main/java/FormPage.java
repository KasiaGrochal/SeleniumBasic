import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormPage extends BasePage {

    public FormPage(WebDriver driver) {
        super(driver);
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
        File file = new File("src/test/testFiles/test1");
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

    public boolean successMessageShouldBeVisible(){

        return signInSuccessMessage.isDisplayed();

    }

    public String expectedMessage(){
        String expectedMessage = "Form send with success";
        return expectedMessage;
    }


    private FormPage selectRandomOptionFromList(List<WebElement> list) {
        int randomNumber = new Random().nextInt(list.size());
        list.get(randomNumber).click();

        return this;

    }

}
