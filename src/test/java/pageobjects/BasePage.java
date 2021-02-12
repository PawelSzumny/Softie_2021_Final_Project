package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
// inlformacje o stronie która będzie otwierana
    protected final static String BASE_URL = "http://automationpractice.com/index.php";
    protected WebDriver driver;

    // przypisanei konkretnych elementów ze strony do nazw zmiennych
    @FindBy(id="search_query_top")
    WebElement searchBox;

    @FindBy(className="logout")
    WebElement signOutButton;

    @FindBy(className="login")
    WebElement goToLoginPageButton;


    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchForProduct(String productName) {
        searchBox.sendKeys(productName);
        searchBox.sendKeys(Keys.ENTER);
    }

// kliknięcie przycisku login
    public void goToLoginPage() {
        goToLoginPageButton.click();
    }
// kliknięcie przycisku wyloguj
    public boolean isUserLoggedIn() {
        return signOutButton.isDisplayed();
    }
}
