package Utils;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;

public class RandomGenerator {
    @Step("Waiting for the button to be clickable and click")
    static public String generateEmail() {
        String email = "someUser" + RandomStringUtils.randomAlphabetic(5) + "@thisemaildoesntexists.com";
        return email;
    }
}

