package pages.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.util.List;

public class TablePage extends BasePage {

    Logger logger = LoggerFactory.getLogger(TablePage.class);

    public TablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "tbody tr")
    private List<WebElement> rows;


    public TablePage filterTableByStateAndHeight() {

        for (WebElement webElement : rows) {
            String peak = webElement.findElements(By.cssSelector("td")).get(0).getText();
            String mountainRange = webElement.findElements(By.cssSelector("td")).get(1).getText();
            String rank = webElement.findElements(By.cssSelector("[scope= 'row']")).get(0).getText();
            String state = webElement.findElements(By.cssSelector("td")).get(2).getText();
            int height = Integer.parseInt(webElement.findElements(By.cssSelector("td")).get(3).getText());

            if ((state.equals("Switzerland")) && (height > 4000)) {
                System.out.println(rank + " - " + peak + " - " + mountainRange);
            }
        }
        return this;
    }

}

