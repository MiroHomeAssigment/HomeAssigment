package Utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    public static ChromeDriver driver;
    public static WebDriverWait wait;


    @BeforeAll
    static void setupTest() {
        WebDriverManager.chromedriver().browserVersion("94.0.4606.61").setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 4);
        driver.manage().window().maximize();
    }

    @AfterAll
    static void stop() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}

