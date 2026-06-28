package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By loginMainButton_xpath = By.xpath("//div[@class='nav-user-section']");
    By username_id = By.id("login-email");
    By loginButton_id = By.id("login-submit");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickLoginMainButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginMainButton_xpath));
        driver.findElement(loginMainButton_xpath).click();

        // wait for login form to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(username_id));
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username_id));
        driver.findElement(username_id).sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement usernameField = driver.findElement(username_id);

        WebElement passwordField = driver.findElement(
                with(By.tagName("input")).below(usernameField)
        );

        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton_id));
        driver.findElement(loginButton_id).click();
    }
}