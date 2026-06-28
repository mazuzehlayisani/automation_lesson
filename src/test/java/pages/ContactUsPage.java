package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ContactUsPage {

    WebDriver driver;

    By contactUs_xpath = By.xpath("//button[@class='nav-item ']/span[contains(text(),'Contact Us')]");
    By contactMethods_xpath = By.xpath("//div[@class='contact-grid']/article/h3");

    public ContactUsPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickContactUsButton(){
        driver.findElement(contactUs_xpath).click();
    }

    public void contactMethodsText(){
        ArrayList<String> contactMethods = new ArrayList<>();
        List<WebElement> contactsList = driver.findElements(contactMethods_xpath);
        for (WebElement contact: contactsList){
            contactMethods.add(contact.getText());
        }

        System.out.println(contactMethods);
    }

}
