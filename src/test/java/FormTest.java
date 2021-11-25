
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FormTest extends TestBase {

    @Test
    @DisplayName("Validate if appropriate success message appears after completing the form")
    void validateFormSuccessMessage() {
        FormPage formPage = new FormPage(driver);
        assertThat(
                formPage.
                        openWebsite("https://seleniumui.moderntester.pl/form.php").
                        fillInFirstName("Test").
                        fillInLastName("test2").
                        fillInEmail("email@sii.pl").
                        selectRandomSex().
                        fillInAge("19").
                        selectRandomYearOfExperience().
                        selectAutomationTesterProfession().
                        selectRandomContinent().
                        selectSeleniumCommands().
                        uploadFile().
                        clickSignIn().
                        successMessageText(), equalTo(formPage.expectedMessageText("Form send with success")));
    }


    @Test
    void validateDownloadFileOption()  {
        FormPage formPage = new FormPage(driver);
    assertThat(
        formPage.
                openWebsite("https://seleniumui.moderntester.pl/form.php").
                clickTestFileDownloadButton().
                checkIfFileIsDownloadedByFileName("test-file-to-download.xlsx"), equalTo(true));
    }

    @Test
    void validateDownloadFileOptionCount()  {
        FormPage formPage = new FormPage(driver);
        assertThat(
                formPage.
                        openWebsite("https://seleniumui.moderntester.pl/form.php").
                        verifyIfFileIsDownloadedByFolderSize(), equalTo(true));
    }
}