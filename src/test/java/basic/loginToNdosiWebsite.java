package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class loginToNdosiWebsite {

    WebDriver driver;

    @BeforeTest
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.get("https://ndosisimplifiedautomation.vercel.app/");
        driver.manage().window().maximize();
    }

    @Test()
    public void clickLoginTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[3]/button")).click();
    }

    @Test(dependsOnMethods = "clickLoginTest")
    public void enterUsernameTest() {
        driver.findElement(By.id("login-email")).sendKeys("admin@gmail.com");
    }

    @Test(dependsOnMethods = "enterUsernameTest")
    public void enterPasswordTest() {
        driver.findElement(By.id("login-password")).sendKeys("@12345678");
    }

    @Test(dependsOnMethods = "enterPasswordTest")
    public void clickSubmitButtonTest() throws InterruptedException {
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = "clickSubmitButtonTest")
    public void verifyLoginSuccess() {
        String welcomeText = driver.findElement(By.xpath("//*[@id=\"app-main-content\"]/section/div[1]/div[1]/h2/span[2]")).getText();
        Assert.assertEquals(welcomeText, "back,");
    }


    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }


}
