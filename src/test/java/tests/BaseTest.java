package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

class BaseTest {

    protected static WebDriverWait wait;
    protected static WebDriver driver;
    protected final static String BASE_URL = "http://automationpractice.com/index.php";

    @BeforeAll
    protected static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //wait bezwarunkowy (implicit wait)
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //wait warunkowy (explicit wait)
        wait = new WebDriverWait(driver, 5);
    }

    @AfterAll
    protected static void tearDown() throws InterruptedException {
        // tylko tymczasowo
        Thread.sleep(3000);
        driver.quit();
    }

    @BeforeEach
    protected void clearCookies() {
        driver.manage().deleteAllCookies();
    }

}
