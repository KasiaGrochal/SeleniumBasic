package pages.interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortablePage extends BasePage {

    Logger logger = LoggerFactory.getLogger(SortablePage.class);

    public SortablePage(WebDriver driver) {
        super(driver);
    }

    public static List<String> shuffledList;

    @FindBy(css = ".ui-sortable-handle")
    private List<WebElement> listOfItems;


    private List<String> shuffleList() {
        List<String> list = getCurrentItemListOrder();
        Collections.shuffle(list);
        logger.info("List was shuffled");
        return list;
    }

    public List<String> getCurrentItemListOrder() {
        List<String> myItems = new ArrayList<>();
        for (WebElement element : listOfItems) {
            myItems.add(element.getText());
        }
        logger.info("Current displayed item list order: {}", myItems);
        return myItems;
    }


    public SortablePage shuffleItems() {
        shuffledList = shuffleList();
        for (String shuffItem : shuffledList) {
            for (WebElement element : listOfItems) {
                String elementText = element.getText();
                if (elementText.equals(shuffItem)) {
                    action.dragAndDrop(element, listOfItems.get(shuffledList.indexOf(shuffItem))).build().perform();
                }
            }
        }
        return this;
    }


}
