package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.RegisterPage;
import utils.RandomUser;

// kożysta z klasu BaseTest
public class RegisterTest extends BaseTest {

    // test sprawdzający poprawną rejestrację użytkownika
    @Test
    void shouldRegisterUserWhenMandatoryFieldsAreFilled() {
        // otwiera stronę domową za pomocą drivera i przechodzi do przycisku login
        HomePage homePage = new HomePage(driver);
        homePage.openPage1();
        homePage.goToLoginPage();

        //za pomocą klasy LoginPage w polu email tworzy randomowy email
        LoginPage loginPage = new LoginPage(driver);
        RandomUser randomUser = new RandomUser();
        loginPage.goToRegisterPage(randomUser.email);

        // za pomocą klasy RegisterPage wprowadza dane które są umieszczane w polach do rejestracji za pomocą metody registerUser
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerUser(randomUser);

        // asercja czyli sprawdzenei poprawności wykonanych działąń - właściwy test
        Assertions.assertTrue(homePage.isUserLoggedIn());


    }

    // test sprawdza niepoprawne logowanie poprzez nie wprowadzenie wymaganych informacji
    @Test
    void shouldDisplayCorrectAlertsWhenMandatoryDataIsMissing() {
        // otwiera stronę domową za pomocą drivera i przechodzi do przycisku login
        HomePage homePage = new HomePage(driver);
        homePage.openPage1();
        homePage.goToLoginPage();

        //za pomocą klasy LoginPage w polu email tworzy randomowy email
        LoginPage loginPage = new LoginPage(driver);
        RandomUser randomUser = new RandomUser();
        loginPage.goToRegisterPage(randomUser.email);
         // wprowadza puste pola
        RegisterPage registerPage = new RegisterPage(driver);

        randomUser.lastName = "";
        randomUser.firstName = "";
        randomUser.password = "";
        randomUser.address1 = "";
        randomUser.address2 = "";
        randomUser.city = "";
        randomUser.phone_mobile = "";

        registerPage.registerUser(randomUser);
        System.out.println(randomUser);

        // asercja sprawdza czy pojawia się komunikat o braku wypełnienia wymagań
        Assertions.assertTrue(registerPage.isAlertDisplayed("lastname is required."));
        Assertions.assertTrue(registerPage.isAlertDisplayed("firstname is required."));
        Assertions.assertTrue(registerPage.isAlertDisplayed("passwd is required."));
        Assertions.assertTrue(registerPage.isAlertDisplayed("address1 is required."));
        Assertions.assertTrue(registerPage.isAlertDisplayed("city is required."));

    }
}

