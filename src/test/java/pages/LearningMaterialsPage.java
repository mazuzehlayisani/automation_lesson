package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LearningMaterialsPage {
    WebDriver driver;


    By LearningMaterialsItem_ByXpath = By.xpath("//button[@class='nav-dropdown-item ']/span[contains(text(),'Learning Materials')]");
    By WebAutomationAdvanceOption_ById = By.id("tab-btn-web");
    By DeviceTypeDropdown_ById = By.id("deviceType");
    By DeviceSelection_ByXpath = By.xpath("//*[@id=\"deviceType\"]/option[2]");
    By verifyDeviceSelection_ByXpath = By.xpath("//*[@id=\"device-preview\"]/div");
    By BrandDropdown_ById = By.id("brand");
    By BrandSelection_ByXpath = By.xpath("//*[@id=\"brand\"]/option[2]");
    By VerifyBrandSelection_ByXpath = By.xpath("//*[@id=\"device-preview\"]/div/img");
    By StorageRadio_ById = By.id("storage-128GB");
    By VerifyStorageSelection_ById = By.id("unit-price-value");
    By ColorDropdown_ById = By.id("color");
    By ColorSelection_ByXpath = By.xpath("//*[@id=\"color\"]/option[4]");
    By QuantityField_ById = By.id("quantity");
    By VerifySubtotal_ById = By.id("subtotal-label");
    By DeliveryAddressTextbox_ById = By.id("address");
    By deliveryAddress_ByCSS = By.cssSelector("[data-testid='address-input']");
    By NextButton_ById = By.id("inventory-next-btn");
    By VerifyOrderReview_ById = By.id("inventory-review-step");
    By ShippingMethodRadio_ById = By.id("shipping-option-express");
    By VerifyShippingAdded_ById = By.id("breakdown-shipping-value");
    By WarrantyRadio_ById = By.id("warranty-option-1yr");
    By VerifyWarrantyAdded_ById = By.id("breakdown-warranty-value");
    By DiscountTextField_ById = By.id("discount-code");
    By ApplyButton_ById = By.id("apply-discount-btn");
    By VerifyByDiscountValue_ById = By.id("breakdown-discount-value");
    By ConfirmButton_ById = By.id("purchase-device-btn");
    By VerifyToastMessage_ById = By.id("purchase-success-toast");
    By ViewInvoiceButton_ById = By.id("view-history-btn");
    By VerifyInvoiceHistory_ById = By.id("invoice-history-panel");
    By VerifyViewInvoice_ById = By.xpath("//button[contains(.,'View')]");

    public LearningMaterialsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void LearningMaterialsItem() {
        driver.findElement(LearningMaterialsItem_ByXpath).click();
    }

    public void WebAutomationAdvanceOption() {
        driver.findElement(WebAutomationAdvanceOption_ById).click();
    }

    public void DeviceType() {
        driver.findElement(DeviceTypeDropdown_ById).click();

    }

    public void DeviceSelection() {
        driver.findElement(DeviceSelection_ByXpath).click();
    }

    public void VerifyDeviceType() {
        driver.findElement(verifyDeviceSelection_ByXpath).isDisplayed();
    }

    public void Brand() {
        driver.findElement(BrandDropdown_ById).click();
    }

    public void BrandSelection() {
        driver.findElement(BrandSelection_ByXpath).click();
    }

    public void BrandVerify() {
        driver.findElement(VerifyBrandSelection_ByXpath).isDisplayed();
    }

    public void Storage() {
        driver.findElement(StorageRadio_ById).click();
    }

    public void VerifyStorage() {
        driver.findElement(VerifyStorageSelection_ById).isDisplayed();
    }

    public void ColorDropdown() {
        driver.findElement(ColorDropdown_ById).click();
    }

    public void ColorSelection() {
        driver.findElement(ColorSelection_ByXpath).click();
    }

    public void Quantity(String quantity) {
        driver.findElement(QuantityField_ById).sendKeys(quantity);
    }

    public void VerifySubtotal() {
        driver.findElement(VerifySubtotal_ById).isDisplayed();
    }

    public void DeliveryAddressText(String address) {
        driver.findElement(DeliveryAddressTextbox_ById);
    }

    public void DeliveryAddress(String address) {
        WebElement field = driver.findElement(deliveryAddress_ByCSS);
        field.clear();
        field.sendKeys(address);
    }

    public String getDeliveryAddress_ByCSS() {
        return driver.findElement(deliveryAddress_ByCSS).getAttribute("value");
    }
    public void NextButton() {
        driver.findElement(NextButton_ById).click();
    }
    public void VerifyOrderReview() {
        driver.findElement(VerifyOrderReview_ById).isDisplayed();
    }
  public void ShippingMethod(){
        driver.findElement(ShippingMethodRadio_ById).click();
  }
  public void ShippingMethodDisplayed(){
        driver.findElement(VerifyShippingAdded_ById).isDisplayed();
  }
  public void WarrantyOption(){
        driver.findElement(WarrantyRadio_ById).click();
  }
  public void WarrantyOptionSelected(){
        driver.findElement(VerifyWarrantyAdded_ById).isDisplayed();
  }
  public void Discount(String discount){
        driver.findElement(DiscountTextField_ById).sendKeys(discount);
  }
  public void Apply(){
        driver.findElement(ApplyButton_ById).click();
  }

  public void VerifyDiscountApplied(){
        driver.findElement(VerifyByDiscountValue_ById).isDisplayed();
  }
  public void ConfirmButton(){
        driver.findElement(ConfirmButton_ById).click();
  }
  public void ToastMessage(){
        driver.findElement(VerifyToastMessage_ById).isDisplayed();
  }
  public void ViewInvoice(){
        driver.findElement(ViewInvoiceButton_ById).click();
  }
  public void ViewInvoiceHistory(){
        driver.findElement(VerifyInvoiceHistory_ById).isDisplayed();
  }
  public void VerifyViewInvoice(){
        driver.findElement(VerifyViewInvoice_ById).click();
  }
}


