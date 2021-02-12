package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.RandomUser;

public class RegisterPage extends BasePage {

    // przypisanei konkretnych elementów ze strony do nazw zmiennych
    @FindBy(id = "customer_firstname")
    WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    WebElement customerLastName;

    @FindBy(id = "passwd")
    WebElement passwd;

    @FindBy(id = "days")
    WebElement days;
    Select day = new Select(days);

    @FindBy(id = "months")
    WebElement months;
    Select month = new Select(months);

    @FindBy(id = "years")
    WebElement years;
    Select year = new Select(years);

    @FindBy(css = "[id='address1']")
    WebElement address1;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "id_state")
    WebElement states;
    Select state = new Select(states);

    @FindBy(id = "postcode")
    WebElement postcode;

    @FindBy(id = "phone_mobile")
    WebElement phone_mobile;

    @FindBy(id = "submitAccount")
    WebElement submitButton;

    @FindBy(css = ".alert >ol")
    WebElement failAlert;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAlertDisplayed(String expectedAlertText) {
        return failAlert.getText().contains(expectedAlertText);
    }

    // dane które uzupełniaja pola w formularzu rejestracji
    public void registerUser(RandomUser user) {
        customerFirstName.sendKeys(user.firstName);
        customerLastName.sendKeys(user.lastName);
        passwd.sendKeys(user.password);
        day.selectByValue("" + user.dayOfBirth + "");
        month.selectByValue("" + user.monthOfBirth + "");
        year.selectByValue("" + user.yearOfBirth + "");
        address1.sendKeys(user.address1);
        city.sendKeys(user.city);
        postcode.sendKeys("" + user.postalCode);
        state.selectByVisibleText(user.state);
        phone_mobile.sendKeys(" " + user.phone_mobile);
        submitButton.click();
    }
}