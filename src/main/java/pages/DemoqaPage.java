package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class DemoqaPage extends BasePage {
    Logger logger = LoggerFactory.getLogger(DemoqaPage.class);

    public DemoqaPage(WebDriver driver) {
        super(driver);
    }

    private static String webUrl = "https://demoqa.com/automation-practice-form";


    @FindBy(css = ".subjects-auto-complete__input input")
    private WebElement subjectsBox;

    @FindBy(css = ".subjects-auto-complete__option")
    private List<WebElement> subjectValues;

    @FindBy(css = "#close-fixedban")
    private WebElement closeAdd;

    @FindBy(css = ".css-1rhbuit-multiValue")
    private List<WebElement> chosenOptions;

    @FindBy(css = ".subjects-auto-complete__clear-indicator")
    private WebElement subjectBoxCross;


    public DemoqaPage closeAd() {
        waitForWebElementToBeClickable(closeAdd);
        closeAdd.click();
        return this;
    }


    public DemoqaPage typeLettersToSubjectBox(String letters) {
        subjectsBox.sendKeys(letters);
        logger.info("Typed in letters: '{}'", letters);
        return this;
    }

    public DemoqaPage openWebsite() {
        driver.get(webUrl);
        logger.info("Website {}, opened successfully", webUrl);
        return this;
    }

    public DemoqaPage selectElementFromSubjects(String subjectName, List<String> expectedList) {
        waitForWebElementToBeClickable(subjectValues.get(0));
        for (WebElement subject : subjectValues) {
            if (subject.getText().equals(subjectName)) {
                String subjectText = subject.getText();
                expectedList.add(subjectText);
                subject.click();
                logger.info("Selected element: {}", subjectText);
                break;
            }
        }
        return this;
    }

    public DemoqaPage selectRandomElementFromSubjects(List<String> expectedList) {
        waitForWebElementToBeClickable(subjectValues.get(0));
        WebElement random = getRandomWebElementFromList(subjectValues);
        String randomElementText = random.getText();
        expectedList.add(randomElementText);
        random.click();
        logger.info("Selected random element: {}", randomElementText);
        return this;
    }

    public List<String> getSubjectSelectedElementsList() {
        List<String> listOfSubjectString = new ArrayList<>();

        for (WebElement element : chosenOptions) {
            listOfSubjectString.add(element.getText());
        }
        logger.info("Subject chosen option displayed: {}", listOfSubjectString);
        return listOfSubjectString;
    }

    private WebElement getLastAddedSubject() {
        WebElement lastAddedSubject = chosenOptions.get(chosenOptions.size() - 1);
        logger.info("Last added subject is: {}", lastAddedSubject.getText());
        return lastAddedSubject;
    }

    public DemoqaPage clickCrossOnLastAddedSubject(List<String> expectedList) {
        WebElement lastSubject = getLastAddedSubject();
        String lastSubjectText = lastSubject.getText();
        lastSubject.findElement(By.cssSelector(".css-19bqh2r")).click();
        logger.info("Clicked on cross on the last selected subject");
        expectedList.remove(lastSubjectText);
        logger.info("Removed {}, from expectedList", lastSubjectText);
        return this;
    }

    public DemoqaPage clickOnSubjectBoxCross(List<String> expectedList) {
        subjectBoxCross.click();
        logger.info("Clicked on subject box cross");
        expectedList.removeAll(expectedList);
        return this;
    }


}
