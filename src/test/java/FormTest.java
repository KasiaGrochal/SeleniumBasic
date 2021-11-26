
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
                        openWebsite().
                        fillInFirstName("Test").
                        fillInLastName("test2").
                        fillInEmail("email@sii.pl").
                        selectRandomSex().
                        fillInAge("19").
                        selectRandomYearOfExperience().
                        selectAutomationTesterProfession().
                        selectRandomContinent().
                        selectSeleniumCommands().
                        uploadFile(FileHandler.fileToUpload).
                        clickSignIn().
                        successMessageText(), equalTo(formPage.expectedMessageText(formPage.expectedSuccessMessage)));
    }


    @Test
    void validateDownloadFileOption() {
        FormPage formPage = new FormPage(driver);
        assertThat(
                formPage.
                        openWebsite().
                        clickTestFileDownloadButton().
                        verifyIfFileIsDownloadedByFileName(FileHandler.expectedFileName), equalTo(true));
    }

   @Test
    void validateDownloadFileOption2() {
        FormPage formPage = new FormPage(driver);
        int folderSizeBeforeDownload = FileHandler.getCurrentFolderSize(FileHandler.downloadedFilesFolder);
        assertThat(
                formPage.
                        openWebsite().
                        clickTestFileDownloadButton().
                        verifyIfFileIsDownloadedByFolderSize(folderSizeBeforeDownload), equalTo(true));
    }
}