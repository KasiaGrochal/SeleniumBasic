package widgets;


import handlers.FakeDataGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Website;
import pages.widgets.ModalDialogPage;
import testBase.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ModalDialogTest extends TestBase {

    Logger logger = LoggerFactory.getLogger(ModalDialogTest.class);

    @Test
    @DisplayName("Validate adding user")
    @Tag("regression")
    @Tag("modalDialog")
    void validateCreateNewUserWidget() {
        Website website = new Website(driver);
        FakeDataGenerator faker = new FakeDataGenerator();

        assertThat(
                website.
                        openWebsite().
                        navigateToTopBarPage().
                        clickOnTopMenuWidgetsButton().
                        clickOnModalDialogButton().
                        clickOnCreateNewUserButton().
                        fillInFullName(faker.getFakeFullNameLimit(3, 16)).
                        fillInEmail(faker.getFakeEmail()).
                        fillInPassword(faker.getFakePasswordLimit(3, 16)).
                        clickOnCreateAnAccountButton().
                        doesLastAddedUserExistOnUserList(),equalTo(true));

        logger.info("New user added to the list correctly. Test validateCreateNewUserWidget() Completed successfully");
    }
}
