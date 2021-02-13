package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import pageobjects.AddProductsPage;
import pageobjects.LoginPage;
import pageobjects.WomanPage;
import utils.RandomUser;

public class AddProductsTest extends BaseTest {

    //Test dodający 3 produkty do koszyka
    @Test
    void shouldAddThreeProductsToCart() {
        // otwiera stronę domową za pomocą drivera i przechodzi do przycisku login
        WomanPage womanPage = new WomanPage(driver);
        womanPage.openPage2();

        //Dodaje pierwszy produkt do koszyka
        AddProductsPage addProductsPage = new AddProductsPage(driver);
        addProductsPage.AddProductOne();
        addProductsPage.AddProductTwo();
        addProductsPage.AddProductThree();

        Assertions.assertTrue(addProductsPage.isAlertDisplayed("$69.51"));

        /*        Assertions.assertEquals("Sign out",driver.findElement(By.className("logout")).getText());*/
    }
}
