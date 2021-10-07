package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Utils.WebDriverLauncher.driver;
import static Utils.WebDriverLauncher.driverWait;
import static Utils.WaiterHelper.waitAndClick;

public class MiroMainPage {
    public MiroMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public MiroMainPage open() {
        driver.get("https://miro.com");
        return this;
    }

    @FindBy(xpath = ".//a[contains(concat(' ', @data-autotest-id, ' '), ' header-signup-1')]")
    private WebElement signUpButton;

    @FindBy(xpath = ".//button[@id='onetrust-accept-btn-handler']")
    private WebElement acceptAllCookies;

    @Step("Click Accept all cookies if shown")
    public MiroMainPage acceptCookiesIfShown () {
        if (acceptAllCookies.isDisplayed()) {
            waitAndClick(acceptAllCookies, driverWait, "Sign Up Button, main page");
        }
        return this;
    }

    @Step("Click on Sign Up button")
    public final MiroMainPage clickSignUp() {
        waitAndClick(signUpButton, driverWait, "Sign Up Button, main page");
        return this;
    }
}
