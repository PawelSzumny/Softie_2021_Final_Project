package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import utils.RandomUser;

// kożysta z klasu BaseTest
public class LoginTest extends BaseTest {

    // test sprawdzający poprawną logowanie użytkownika
/*    @Test
    void shouldLoginUserWhenUserIsInBase() {
        // otwiera stronę domową za pomocą drivera i przechodzi do przycisku login
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.goToLoginPage();

        //za pomocą klasy LoginPage w polu email tworzy randomowy email
        LoginPage loginPage = new LoginPage(driver);
        RandomUser randomUser = new RandomUser();
        loginPage.goToLoginPage1(randomUser.password);
        loginPage.goToLoginPage2(randomUser.email);*/


    //Test sprawdzający logowanie użytkownika nie będącego w bazie
    @Test
    void shouldDisplayCorrectAlertsWhenUserIsNotInBase() {
        // otwiera stronę domową za pomocą drivera i przechodzi do przycisku login
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.goToLoginPage();

        //za pomocą klasy LoginPage w polu email tworzy randomowy email
        LoginPage loginPage = new LoginPage(driver);
        RandomUser randomUser = new RandomUser();
        //za pomocą klasy LoginPage w polu Password tworzy wpisuje hasło
        loginPage.goToLoginPage1(randomUser.password);
        loginPage.goToLoginPage2(randomUser.email);

        Assertions.assertTrue(loginPage.isAlertDisplayed("Authentication failed."));
    }

    //Test sprawdzający logowanie użytkownika bez podania hasła
    @Test
    void shouldDisplayCorrectAlertsWhenUserNoAddPassword() {
        // otwiera stronę domową za pomocą drivera i przechodzi do przycisku login
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.goToLoginPage();

        //za pomocą klasy LoginPage w polu email tworzy randomowy email
        LoginPage loginPage = new LoginPage(driver);
        RandomUser randomUser = new RandomUser();
        loginPage.goToLoginPage2(randomUser.email);

        Assertions.assertTrue(loginPage.isAlertDisplayed("Password is required."));
    }

    //Test sprawdzający logowanie użytkownika bez podania emailu
    @Test
    void shouldDisplayCorrectAlertsWhenUserNoAddEmail() {
        // otwiera stronę domową za pomocą drivera i przechodzi do przycisku login
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.goToLoginPage();

        //za pomocą klasy LoginPage w polu email tworzy randomowy email
        LoginPage loginPage = new LoginPage(driver);
        RandomUser randomUser = new RandomUser();
        loginPage.goToLoginPage1(randomUser.password);

        Assertions.assertTrue(loginPage.isAlertDisplayed("An email address required."));
    }

    // test sprawdzający poprawną logowanie użytkownika z nieprawidłowym adresem email
    @Test
    void shouldDisplayCorrectAlertsWhenUserAddInvalidEmail() {
        // otwiera stronę domową za pomocą drivera i przechodzi do przycisku login
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.goToLoginPage();

        //za pomocą klasy LoginPage w polu email tworzy randomowy email
        LoginPage loginPage = new LoginPage(driver);
        RandomUser randomUser = new RandomUser();
        loginPage.goToLoginPage1(randomUser.password);
        randomUser.email = "invalid";
        loginPage.goToLoginPage2(randomUser.email);

        Assertions.assertTrue(loginPage.isAlertDisplayed("Invalid email address."));
    }
}


//3 testy negatywne: nie zarejestrowany użytkownik, brak hasła, brak maila.