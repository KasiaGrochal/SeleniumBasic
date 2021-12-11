package basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.Website;
import pages.basic.WindowsTabsPage;
import pages.basic.tablePage.TablePage;
import testBase.TestBase;


public class WindowsTabsTest extends TestBase {

    @Test
    @DisplayName("Switch windows and print results as filtered")
    @Tag("regression")
    @Tag("switch")
    void switchWindowTest() {
        Website website = new Website(driver);
        WindowsTabsPage windowsTabsPage = new WindowsTabsPage(driver);
        TablePage tablePage = new TablePage(driver);

        website.
                openWebsite().
                navigateToTopBarPage().
                clickOnTopMenuBasicButton().
                clickOnWindowsTabsButton().
                clickOnNewBrowserWindowButton().
                switchToNewBrowserWindow().
                printFilteredList(tablePage.filterByHeightAndState());
        windowsTabsPage.
                closeCurrentWindow();
        windowsTabsPage.
                switchToParentWindow().
                clickOnNewMessageWindowButton().
                switchToMessageWindow().
                getText().
                closeCurrentWindow();
        windowsTabsPage.
                switchToParentWindow().
                clickOnNewBrowserTabButton().
                switchToNewBrowserWindow().
                printFilteredList(tablePage.filterByHeightAndState());
        windowsTabsPage.
                closeCurrentWindow();


    }
}
