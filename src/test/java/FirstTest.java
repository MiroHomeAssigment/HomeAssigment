import Utils.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FirstTest extends BaseTest {
    @Test
    @DisplayName("Some test")
    public void someTest() {
        driver.get("https://ya.ru");
    }
}

