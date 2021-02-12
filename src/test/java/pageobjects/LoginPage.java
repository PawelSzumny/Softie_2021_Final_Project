package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    // przypisanie konkretnych elementów ze strony do nazw zmiennych
    @FindBy(id = "email_create")
    WebElement emailCreateNewUserBox;

    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement emailLoginUserBox;

    @FindBy(css = "#passwd")
    WebElement passwdLoginUserBox;

    @FindBy(css = "#SubmitLogin")
    WebElement submitLoginButton;

    @FindBy(css = ".alert >ol")
    WebElement failAlert;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAlertDisplayed(String expectedAlertText) {
        return failAlert.getText().contains(expectedAlertText);
    }

    public void goToRegisterPage(String email) {
        emailCreateNewUserBox.sendKeys(email);
        emailCreateNewUserBox.sendKeys(Keys.ENTER);
    }

    public void goToLoginPage1(String password) {
        passwdLoginUserBox.sendKeys(password);
/*        if (emailLoginUserBox == null){
            submitLoginButton.sendKeys(Keys.ENTER); // do dopracowania
        }*/
    }

    public void goToLoginPage2(String email) {
        emailLoginUserBox.sendKeys(email);
/*        passwdLoginUserBox.sendKeys(password);*/ //do usunięcia lub połączenia email z password
        submitLoginButton.sendKeys(Keys.ENTER);
    }
}