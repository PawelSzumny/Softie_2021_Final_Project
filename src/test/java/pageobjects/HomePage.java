package pageobjects;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    //odwołuje się do klasy BasePage i podanej tam styrony
    public void openPage1(){
        driver.get(BASE_URL1);
    }

    public HomePage(WebDriver driver){
        super(driver);
    }

}
