import Pages.EmailConfirmationPage;
import Pages.MainPage;
import Pages.SignUpPage;
import Utils.RandomGenerator;
import Utils.WebDriverLauncher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


public class SignUpTest extends WebDriverLauncher {
    final String NAME = "Someusername";
    final String PASSWORD = "NotGreatNotTerriblePasswd123";
    final String EMAIL = RandomGenerator.generateEmail();

    @Test
    @DisplayName("Sing up, valid data")
    public void signUpTest() {
        MainPage mainPage = new MainPage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);
        EmailConfirmationPage emailConfirmationPage = new EmailConfirmationPage(driver);

        mainPage
                .open()
                .acceptCookiesIfShown()
                .clickSignUp();

        signUpPage
                .fillRegistrationData(NAME, PASSWORD, EMAIL)
                .agreeToTerms()
                .clickGetStarted();

        assertThat(emailConfirmationPage.confirmEmailTitle.getText(),
                containsString("Check your email"));

        assertThat(emailConfirmationPage.confirmEmailInput.isDisplayed(),
                equalTo(true));

    }
}

