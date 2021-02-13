package pageobjects;

import org.openqa.selenium.WebDriver;

public class WomanPage extends BasePage {
    //odwołuje się do klasy BasePage i podanej tam styrony
    public void openPage2() {
        driver.get(BASE_URL2);
    }

    public WomanPage(WebDriver driver) { super(driver); }
}
