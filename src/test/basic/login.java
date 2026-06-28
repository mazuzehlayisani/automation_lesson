import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class login {
    WebDriver driver;

   @Test
    public void loginToNdosiWebsite() throws InterruptedException {
       driver = new SafariDriver();
       driver.get("https://ndosisimplifiedautomation.vercel.app/#overview");
       driver.manage().window().maximize();
       driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[3]")).click();
       driver.findElement(By.id("login-email")).sendKeys("mazuze.hlayisani@gmail.com");
       driver.findElement(By.id("login-password")).sendKeys("@12345678");
       Thread.sleep(2000);
       driver.findElement(By.id("login-submit")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//*[@id=\"app-main-content\"]/section/div[1]/div[1]/h2/span[1]")).isDisplayed();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/button/span[2]")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/div/button[2]/span[2]")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//*[@id=\"tab-btn-password\"]")).click();
       driver.findElement(By.xpath("//*[@id=\"basic-form-requirements\"]")).click();
       //Enter the required information
       driver.findElement(By.id("name")).sendKeys("Joe Doe");
       driver.findElement(By.id("email")).sendKeys("john@test.com");
       driver.findElement(By.id("age")).sendKeys("25");
       Thread.sleep(2000);
      //driver.findElement(By.id("gender")).sendKeys("Male");
       // Open the dropdown
       driver.findElement(By.id("gender")).click();
       driver.findElement(By.xpath("//*[text()='Male']")).click();
       Thread.sleep(5000);
       driver.findElement(By.id("country")).click();
       driver.findElement(By.xpath("//*[text()='South Africa']")).click();
       driver.findElement(By.id("experience")).click();
       driver.findElement(By.xpath("//*[text()='Intermediate (2-5 years)']")).click();
       driver.findElement(By.id("skill-java")).click();
       Thread.sleep(2000);
       driver.findElement(By.id("skill-selenium")).click();
       driver.findElement(By.id("comments")).sendKeys("Test automation practice");
       driver.findElement(By.id("newsletter")).click();
       driver.findElement(By.id("terms")).click();
       driver.findElement(By.id("validate-btn")).click();
       driver.findElement(By.id("submit-btn")).click();
       Thread.sleep(5000);
       ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
       driver.findElement(By.id("submissions-toggle-btn")).click();
       Thread.sleep(5000);
       driver.findElement(By.id("view-submission-0")).click();
       Thread.sleep(5000);

   }

    @AfterTest
    public void closeBrowser(){
       driver.quit();
    }

}
