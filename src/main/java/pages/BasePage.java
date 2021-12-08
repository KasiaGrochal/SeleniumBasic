package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Locator;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Random;


public abstract class BasePage {
Logger logger = LoggerFactory.getLogger(BasePage.class);
    protected WebDriver driver;
    protected Random rnd;
    protected WebDriverWait webDriverwait;
    protected Actions action;
    protected JavascriptExecutor jsExecutor;
    protected TakesScreenshot screenshot;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.rnd = new Random();
        this.webDriverwait = new WebDriverWait(driver,10);
        this.action = new Actions(driver);
        this.jsExecutor = (JavascriptExecutor) driver;
        this.screenshot =(TakesScreenshot) driver;
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

    public void waitForWebElementToBeClickable(WebElement webElement) {
        logger.info("Start waiting for WebElement to be clickable- Timeout set to 10 seconds");
        webDriverwait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
    public void waitForWebElementToBeVisable(WebElement webElement){
        logger.info("Start waiting for Webelement to be visible- Timeout set to 10 seconds");
        webDriverwait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitForWebElementAttributeToBe(WebElement webElement, String attribute, String value){
        logger.info("Start waiting for webelement attribute: '" +attribute+"' to be: '"+value+"' - Timeout set to 10 seconds");
        webDriverwait.until(ExpectedConditions.attributeToBe(webElement,attribute,value));
    }

    public void waitForAlertWindow(){
        logger.info("Start waiting for Alert window- Timeout set to 10 seconds");
        webDriverwait.until(ExpectedConditions.alertIsPresent());
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

    public int getRandomInt(int bound){
        return rnd.nextInt(bound);
    }

    public void closeCurrentWindow(){
        driver.close();
    }



}
