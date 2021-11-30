package basePage;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Random;


public abstract class BasePage {
Logger logger = LoggerFactory.getLogger(BasePage.class);
    protected WebDriver driver;
    protected Random rnd;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.rnd = new Random();
        PageFactory.initElements(driver, this);
    }

    public void waitForFile(WebDriver driver, File file) {
        logger.info("Start waiting for file- Timeout set to 5 seconds");
        try {
            FluentWait<WebDriver> wait = new FluentWait<>(driver);
            wait.pollingEvery(Duration.ofSeconds(1));
            wait.withTimeout(Duration.ofSeconds(5));
            wait.until(x -> file.exists());
        } catch (TimeoutException e) {
            logger.error("Timeout exception file: {}, doesn't exist",file.getName());
        }
        logger.info("File: {} exists",file.getName());
    }

    public void waitForWebElement(WebDriver driver, WebElement webElement) {
        logger.info("Start waiting for Webelement- Timeout set to 5 seconds");
        try {
            FluentWait<WebDriver> wait = new FluentWait<>(driver);
            wait.pollingEvery(Duration.ofSeconds(1));
            wait.withTimeout(Duration.ofSeconds(5));
            wait.ignoring(NoSuchElementException.class);
            wait.until(x -> webElement.isDisplayed());
        } catch (TimeoutException e) {
            logger.error("Timeout exception, cause: " +e.getCause());

        }
    }

    public String selectRandomOption(WebElement element, int startIndex){
        Select select = new Select(element);
        int random=rnd.ints(startIndex, select.getOptions().size()).findFirst().getAsInt();
        select.selectByIndex(random);
        return select.getOptions().get(random).getText();
    }

    public WebElement getRandomWebElementFromList(List<WebElement> list) {
        int randomNumber = new Random().nextInt(list.size());
        return list.get(randomNumber);
    }



}
