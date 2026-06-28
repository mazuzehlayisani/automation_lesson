package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LearningMaterialsPage {
    WebDriver driver;


    By LearningMaterialsItem = By.xpath("//button[@class='nav-dropdown-item ']/span[contains(text(),'Learning Materials')]");
    By WebAutomationAdvanceOption = By.id("tab-btn-web");
    By DeviceTypeDropdown = By.id("deviceType");
    By DeviceSelection = By.xpath("//*[@id=\"deviceType\"]/option[2]");
    By verifyDeviceSelection = By.xpath("//*[@id=\"device-preview\"]/div");
    By BrandDropdown = By.id("brand");
    By BrandSelection = By.xpath("//*[@id=\"brand\"]/option[2]");
    By VerifyBrandSelection = By.xpath("//*[@id=\"device-preview\"]/div/img");
    By StorageRadio = By.id("storage-128GB");
    By VerifyStorageSelection = By.id("unit-price-value");
    By ColorDropdown = By.id("color");
    By ColorSelection = By.xpath("//*[@id=\"color\"]/option[4]");
    By QuantityField = By.id("quantity");
    By VerifySubtotal = By.id("subtotal-label");
    By DeliveryAddressTextbox = By.id("address");
    By deliveryAddress = By.cssSelector("[data-testid='address-input']");
    By NextButton = By.id("inventory-next-btn");
    By VerifyOrderReview = By.id("inventory-review-step");
    By ShippingMethodRadio = By.id("shipping-option-express");
    By VerifyShippingAdded = By.id("breakdown-shipping-value");
    By WarrantyRadio = By.id("warranty-option-1yr");
    By VerifyWarrantyAdded = By.id("breakdown-warranty-value");
    By DiscountTextField = By.id("discount-code");
    By ApplyButton = By.id("apply-discount-btn");
    By VerifyByDiscountValue = By.id("breakdown-discount-value");
    By ConfirmButton = By.id("purchase-device-btn");
    By VerifyToastMessage = By.id("purchase-success-toast");
    By ViewInvoiceButton = By.id("view-history-btn");
    By VerifyInvoiceHistory = By.id("invoice-history-panel");
    By VerifyViewInvoice = By.xpath("//button[contains(.,'View')]");

    public LearningMaterialsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void LearningMaterialsItem() {
        driver.findElement(LearningMaterialsItem).click();
    }

    public void WebAutomationAdvanceOption() {
        driver.findElement(WebAutomationAdvanceOption).click();
    }

    public void DeviceType() {
        driver.findElement(DeviceTypeDropdown).click();

    }

    public void DeviceSelection() {
        driver.findElement(DeviceSelection).click();
    }

    public void VerifyDeviceType() {
        driver.findElement(verifyDeviceSelection).isDisplayed();
    }

    public void Brand() {
        driver.findElement(BrandDropdown).click();
    }

    public void BrandSelection() {
        driver.findElement(BrandSelection).click();
    }

    public void BrandVerify() {
        driver.findElement(VerifyBrandSelection).isDisplayed();
    }

    public void Storage() {
        driver.findElement(StorageRadio).click();
    }

    public void VerifyStorage() {
        driver.findElement(VerifyStorageSelection).isDisplayed();
    }

    public void ColorDropdown() {
        driver.findElement(ColorDropdown).click();
    }

    public void ColorSelection() {
        driver.findElement(ColorSelection).click();
    }

    public void Quantity(String quantity) {
        driver.findElement(QuantityField).sendKeys(quantity);
    }

    public void VerifySubtotal() {
        driver.findElement(VerifySubtotal).isDisplayed();
    }

    public void DeliveryAddressText(String address) {
        driver.findElement(DeliveryAddressTextbox);
    }

    public void DeliveryAddress(String address) {
        WebElement field = driver.findElement(deliveryAddress);
        field.clear();
        field.sendKeys(address);
    }

    public String getDeliveryAddress() {
        return driver.findElement(deliveryAddress).getAttribute("value");
    }
    public void NextButton() {
        driver.findElement(NextButton).click();
    }

    public void VerifyOrderReview() {
        driver.findElement(VerifyOrderReview).isDisplayed();
    }
  public void ShippingMethod(){
        driver.findElement(ShippingMethodRadio).click();
  }
  public void ShippingMethodDisplayed(){
        driver.findElement(VerifyShippingAdded).isDisplayed();
  }
  public void WarrantyOption(){
        driver.findElement(WarrantyRadio).click();
  }
  public void WarrantyOptionSelected(){
        driver.findElement(VerifyWarrantyAdded).isDisplayed();
  }
  public void Discount(String discount){
        driver.findElement(DiscountTextField).sendKeys(discount);
  }
  public void Apply(){
        driver.findElement(ApplyButton).click();
  }

  public void VerifyDiscountApplied(){
        driver.findElement(VerifyByDiscountValue).isDisplayed();
  }
  public void ConfirmButton(){
        driver.findElement(ConfirmButton).click();
  }
  public void ToastMessage(){
        driver.findElement(VerifyToastMessage).isDisplayed();
  }
  public void ViewInvoice(){
        driver.findElement(ViewInvoiceButton).click();
  }
  public void ViewInvoiceHistory(){
        driver.findElement(VerifyInvoiceHistory).isDisplayed();
  }
  public void VerifyViewInvoice(){
        driver.findElement(VerifyViewInvoice).click();
  }
}


