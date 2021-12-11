package basic;

import handlers.FakeDataGenerator;
import handlers.FileHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Website;
import pages.basic.FormPage;
import pages.basic.MainPage;
import testBase.TestBase;

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

        new Website(driver).
                openWebsite();
        new MainPage(driver).
                navigateToTopBarPage().
                clickOnTopMenuBasicButton().
                clickOnFormButton();
        formPage.
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
                clickSignIn();
        assertThat(formPage.displayedSuccessMessageText(), equalTo(FormPage.expectedSuccessMessage));
        logger.info("Test validateFormSuccessMessage completed with success");
    }


   /* @Test
    @DisplayName("Validate if file was downloaded after clicking Test File Download Button")
    @Tag("regression")
    @Tag("downloadsValidation")
    void validateDownloadFileOption() {
        Website website = new Website(driver);
        website.
                openWebsite().
                navigateToTopBarPage().
                clickOnTopMenuBasicButton().
                clickOnFormButton().
                clickTestFileDownloadButton();
        assertThat(
                FileHandler.doesFileExistInDownloadFolder(FormPage.expectedFileName), equalTo(true));
        FileHandler.deleteFile(FileHandler.downloadedFile);
    }*/

    @Test
    @DisplayName("Validate if file was downloaded after clicking Test File Download Button")
    @Tag("regression")
    @Tag("downloadsValidation")
    void validateDownloadFileOption2() {
        Website website = new Website(driver);
        int folderSizeBeforeDownload = FileHandler.getCurrentFolderSize(FileHandler.downloadedFilesFolder);
        website.
                openWebsite().
                navigateToTopBarPage().
                clickOnTopMenuBasicButton().
                clickOnFormButton().
                clickTestFileDownloadButton();
        assertThat(
                FileHandler.didFolderSizeIncreaseByOne(folderSizeBeforeDownload), equalTo(true));
        FileHandler.deleteFile(FileHandler.downloadedFile);
        logger.info("Test validateDownloadFile completed with success");
    }
}