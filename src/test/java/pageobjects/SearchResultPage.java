package pageobjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {

    // przypisanei konkretnych elementów ze strony do nazw zmiennych
    @FindBy(css = ".product_list .product-container")
    List<WebElement> products;

    public SearchResultPage(WebDriver driver){
        super(driver);
    }

    public int getNumberOfFoundedProducts() {
        return products.size();
    }




}
