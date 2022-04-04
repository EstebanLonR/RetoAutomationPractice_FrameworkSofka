package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DressesPage {

    @CacheLookup
    @FindBy(xpath = "//div[@class='subcategory-image']//child::a[@title='Evening Dresses']")
    WebElement eveningDresses;

    @CacheLookup
    @FindBy(xpath = "//img[@alt='Printed Dress']")
    WebElement printedDress;

    @CacheLookup
    @FindBy(id = "quantity_wanted")
    WebElement quantityWanted;

    @CacheLookup
    @FindBy(xpath = "//select[@id='group_1']//child::option[@title='S']")
    WebElement smallSize;

    @CacheLookup
    @FindBy(xpath = "//select[@id='group_1']//child::option[@title='M']")
    WebElement mediumSize;

    @CacheLookup
    @FindBy(xpath = "//select[@id='group_1']//child::option[@title='L']")
    WebElement largeSize;

    @CacheLookup
    @FindBy(id = "color_7")
    WebElement beigeColor;

    @CacheLookup
    @FindBy(id = "color_24")
    WebElement pinkColor;

    @CacheLookup
    @FindBy(xpath = "//p[@id='add_to_cart']//child::button[@name='Submit']")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(xpath = "//a[@title='View my shopping cart']")
    WebElement cartQuantityProducts;

    @CacheLookup
    @FindBy(xpath = "//a[@title='Proceed to checkout'][contains(string(), 'Proceed to checkout')]")
    WebElement proceedToCheckOut;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")
    WebElement continueShopping;

    public WebElement getEveningDresses() {
        return eveningDresses;
    }

    public WebElement getPrintedDress() {
        return printedDress;
    }

    public WebElement getQuantityWanted() {
        return quantityWanted;
    }

    public WebElement getSmallSize() {
        return smallSize;
    }

    public WebElement getMediumSize() {
        return mediumSize;
    }

    public WebElement getLargeSize() {
        return largeSize;
    }

    public WebElement getBeigeColor() {
        return beigeColor;
    }

    public WebElement getPinkColor() {
        return pinkColor;
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public WebElement getContinueShopping() {
        return continueShopping;
    }

    public WebElement getProceedToCheckOut() {
        return proceedToCheckOut;
    }

    public WebElement getCartQuantityProducts() {
        return cartQuantityProducts;
    }

    public DressesPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
