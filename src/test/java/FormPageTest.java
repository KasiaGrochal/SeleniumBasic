import handlers.FakeDataGenerator;
import handlers.FileHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.FormPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Execution(ExecutionMode.CONCURRENT)
public class FormPageTest extends TestBase {
Logger logger = LoggerFactory.getLogger(FormPageTest.class);
    @Test
    @DisplayName("Validate if appropriate success message appears after completing the form")
    @Tag("regression")
    @Tag("formValidation")
    void validateFormSuccessMessage() {
        FormPage formPage = new FormPage(driver);
        FakeDataGenerator faker = new FakeDataGenerator();
        assertThat(
                formPage.
                        openWebsite().
                        fillInFirstName(faker.getFakeFirstName()).
                        fillInLastName(faker.getFakeLastName()).
                        fillInEmail(faker.getFakeEmail()).
                        selectRandomSex().
                        fillInAge(faker.getFakeAdultAge()).
                        selectRandomYearOfExperience().
                        selectAutomationTesterProfession().
                        selectRandomContinent().
                        selectSeleniumSwitchCommand().
                        selectSeleniumWaitCommand().
                        uploadFile(FileHandler.fileToUpload).
                        clickSignIn().
                        displayedSuccessMessageText(), equalTo(FormPage.expectedSuccessMessage));
        logger.info("Test validateFormSuccessMessage completed with success");
    }


   /* @Test
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
    }*/

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
        logger.info("Test validateDownloadFile completed with success");
    }
}