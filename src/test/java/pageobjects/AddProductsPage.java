package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AddProductsPage extends BasePage {

    // przypisanie konkretnych elementów ze strony do nazw zmiennych
    //NA RAZIE NIE PRZYDATNE
    @FindBy(xpath = "//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line first-item-of-tablet-line first-item-of-mobile-line']")
    WebElement displayAddToCartForProductOne;

    @FindBy(xpath = "//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-item-of-tablet-line']")
    WebElement displayAddToCartForProductTwo;

    @FindBy(xpath = "//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-in-line first-item-of-tablet-line last-item-of-mobile-line']")
    WebElement displayAddToCartForProductThree;

    @FindBy(xpath = "//a[@href='http://automationpractice.com/index.php?controller=cart&add=1&id_product=1&token=e817bb0705dd58da8db074c69f729fd8']")
    WebElement addProductOneToCart;

    @FindBy(xpath = "//a[@href='http://automationpractice.com/index.php?controller=cart&add=1&id_product=2&token=e817bb0705dd58da8db074c69f729fd8']")
    WebElement addProductTwoToCart;

    @FindBy(xpath = "//a[@href='http://automationpractice.com/index.php?controller=cart&add=1&id_product=3&token=e817bb0705dd58da8db074c69f729fd8']")
    WebElement addProductThreeToCart;

    @FindBy(id = "total_product")
    WebElement totalProductPrice;

    public AddProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAlertDisplayed(String expectedAlertText) {
        return totalProductPrice.getText().contains(expectedAlertText);
    }

    //Użycie przycisków
    public void AddProductOne() {
        WebElement visibleElement = displayAddToCartForProductOne;
        WebElement hiddenElement = addProductOneToCart;
        Actions a = new Actions(driver);
        a.moveToElement(visibleElement).pause(1000).click(hiddenElement).click().build().perform();
        Wait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='continue btn btn-default button exclusive-medium']")));
        driver.findElement(By.xpath("//span[@class='continue btn btn-default button exclusive-medium']")).click();
        Wait wait1 = new WebDriverWait(driver, 5000);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-item-of-tablet-line']")));
    }

    public void AddProductTwo() {
        WebElement visibleElement = displayAddToCartForProductTwo;
        WebElement hiddenElement = addProductTwoToCart;
        Actions a = new Actions(driver);
        a.moveToElement(visibleElement).pause(1000).click(hiddenElement).click().build().perform();
        Wait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='continue btn btn-default button exclusive-medium']")));
        driver.findElement(By.xpath("//span[@class='continue btn btn-default button exclusive-medium']")).click();
        Wait wait1 = new WebDriverWait(driver, 5000);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-in-line first-item-of-tablet-line last-item-of-mobile-line']")));
    }

    public void AddProductThree() {
        WebElement visibleElement = displayAddToCartForProductThree;
        WebElement hiddenElement = addProductThreeToCart;
        Actions a = new Actions(driver);
        a.moveToElement(visibleElement).pause(1000).click(hiddenElement).click().build().perform();
        Wait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='continue btn btn-default button exclusive-medium']")));
        driver.findElement(By.xpath("//a[@class='btn btn-default button button-medium']")).click();
        Wait wait1 = new WebDriverWait(driver, 5000);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']")));
    }
}
