package models;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class WebElementsActions {

    public static WebElement getRandomWebElementFromList(List<WebElement> list) {
        int randomNumber = new Random().nextInt(list.size());
        return list.get(randomNumber);
    }

    public static List<WebElement> getWebelementListFromDropdownList(WebElement webElement) {
        Select select = new Select(webElement);
        return select.getOptions();
    }
}
