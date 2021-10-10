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

    final String CHECK_YOUR_EMAIL_MESSAGE = "Check your email";

    @Test
    @DisplayName("Id-1. Sign up, valid data - successful registration")
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
                containsString(CHECK_YOUR_EMAIL_MESSAGE));

        assertThat(emailConfirmationPage.confirmEmailInput.isDisplayed(),
                equalTo(true));

    }
}

