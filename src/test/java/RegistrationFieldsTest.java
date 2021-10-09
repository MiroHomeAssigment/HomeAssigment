import Pages.SignUpPage;
import Utils.RandomGenerator;
import Utils.WaiterHelper;
import Utils.WebDriverLauncher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Utils.WaiterHelper.waitFor;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


public class RegistrationFieldsTest extends WebDriverLauncher {
    final String NAME = "Someusername";
    final String PASSWORD = "NotGreatNotTerriblePasswd123";
    final String EMAIL = RandomGenerator.generateEmail();

    final String EMPTY_NAME = "";
    final String EMPTY_PASSWORD = "";
    final String TOO_SHORT_PASSWORD = "short";

    final String INCORRECT_EMAIL = "@none.com";

    final String INCORRECT_NAME_MESSAGE = "Please enter your name.";
    final String INCORRECT_EMAIL_MESSAGE = "The email you entered is incorrect.";
    final String INCORRECT_PASSWORD_MESSAGE = "Please enter your password.";
    final String TOO_SHORT_PASSWORD_MESSAGE = "Please use 8+ characters for secure password";

    @Test
    @DisplayName("Sing up, invalid data - empty name")
    public void emptyNameErrorTest() {
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage
                .open()
                .acceptCookiesIfShown()
                .fillRegistrationData(EMPTY_NAME, PASSWORD, EMAIL)
                .agreeToTerms()
                .clickGetStarted();

        assertThat(signUpPage.nameErrorMessage.getText(),
                containsString(INCORRECT_NAME_MESSAGE));

    }

    @Test
    @DisplayName("Sing up, invalid data - empty name")
    public void emptyEmail() {
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage
                .open()
                .acceptCookiesIfShown()
                .fillRegistrationData(NAME, PASSWORD, INCORRECT_EMAIL)
                .agreeToTerms()
                .clickGetStarted();

        assertThat(signUpPage.emailErrorMessage.getText(),
                containsString(INCORRECT_EMAIL_MESSAGE));

    }

    @Test
    @DisplayName("Sing up, invalid data - empty password")
    public void emptyEmailErrorTest() {
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage
                .open()
                .acceptCookiesIfShown()
                .fillRegistrationData(NAME, EMPTY_PASSWORD, EMAIL)
                .agreeToTerms()
                .clickGetStarted();

        assertThat(signUpPage.emptyPasswordErrorMessage.getText(),
                containsString(INCORRECT_PASSWORD_MESSAGE));
    }

    @Test
    @DisplayName("Sing up, password field - too short password")
    public void tooShortPasswordTest() {
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage
                .open()
                .acceptCookiesIfShown()
                .fillRegistrationData(NAME, TOO_SHORT_PASSWORD, EMAIL)
                .agreeToTerms()
                .clickGetStarted();

        waitFor(signUpPage.passwordStrengthMessage, driverWait, "Waiting for the message");
        assertThat(signUpPage.passwordStrengthMessage.getText(),
                containsString(TOO_SHORT_PASSWORD_MESSAGE));
    }
}

