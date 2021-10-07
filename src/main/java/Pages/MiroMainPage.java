package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Utils.WebDriverLauncher.driverWait;
import static Utils.WaiterHelper.waitAndClick;

public class MiroMainPage {
    public MiroMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//a[contains(concat(' ', @data-autotest-id, ' '), ' header-signup-1')]")
    private WebElement signUpButton;

    @FindBy(xpath = ".//button[@id='onetrust-accept-btn-handler']")
    public WebElement acceptAllCookies;

    By acceptAllCookiesLocator = By.xpath(".//button[@id='onetrust-accept-btn-handler']");

    @Step("Click on Sign Up button")
    public final void clickSignUp() {
        waitAndClick(signUpButton, driverWait, "Sign Up Button, main page");
    }
}
