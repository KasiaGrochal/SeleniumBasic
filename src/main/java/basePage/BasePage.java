package basePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.time.Duration;


public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForFile(WebDriver driver, File file) {
        FluentWait<WebDriver> wait = new FluentWait(driver);
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.withTimeout(Duration.ofSeconds(10));
        wait.until(x -> file.exists());
    }

    public void waitForWebElement(WebDriver driver, WebElement webElement) {
        FluentWait<WebDriver> wait = new FluentWait(driver);
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.withTimeout(Duration.ofSeconds(10));
        wait.until(x -> webElement.isDisplayed());
    }

}
