package Pages;

import Utils.RandomGenerator;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Utils.WaiterHelper.waitAndClick;
import static Utils.WebDriverLauncher.driverWait;

public class SignUpPage {
    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//*[contains(concat(' ', @data-autotest-id, ' '), ' mr-form-signup-name-1')]")
    private WebElement nameField;

    @FindBy(xpath = ".//*[contains(concat(' ', @data-autotest-id, ' '), ' mr-form-signup-email-1')]")
    private WebElement emailField;

    @FindBy(xpath = ".//*[contains(concat(' ', @data-autotest-id, ' '), ' mr-form-signup-password-1')]")
    private WebElement passwordField;

    @FindBy(xpath = ".//*[contains(concat(' ', @data-autotest-id, ' '), ' mr-form-signup-btn-start-1')]")
    private WebElement getStartedButton;

    @FindBy(xpath = ".//*[@class='mr-checkbox-1__icon']")
    public WebElement iAgreeToTerms;

    @Step("Fill registration data")
    public final SignUpPage fillRegistrationData(String name, String password, String email) {
        waitAndClick(nameField, driverWait, "Sign Up Button, main page");
        nameField.sendKeys(name);
        passwordField.click();
        passwordField.sendKeys(password);
        emailField.click();
        emailField.sendKeys(email);
        return this;
    }

    @Step("Click on Agreement to Terms and Privacy Policy")
    public final SignUpPage agreeToTerms() {
        waitAndClick(iAgreeToTerms, driverWait, "I Agree To Terms button, sign up page");
        return this;
    }

    @Step("Click on Get Started Now button")
    public final SignUpPage clickSignUp() {
        waitAndClick(getStartedButton, driverWait, "Get Started Now button, sign up page");
        return this;
    }
}
