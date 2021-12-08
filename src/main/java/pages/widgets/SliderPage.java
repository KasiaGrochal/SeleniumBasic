package pages.widgets;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class SliderPage extends BasePage {

    Logger logger = LoggerFactory.getLogger(SliderPage.class);

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#custom-handle")
    WebElement sliderPin;

    public int getCurrentSliderValue() {
        return Integer.parseInt(sliderPin.getText());
    }

    public SliderPage moveSliderToValue(int value) {
        if (getCurrentSliderValue() > value) {
            moveTo(value, Keys.ARROW_LEFT);
            logger.info("Moved left to value: {}", value);
        } else if (getCurrentSliderValue() < value) {
            moveTo(value, Keys.ARROW_RIGHT);
            logger.info("Moved right to value: {}", value);
        }
        return this;
    }

    private SliderPage moveTo(int value, Keys keysLeftRight) {
        while (value != getCurrentSliderValue()) {
            sliderPin.sendKeys(keysLeftRight);
        }
        return this;
    }


}
