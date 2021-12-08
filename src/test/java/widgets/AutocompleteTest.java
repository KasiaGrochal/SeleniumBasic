package widgets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.Website;
import pages.widgets.AutocompletePage;
import testBase.TestBase;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AutocompleteTest extends TestBase {

    Logger logger = LoggerFactory.getLogger(AutocompleteTest.class);

    @Test
    @DisplayName("Validate autocomplete available options ")
    @Tag("regression")
    @Tag("autocomplete")
    void validateSelectedOptionText() {
        Website website = new Website(driver);
        List<String> selectedOption = new ArrayList<>();

assertThat(
                website.
                        openWebsite().
                        navigateToTopBarPage().
                        clickOnTopMenuWidgetsButton().
                        clickOnAutocompleteButton().
                        typeLetters("a").
                        printAllAvailableOptions().
                        selectRandomAvailableOption(selectedOption).getCurrentSearchBoxText(),equalTo(selectedOption.get(0)));
        logger.info("Search box text displayed: {} Test validateSearchBoxText completed successfully", selectedOption.get(0));
    }
}
