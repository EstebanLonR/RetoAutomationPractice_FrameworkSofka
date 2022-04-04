package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    @CacheLookup
    @FindBy(xpath = "//select[@id='id_contact']//child::option[contains(string(), 'Customer service')]")
    WebElement subjectCustomerService;

    @CacheLookup
    @FindBy(xpath = "//select[@id='id_contact']//child::option[contains(string(), 'Webmaster')]")
    WebElement subjectWebMaster;

    @CacheLookup
    @FindBy(id = "email")
    WebElement emailAddress;

    @CacheLookup
    @FindBy(id = "id_order")
    WebElement orderReference;

    @CacheLookup
    @FindBy(id = "message")
    WebElement message;

    @CacheLookup
    @FindBy(id = "submitMessage")
    WebElement submitMessage;

    @CacheLookup
    @FindBy(xpath = "//p[@class='alert alert-success'][contains(string(), 'Your message has been successfully sent to our team.')]")
    WebElement messageSuccesfullySent;

    @CacheLookup
    @FindBy(xpath = "//li[contains(string(),'The message cannot be blank.')]")
    WebElement messageCannotBlank;

    public WebElement getEmailAddress() {
        return emailAddress;
    }

    public WebElement getOrderReference() {
        return orderReference;
    }

    public WebElement getMessage() {
        return message;
    }

    public WebElement getSubmitMessage() {
        return submitMessage;
    }

    public WebElement getSubjectCustomerService() {
        return subjectCustomerService;
    }

    public WebElement getMessageSuccesfullySent() {
        return messageSuccesfullySent;
    }

    public WebElement getSubjectWebMaster() {
        return subjectWebMaster;
    }

    public WebElement getMessageCannotBlank() {
        return messageCannotBlank;
    }

    public ContactUsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
