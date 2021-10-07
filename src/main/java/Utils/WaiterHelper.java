package Utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaiterHelper {
    static public void waitAndClick(WebElement button, WebDriverWait wait, String name) {
        try {
            System.out.println("Waiting for and click button " + name);
            wait.until(ExpectedConditions.elementToBeClickable(button));
            button.click();
        } catch (Exception e) {
            System.out.println("Couldn't find button" + name);
            throw e;
        }
    }
}

