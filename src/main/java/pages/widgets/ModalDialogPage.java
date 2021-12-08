package pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class ModalDialogPage extends BasePage {

    Logger logger = LoggerFactory.getLogger(ModalDialogPage.class);


    public ModalDialogPage(WebDriver driver) {
        super(driver);
    }


    private List<String> addedUserDetails = new ArrayList<>();

    @FindBy(css = "#create-user")
    private WebElement createNewUserButton;

    @FindBy(css = ".ui-dialog")
    private WebElement createUserDialog;

    @FindBy(css = "#name")
    private WebElement tabFullName;

    @FindBy(css = "#email")
    private WebElement tabEmail;

    @FindBy(css = "#password")
    private WebElement tabPassword;

    @FindBy(css = ".ui-dialog-buttonset :first-child")
    private WebElement createAnAccountButton;

    @FindBy(css = "tbody > tr")
    private List<WebElement> existingUsersList;

    public ModalDialogPage clickOnCreateNewUserButton() {
        createNewUserButton.click();
        waitForWebElementToBeVisable(createUserDialog);
        logger.info("Clicked on 'Create new user' Button");
        return this;
    }

    public ModalDialogPage fillInFullName(String fullName) {
        waitForWebElementToBeClickable(tabFullName);
        tabFullName.clear();
        tabFullName.sendKeys(fullName);
        addedUserDetails.add(fullName);
        logger.info("Full name filled with: {}", fullName);
        return this;
    }

    public ModalDialogPage fillInEmail(String email) {
        tabEmail.clear();
        tabEmail.sendKeys(email);
        addedUserDetails.add(email);
        logger.info("Email filled with: {}", email);
        return this;
    }

    public ModalDialogPage fillInPassword(String password) {
        tabPassword.clear();
        tabPassword.sendKeys(password);
        addedUserDetails.add(password);
        logger.info("Password filled with: {}", password);
        return this;
    }

    public ModalDialogPage clickOnCreateAnAccountButton() {
        createAnAccountButton.click();
        logger.info("Clicked on 'Create an account' button");
        return this;
    }

    public boolean doesLastAddedUserExistOnUserList(){
        return (addedUserDetails.get(0).equals(getLastAddedName())
                && (addedUserDetails.get(1).equals(getLastAddedUserName()))
                && (addedUserDetails.get(2).equals(getLastAddedPassword())));
    }

    private String getLastAddedName(){
      return   getLastAdded("td");
    }

    private String getLastAddedUserName(){
        return   getLastAdded("td:nth-child(2)");
    }

    private String getLastAddedPassword(){
        return   getLastAdded("td:nth-child(3)");
    }

    private String getLastAdded(String selector){
        String lastAdded=existingUsersList.get(existingUsersList.size()-1).findElement(By.cssSelector(selector)).getText();
        logger.info("Last added user details displayed: {}",lastAdded);
        return existingUsersList.get(existingUsersList.size()-1).findElement(By.cssSelector(selector)).getText();
    }

}
