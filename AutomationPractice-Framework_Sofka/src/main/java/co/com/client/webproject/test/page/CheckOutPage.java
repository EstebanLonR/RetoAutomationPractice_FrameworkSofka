package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

    @CacheLookup
    @FindBy(xpath = "//button[@name='processAddress']")
    WebElement proccedAddress;

    @CacheLookup
    @FindBy(xpath = "//label[contains(string(), 'I agree to the terms of service and will adhere to them unconditionally.')]")
    WebElement acceptTermns;

    @CacheLookup
    @FindBy(xpath = "//button[@name='processCarrier']")
    WebElement processCarrier;

    @CacheLookup
    @FindBy(xpath = "//a[@title='Pay by bank wire']")
    WebElement payBankWire;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit'][contains(string(), 'I confirm my order')]")
    WebElement confirmMyOrder;

    @CacheLookup
    @FindBy(xpath = "//strong[contains(string(), 'Your order on My Store is complete.')]")
    WebElement orderCompleteMessage;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
    WebElement proceedCheckOut;

    public WebElement getProceedCheckOut() {
        return proceedCheckOut;
    }

    public WebElement getProccedAddress() {
        return proccedAddress;
    }

    public WebElement getAcceptTermns() {
        return acceptTermns;
    }

    public WebElement getProcessCarrier() {
        return processCarrier;
    }

    public WebElement getPayBankWire() {
        return payBankWire;
    }

    public WebElement getConfirmMyOrder() {
        return confirmMyOrder;
    }

    public WebElement getOrderCompleteMessage() {
        return orderCompleteMessage;
    }

    public CheckOutPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
