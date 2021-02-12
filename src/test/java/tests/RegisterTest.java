package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
        homePage.openPage();
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
        homePage.openPage();
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
        randomUser.dayOfBirth = "";
        randomUser.monthOfBirth = 13;
        randomUser.yearOfBirth = 1600;
        randomUser.postalCode = "";
        randomUser.state = "";
        randomUser.address1 = "";
        randomUser.address2 = "";
        randomUser.city = "";
        randomUser.phone_mobile = "";

        System.out.println(randomUser);
        registerPage.registerUser(randomUser);

        // asercja sprawdza czy pojawia się komunikat o braku wypełnienia wymagań
        Assertions.assertTrue(registerPage.isAlertDisplayed("There are 8 errors"));
/*        Assertions.assertTrue(registerPage.isAlertDisplayed("passwd is required."));
        Assertions.assertTrue(registerPage.isAlertDisplayed("lastname is required."));
        Assertions.assertTrue(registerPage.isAlertDisplayed("firstname is required."));*/

    }
}
