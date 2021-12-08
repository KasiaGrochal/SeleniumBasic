package pages.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class MessageWindow extends BasePage {

    public MessageWindow(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "body")
    private WebElement messageBody;

    public MessageWindow getText() {
        System.out.println(messageBody.getText());
        return this;
    }

}
