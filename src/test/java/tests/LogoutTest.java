package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.LogoutPage;
import utils.RandomUser;


// kożysta z klasu BaseTest
public class LogoutTest extends BaseTest {

    //sprawdza wylogowanie ze strony
    @Test
    void shouldLogoutUserFromSite() {
        // otwiera stronę domową za pomocą drivera i przechodzi do przycisku login
        HomePage homePage = new HomePage(driver);
        homePage.openPage1();
        homePage.goToLoginPage();

        //za pomocą klasy LoginPage w polu email wykorzystuje nadany email do zalogowania a potem wylogowywuje użytkownika
        LoginPage loginPage = new LoginPage(driver);
        RandomUser randomUser = new RandomUser();
        loginPage.goToLoginPage1(randomUser.password);
        randomUser.email = "MyrnaWitting87711@gmail.com";
        loginPage.goToLoginPage2(randomUser.email);

        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.singOutFromPage();

        Assertions.assertEquals("Sign in", driver.findElement(By.id("SubmitLogin")).getText());
    }
}
