package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Utils.WaiterHelper.waitAndClick;
import static Utils.WebDriverLauncher.driverWait;

public class MiroEmailConfirmationPage {
    public MiroEmailConfirmationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "signup__title-form")
    public WebElement confirmEmailTitle;

    @FindBy(className = "signup__input-inline-wrap")
    public WebElement confirmEmailInput;

}
