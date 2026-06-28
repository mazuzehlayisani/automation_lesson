package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LearnPage {

    WebDriver driver;

    By LearnMenuItem = By.xpath("//span[contains(text(),'Learn')]");

    public LearnPage(WebDriver driver) {
        this.driver = driver;
    }

    public void LearnMenuItem() {
        driver.findElement(LearnMenuItem).click();
    }


}
