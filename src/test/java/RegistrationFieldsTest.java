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

    final String INCORRECT_EMAIL = "@none.com";
    final String ALREADY_REGISTERED_EMAIL = "s.moryahin@gmail.com";

    final String INCORRECT_NAME_MESSAGE = "Please enter your name.";
    final String INCORRECT_EMAIL_MESSAGE = "The email you entered is incorrect.";
    final String ALREADY_REGISTERED_EMAIL_MESSAGE = "Sorry, this email is already registered";
    final String INCORRECT_PASSWORD_MESSAGE = "Please enter your password.";
    final String TERMS_NOT_ACCEPTED_MESSAGE = "Please agree with the Terms to sign up.";


    @Test
    @DisplayName("Id-2. Sign up, invalid data - empty name")
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
    @DisplayName("Id-3. Sign up, invalid data - incorrect email")
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
    @DisplayName("Id-4. Sign up, invalid data - email already in use")
    public void alreadyRegisteredEmail() {
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage
                .open()
                .acceptCookiesIfShown()
                .fillRegistrationData(NAME, PASSWORD, ALREADY_REGISTERED_EMAIL)
                .agreeToTerms()
                .clickGetStarted();

        waitFor(signUpPage.emailErrorMessage, driverWait,
                "Waiting for the message that email is already in use");
        assertThat(signUpPage.emailErrorMessage.getText(),
                containsString(ALREADY_REGISTERED_EMAIL_MESSAGE));

    }

    @Test
    @DisplayName("Id-5. Sign up, invalid data - empty password")
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
    @DisplayName("Id-6. Sign up, invalid data - terms not accepted")
    public void termsNotAccepter() {
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage
                .open()
                .acceptCookiesIfShown()
                .fillRegistrationData(NAME, EMPTY_PASSWORD, EMAIL)
                .clickGetStarted();

        assertThat(signUpPage.termNotAcceptedMessage.getText(),
                containsString(TERMS_NOT_ACCEPTED_MESSAGE));
    }
}

