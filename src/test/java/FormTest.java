
import handlers.FileHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.FormPage;

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
                        fillInFirstName().
                        fillInLastName().
                        fillInEmail().
                        selectRandomSex().
                        fillInAge().
                        selectRandomYearOfExperience().
                        selectAutomationTesterProfession().
                        selectRandomContinent().
                        selectSeleniumCommands().
                        uploadFile(FileHandler.fileToUpload).
                        clickSignIn().
                        successMessageText(), equalTo(formPage.expectedMessageText(FormPage.expectedSuccessMessage)));
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