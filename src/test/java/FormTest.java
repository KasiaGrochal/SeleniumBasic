
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FormTest extends TestBase {

    @Test
    void validateForm(){
        FormPage formPage=new FormPage(driver);
        driver.get("https://seleniumui.moderntester.pl/form.php");

        formPage.
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
                clickSignIn();
        assertThat(formPage.successMessageShouldBeVisible(), equalTo(true));
    }
}


      /*  Fill First name
        Fill Last name
        Fill Email
        Choose a random 'Sex' radiobutton
        Fill age
        Choose a random 'Year of experience' radiobutton
        Choose 'Automation Tester' profession
        Select random option from 'Continents'
        Select "Switch Commands" and "Wait Commands" from 'Selenium Commands'
        Upload some File
        Click 'Sign in' button
        Check that "Form send with success" text has been shown
        Gratis to tego zadania:
        Poszukajcie jak ustawić domyślny folder pobierania w chromedriverze
        Ustawcie wybrany przez was folder
        'Policzcie' przy pomocy javy jaka jest ilość plików w tym folderze
        kliknijcie w formularzu przycisk 'Test File to Download'
        Sprawdźcie czy ilość plików w folderze jest taka jak wcześniej +1
        Dla chętnych: możecie spróbować pobrać listę plików w danym folderze i sprawdzić czy zawiera ona ten plik test-file-to-download.xlsx */