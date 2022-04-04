package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountPage {

    @CacheLookup
    @FindBy(id = "email_create")
    WebElement emailAddress;

    @CacheLookup
    @FindBy(id = "SubmitCreate")
    WebElement createAnAccount;

    @CacheLookup
    @FindBy(id = "customer_firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "customer_lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "passwd")
    WebElement password;

    @CacheLookup
    @FindBy(id = "address1")
    WebElement address1;

    @CacheLookup
    @FindBy(id = "city")
    WebElement city;

    @CacheLookup
    @FindBy(id = "id_state")
    WebElement state;

    @CacheLookup
    @FindBy(id = "postcode")
    WebElement postCode;

    @CacheLookup
    @FindBy(id = "phone_mobile")
    WebElement phoneMobile;

    @CacheLookup
    @FindBy(id = "submitAccount")
    WebElement register;

    public WebElement getEmailAddress() {
        return emailAddress;
    }

    public WebElement getCreateAnAccount() {
        return createAnAccount;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getAddress1() {
        return address1;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getState() {
        return state;
    }

    public WebElement getPostCode() {
        return postCode;
    }

    public WebElement getPhoneMobile() {
        return phoneMobile;
    }

    public WebElement getRegister() {
        return register;
    }

    public CreateAnAccountPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
