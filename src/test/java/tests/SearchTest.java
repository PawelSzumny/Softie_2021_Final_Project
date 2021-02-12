package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pageobjects.HomePage;
import pageobjects.SearchResultPage;

import java.util.List;

public class SearchTest extends BaseTest {

    // test sprawdzajacy wyszukiwanie produktu
    @Test
    public void shouldReturnProductListWhenSearchForExistingProducts() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        // w polu wyszukiwania wpisuje słowo "dress"
        homePage.searchForProduct("dress");
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        // asercja sprawdza występowanie produktu "dress" - na streonie pojawia się 7 razy
        Assertions.assertEquals(7, searchResultPage.getNumberOfFoundedProducts());
    }

    //negatywny test który ma sprawdzić poprawność komunikatu
    @Test
    public void shouldReturnEmptyProductListWhenSearchForNonExistingProducts() {
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        // w polu wyszukiwania wpisuje słowo "drill"
        homePage.searchForProduct("drill");
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        // asercja sprawdza występowanie produktu "drill" - na streonie nie występuje
        Assertions.assertEquals(0, searchResultPage.getNumberOfFoundedProducts());
    }

}
