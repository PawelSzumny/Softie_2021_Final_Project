package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

    // przypisanie konkretnych elementów ze strony do nazw zmiennych
    @FindBy(className = "logout")
    WebElement singOutButton;

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public void singOutFromPage() {
        singOutButton.sendKeys(Keys.ENTER);
    }
}
