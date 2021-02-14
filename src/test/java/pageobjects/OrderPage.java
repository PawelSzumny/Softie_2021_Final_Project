package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends BasePage {


    // przypisanie konkretnych elementów ze strony do nazw zmiennych

    @FindBy(xpath = "//a[@href='http://automationpractice.com/index.php?controller=order&step=1']")
    WebElement proceedToCheckout1;

    @FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
    WebElement proceedToCheckout2;

    @FindBy(xpath = "//button[@class='button btn btn-default standard-checkout button-medium']")
    WebElement proceedToCheckout3;

    @FindBy(id = "uniform-cgv")
    WebElement readTheTermsOfServiceCheckBox;

    @FindBy(xpath = "//a[@href='http://automationpractice.com/index.php?fc=module&module=bankwire&controller=payment']")
    WebElement payByBankWire;

    @FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
    WebElement confirmOrderButton;

    @FindBy(xpath = "//p[@class='cheque-indent']")
    WebElement completeOrder;

    @FindBy(xpath = "//i[@class='icon-trash']")
    WebElement trashProduct;

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    WebElement emptyCart;

    @FindBy(xpath = "//p[@class='fancybox-error']")
    WebElement agreeOfTerms;

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOrderComplet(String expectedAlertText) {
        return completeOrder.getText().contains(expectedAlertText);
    }

    public boolean isCartEmpty(String expectedAlertText) {
        return emptyCart.getText().contains(expectedAlertText);
    }

    public boolean isTermsOfServiceCheckBoxClik(String expectedAlertText) {
        return agreeOfTerms.getText().contains(expectedAlertText);
    }

    //Użycie przycisków
    public void goToPointTwoOfOrderButton() {
        proceedToCheckout1.sendKeys(Keys.ENTER);
    }

    public void goToPointFourOfOrderButton() {
        proceedToCheckout2.sendKeys(Keys.ENTER);
    }

    public void goToPointFiveOfOrderButton() {
        readTheTermsOfServiceCheckBox.click();
        proceedToCheckout3.sendKeys(Keys.ENTER);
    }

    public void goToPaymentOfOrder() {
        payByBankWire.click();
    }

    public void goToEndOfOrderButton() {
        confirmOrderButton.sendKeys(Keys.ENTER);
    }

    public void trashProductFromOrder() {
        trashProduct.click();
        proceedToCheckout1.sendKeys(Keys.ENTER);
    }

    public void goToPointFiveOfOrderButtonWithoutTermsOfServiceCheckBox() {
        proceedToCheckout3.sendKeys(Keys.ENTER);
    }
}
