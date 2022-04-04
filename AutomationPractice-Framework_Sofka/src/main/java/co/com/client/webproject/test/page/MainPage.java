package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @CacheLookup
    @FindBy(xpath = "//a[@class='login']")
    WebElement signIn;

    @CacheLookup
    @FindBy(id = "contact-link")
    WebElement contactUs;

    @CacheLookup
    @FindBy(xpath = "(//a[@title='Dresses'][contains(string(),'Dresses')])[2]")
    WebElement dresses;

    public WebElement getSignIn() {
        return signIn;
    }

    public WebElement getContactUs() {
        return contactUs;
    }

    public WebElement getDresses() {
        return dresses;
    }

    public MainPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
