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

    public String getRankPeakMountainRange(){
        return getRank()+" - "+ getPeak() + " " +getMountainRange();
    }

    public String getRank() {
        return rank.getText();
    }

    public String getPeak() {
        return peak.getText();
    }

    public String getMountainRange() {
        return mountainRange.getText();
    }

    public String getState() {
      return state.getText();
    }

    public int getHeight() {
        return Integer.parseInt(height.getText());
    }

}

