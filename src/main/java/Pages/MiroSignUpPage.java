package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Utils.WaiterHelper.waitAndClick;
import static Utils.WebDriverLauncher.driverWait;

public class MiroSignUpPage {
    public MiroSignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//*[contains(concat(' ', @data-autotest-id, ' '), ' mr-form-signup-name-1')]")
    public WebElement nameField;

    @FindBy(xpath = ".//*[contains(concat(' ', @data-autotest-id, ' '), ' mr-form-signup-email-1')]")
    public WebElement emailField;

    @FindBy(xpath = ".//*[contains(concat(' ', @data-autotest-id, ' '), ' mr-form-signup-password-1')]")
    public WebElement passwordField;

    @FindBy(xpath = ".//*[contains(concat(' ', @data-autotest-id, ' '), ' mr-form-signup-btn-start-1')]")
    public WebElement getStartedButton;

    @FindBy(xpath = ".//*[@class='mr-checkbox-1__icon']")
    public WebElement iAgreeToTerms;

    @Step("Click on Get Started Now button")
    public final void clickSignUp() {
        waitAndClick(getStartedButton, driverWait, "Get Started Now button, sign up page");
    }
}
