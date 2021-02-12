package pageobjects;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
//odwołuje się do klasy BasePage i podanej tam styrony
    public void openPage(){
        driver.get(BASE_URL);
    }

    public HomePage(WebDriver driver){
        super(driver);
    }

}
