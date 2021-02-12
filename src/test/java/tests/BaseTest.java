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

    // metoda wywoływana przed wszystkimi testami
    @BeforeAll
    protected static void setUp() {
        // otwiera przeglądarkę chrom
        driver = new ChromeDriver();
        //wyświetla przeglądarke w maksymalnych dostępnych rozmiarach
        driver.manage().window().maximize();
        //wait bezwarunkowy (implicit wait)
        //podaje czas jaki program ma odczekać przed uruchomieniem kolejnego zadania
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //wait warunkowy (explicit wait)
        wait = new WebDriverWait(driver, 5);
    }

    // metoda wywoływana po wszystkich testach
    @AfterAll
    protected static void tearDown() throws InterruptedException {
        // tylko tymczasowo
        Thread.sleep(3000);
        // zamyka okno przeglądarki
        /*driver.quit();*/
    }

    // metoda wykonywana przed każdym testem
    @BeforeEach
    protected void clearCookies() {
        driver.manage().deleteAllCookies();
    }

}
