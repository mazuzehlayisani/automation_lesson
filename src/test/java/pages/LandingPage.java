package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    WebDriver driver;

    By welcomeText_xpath = By.xpath("//h2");

    public LandingPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isWelcomeTextDisplayed(){
        return driver.findElement(welcomeText_xpath).isDisplayed();
    }

}
