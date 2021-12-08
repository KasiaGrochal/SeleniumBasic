package pages.interactions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.util.List;

public class SelectablePage extends BasePage {

    Logger logger = LoggerFactory.getLogger(SelectablePage.class);

    public SelectablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".ui-selectee")
    List<WebElement> selectableItems;

    @FindBy(css = "#feedback")
    WebElement youSelectedText;

    public SelectablePage selectItem(int itemIndex) {
        action.keyDown(Keys.CONTROL).build().perform();
        WebElement selectedItem = selectableItems.get(itemIndex - 1);
        selectedItem.click();
        logger.info("Selected item: {}", selectedItem.getText());
        return this;
    }

    public String getYouSelectedText() {
        String text = youSelectedText.getText();
        logger.info("Displayed text: {}", text);
        return text;
    }
}
