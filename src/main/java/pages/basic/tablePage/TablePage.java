package pages.basic.tablePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class TablePage extends BasePage {

    public TablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "tbody tr")
    private List<WebElement> allRows;

    private List<RowPage> getList(){
        List<RowPage> listOfRowPage = new ArrayList<>();
        for (WebElement element: allRows){
            listOfRowPage.add(new RowPage(element,driver));
        }
        return listOfRowPage;
    }

    public List<String> filterByHeightAndState(){
        List<String> filteredList = new ArrayList<>();
        for (RowPage rowPage: getList()){
            if((rowPage.getHeight()>4000)&&(rowPage.getState().equals("Switzerland"))){
                filteredList.add(rowPage.getRankPeakMountainRange());
            }
        }
        return filteredList;
    }

    public void printFilteredList(List <String> filteredList){
        for (String row : filteredList){
            System.out.println(row);
        }
    }

}





