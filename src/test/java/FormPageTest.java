import handlers.FakeDataGenerator;
import handlers.FileHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.FormPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Execution(ExecutionMode.CONCURRENT)
public class FormPageTest extends TestBase {

    @Test
    @DisplayName("Validate if appropriate success message appears after completing the form")
    @Tag("regression")
    @Tag("formValidation")
    void validateFormSuccessMessage() {
        FormPage formPage = new FormPage(driver);
        assertThat(
                formPage.
                        openWebsite().
                        fillInFirstName(FakeDataGenerator.getFakeFirstName()).
                        fillInLastName(FakeDataGenerator.getFakeLastName()).
                        fillInEmail(FakeDataGenerator.getFakeEmail()).
                        selectRandomSex().
                        fillInAge(FakeDataGenerator.getFakeAdultAge()).
                        selectRandomYearOfExperience().
                        selectAutomationTesterProfession().
                        selectRandomContinent().
                        selectSeleniumSwitchCommand().
                        selectSeleniumWaitCommand().
                        uploadFile(FileHandler.fileToUpload).
                        clickSignIn().
                        displayedSuccessMessageText(), equalTo(FormPage.expectedSuccessMessage));
    }


    @Test
    @DisplayName("Validate if file was downloaded after clicking Test File Download Button")
    @Tag("regression")
    @Tag("downloadsValidation")
    void validateDownloadFileOption() {
        FormPage formPage = new FormPage(driver);
        formPage.
                openWebsite().
                clickTestFileDownloadButton();
        assertThat(
                FileHandler.doesFileExistInDownloadFolder(formPage.expectedFileName), equalTo(true));
        FileHandler.deleteFile(FileHandler.downloadedFile);
    }

    @Test
    @DisplayName("Validate if file was downloaded after clicking Test File Download Button")
    @Tag("regression")
    @Tag("downloadsValidation")
    void validateDownloadFileOption2() {
        FormPage formPage = new FormPage(driver);
        int folderSizeBeforeDownload = FileHandler.getCurrentFolderSize(FileHandler.downloadedFilesFolder);
        formPage.
                openWebsite().
                clickTestFileDownloadButton();
        assertThat(
                FileHandler.didFolderSizeIncreaseByOne(folderSizeBeforeDownload), equalTo(true));
        FileHandler.deleteFile(FileHandler.downloadedFile);
    }
}