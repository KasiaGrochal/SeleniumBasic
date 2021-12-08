package basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.Website;
import pages.basic.WindowsTabsPage;
import testBase.TestBase;


public class WindowsTabsTest extends TestBase {

    @Test
    @DisplayName("Switch windows and print results as filtered")
    @Tag("regression")
    @Tag("switch")
    void switchWindowTest() {
        Website website = new Website(driver);
        WindowsTabsPage windowsTabsPage = new WindowsTabsPage(driver);

        website.
                openWebsite().
                navigateToTopBarPage().
                clickOnTopMenuBasicButton().
                clickOnWindowsTabsButton().
                clickOnNewBrowserWindowButton().
                switchToNewBrowserWindow().
                filterTableByStateAndHeight().
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
                filterTableByStateAndHeight().
                closeCurrentWindow();


    }
}
