import Pages.MiroMainPage;
import Pages.MiroSignUpPage;
import Utils.WebDriverLauncher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SignUpTest extends WebDriverLauncher {
    @Test
    @DisplayName("Sing up, valid data")
    public void signUpTest() {
        driver.get("https://miro.com");
        MiroMainPage miroMainPage = new MiroMainPage(driver);
        MiroSignUpPage miroSignUpPage = new MiroSignUpPage(driver);

        miroMainPage
                .open()
                .acceptCookiesIfShown()
                .clickSignUp();

        miroSignUpPage
                .fillRegistrationData()
                .agreeToTerms()
                .clickSignUp();

    }
}

