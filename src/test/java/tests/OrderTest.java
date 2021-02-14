package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.*;
import utils.RandomUser;

public class OrderTest extends BaseTest {

    // test wykonujący zamówienie
    @Test
    void shouldMekeOrder() {

        //za pomocą klasy WomanPage przechodzi na stronę Woman
        WomanPage womanPage = new WomanPage(driver);
        womanPage.openPage2();

        //dodaje jeden produk asercja sprawdza cenę
        AddProductsPage addProductsPage = new AddProductsPage(driver);
        addProductsPage.AddProductThree();

        // używa przycisku proceedToCheckout do przejscia do kolejnego etapu
        OrderPage orderPage = new OrderPage(driver);
        orderPage.goToPointTwoOfOrderButton();

        //za pomocą klasy LoginPage w polu email wykorzystuje nadany email
        LoginPage loginPage = new LoginPage(driver);
        RandomUser randomUser = new RandomUser();
        loginPage.goToLoginPage1(randomUser.password);
        randomUser.email = "MyrnaWitting87711@gmail.com";
        loginPage.goToLoginPage2(randomUser.email);

        orderPage.goToPointFourOfOrderButton();

        orderPage.goToPointFiveOfOrderButton();

        orderPage.goToPaymentOfOrder();

        orderPage.goToEndOfOrderButton();

        Assertions.assertTrue(orderPage.isOrderComplet("Your order on My Store is complete."));
    }

    // test wykonujący zamówienie z pustym koszykiem który zwraca alert
    @Test
    void shouldDisplayCorrectAlertsWhenCartIsEmpty() {

        //za pomocą klasy WomanPage przechodzi na stronę Woman
        WomanPage womanPage = new WomanPage(driver);
        womanPage.openPage2();

        //dodaje jeden produk asercja sprawdza cenę
        AddProductsPage addProductsPage = new AddProductsPage(driver);
        addProductsPage.AddProductThree();

        // używa przycisku proceedToCheckout do przejscia do kolejnego etapu
        OrderPage orderPage = new OrderPage(driver);
        orderPage.trashProductFromOrder();

        Assertions.assertTrue(orderPage.isCartEmpty("Your shopping cart is empty."));
    }

//test wykonujący zamówienie z bez potwierdzenia pola o warunkach korzystania zwraca alert
    @Test
    void shouldDisplayCorrectAlertsWhenTermsOfServiceAreNotClick() {

        //za pomocą klasy WomanPage przechodzi na stronę Woman
        WomanPage womanPage = new WomanPage(driver);
        womanPage.openPage2();

        //dodaje jeden produk asercja sprawdza cenę
        AddProductsPage addProductsPage = new AddProductsPage(driver);
        addProductsPage.AddProductThree();

        // używa przycisku proceedToCheckout do przejscia do kolejnego etapu
        OrderPage orderPage = new OrderPage(driver);
        orderPage.goToPointTwoOfOrderButton();

        //za pomocą klasy LoginPage w polu email wykorzystuje nadany email
        LoginPage loginPage = new LoginPage(driver);
        RandomUser randomUser = new RandomUser();
        loginPage.goToLoginPage1(randomUser.password);
        randomUser.email = "MyrnaWitting87711@gmail.com";
        loginPage.goToLoginPage2(randomUser.email);

        orderPage.goToPointFourOfOrderButton();

        orderPage.goToPointFiveOfOrderButtonWithoutTermsOfServiceCheckBox();

        Assertions.assertTrue(orderPage.isTermsOfServiceCheckBoxClik("You must agree to the terms of service before continuing."));
    }
}