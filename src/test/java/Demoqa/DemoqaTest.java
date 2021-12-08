package Demoqa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.DemoqaPage;
import testBase.TestBase;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DemoqaTest extends TestBase {

    Logger logger = LoggerFactory.getLogger(DemoqaTest.class);

    @RepeatedTest(10)
    @DisplayName("Validate subject box in students form")
    @Tag("regression")
    @Tag("demoqa")
    void shouldFillDemoQaForm() {
        DemoqaPage demoqaPage = new DemoqaPage(driver);
        List<String> expectedList = new ArrayList<>();
        String subject = "Maths";
        assertThat(
                demoqaPage.
                        openWebsite().
                        closeAd().
                        typeLettersToSubjectBox("Ma").
                        selectElementFromSubjects(subject, expectedList).
                        getSubjectSelectedElementsList(), equalTo(expectedList));
        logger.info("Subject displayed in the subject box is the same as previously chosen: {}", expectedList);
        assertThat(
                demoqaPage.
                        typeLettersToSubjectBox("c").
                        selectRandomElementFromSubjects(expectedList).
                        getSubjectSelectedElementsList(), equalTo(expectedList));
        logger.info("Subject displayed in the subject box is the same as previously chosen: {}", expectedList);
        assertThat(
                demoqaPage.
                        typeLettersToSubjectBox("a").
                        selectRandomElementFromSubjects(expectedList).
                        getSubjectSelectedElementsList(), equalTo(expectedList));
        logger.info("Subject displayed in the subject box is the same as previously chosen: {}", expectedList);

        assertThat(
                demoqaPage.
                        clickCrossOnLastAddedSubject(expectedList).getSubjectSelectedElementsList(), equalTo(expectedList));
        logger.info("Subject displayed in the subject box is the same as previously chosen: {}", expectedList);

        assertThat(
                demoqaPage.clickOnSubjectBoxCross(expectedList).getSubjectSelectedElementsList(), equalTo(expectedList));
        logger.info("Subject displayed in the subject box is the same as previously chosen: {}", expectedList);


    }

}
