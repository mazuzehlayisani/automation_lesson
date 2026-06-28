package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LearningMaterialsPage;
import utils.Base;

public class NdosiTests extends Base {

    @Test(priority = 1)
    public void contactUsTest() {
        contactUsPage.clickContactUsButton();
        contactUsPage.contactMethodsText();
    }


    @Test(priority = 2)
    public void loginPageTest() {
        loginPage.clickLoginMainButton();
        loginPage.enterUsername("mazuze.hlayisani@gmail.com");
        loginPage.enterPassword("@12345678");
        loginPage.clickLoginButton();

    }

    @Test(priority = 3)
    public void landingPageTest() {
        Assert.assertTrue(landingPage.isWelcomeTextDisplayed());

    }

    //Homework Due 03 July 2026
    @Test(priority = 4)
   public void LearnMenuTest() throws InterruptedException {
        learnPage.LearnMenuItem();
        Thread.sleep(2000);

    }
    @Test(priority = 5)
    public void learningMaterialsTest() throws InterruptedException {
        learningMaterialsPage.LearningMaterialsItem();
        Thread.sleep(5000);
    }

    @Test(priority = 6)
    public void webAutomationAdvanceOption() throws InterruptedException {
        learningMaterialsPage.WebAutomationAdvanceOption();
        Thread.sleep(5000);
    }
    @Test(priority = 7)
    public void deviceTypeTests(){
        learningMaterialsPage.DeviceType();
        learningMaterialsPage.DeviceSelection();
        learningMaterialsPage.VerifyDeviceType();
    }
    @Test(priority = 8)
    public void brandTests(){
        learningMaterialsPage.Brand();
        learningMaterialsPage.BrandSelection();
        learningMaterialsPage.BrandVerify();
    }
    @Test(priority = 9)
    public void storageTests(){
        learningMaterialsPage.Storage();
        learningMaterialsPage.VerifyStorage();
    }
    @Test(priority = 10)
    public void colorTests(){
        learningMaterialsPage.ColorDropdown();
        learningMaterialsPage.ColorSelection();
    }
    @Test(priority = 11)
    public void quantityTest(){
        learningMaterialsPage.Quantity("2");
        learningMaterialsPage.VerifySubtotal();
    }
    @Test(priority = 12)
    public void deliverAddressTest() {
        learningMaterialsPage.DeliveryAddress("123 Test Street");

        Assert.assertEquals(
                learningMaterialsPage.getDeliveryAddress(),
                "123 Test Street",
                "Delivery Address is not displayed correctly in the field."
        );
    }

    @Test(priority = 13)
    public void nextButtonTest() throws InterruptedException {
        learningMaterialsPage.NextButton();
        learningMaterialsPage.VerifyOrderReview();
    }
   @Test(priority = 14)
    public void shippingMethodTest(){
        learningMaterialsPage.ShippingMethod();
        learningMaterialsPage.ShippingMethodDisplayed();
   }
   @Test(priority = 15)
    public void warrantyTests(){
        learningMaterialsPage.WarrantyOption();
        learningMaterialsPage.WarrantyOptionSelected();
   }
   @Test(priority = 16)
    public void discountTests(){
        learningMaterialsPage.Discount("SAVE10");
        learningMaterialsPage.Apply();
        learningMaterialsPage.VerifyDiscountApplied();
   }
   @Test(priority = 17)
    public void confirmButton() throws InterruptedException {
        learningMaterialsPage.ConfirmButton();
        learningMaterialsPage.ToastMessage();
       Thread.sleep(5000);

   }
   @Test(priority = 18)
    public void verifyInvoiceTests() throws InterruptedException {
        learningMaterialsPage.ViewInvoice();
        learningMaterialsPage.ViewInvoiceHistory();
       Thread.sleep(5000);
        learningMaterialsPage.VerifyViewInvoice();
   }
}
