package pages.basic.tablePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import pages.BasePage;


public class RowPage extends BasePage {
    @FindBy(css = "th")
    private WebElement rank;

    @FindBy(css = "td")
    private WebElement peak;

    @FindBy(css = "td:nth-of-type(2)")
    private WebElement mountainRange;

    @FindBy(css = "td:nth-of-type(3)")
    private WebElement state;

    @FindBy(css = "td:nth-of-type(4)")
    private WebElement height;


    public RowPage(WebElement rowNumber, WebDriver driver) {
        super(driver);
        DefaultElementLocatorFactory parent = new DefaultElementLocatorFactory(rowNumber);
        PageFactory.initElements(parent, this);
    }

    public String getRank() {
        String rank1 = rank.getText();
        return rank1;
    }

    public String getPeak() {
        String peak1 = peak.getText();
        return peak1;
    }

    public String getMountainRange() {
        String mountainRangeText = mountainRange.getText();
        return mountainRangeText;
    }

    public String getState() {
        String state1 = state.getText();
        return state1;
    }

    public int getHeight() {
        int height1 = Integer.parseInt(height.getText());
        return height1;
    }

}

