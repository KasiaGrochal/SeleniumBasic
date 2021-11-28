package models;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class WebElementsActions {
    public static WebElement selectRandomOptionFromList(List<WebElement> list) {
        int randomNumber = new Random().nextInt(list.size());
        return list.get(randomNumber);
    }
}
