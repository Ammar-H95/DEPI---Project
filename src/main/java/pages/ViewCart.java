package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewCart extends PageBase {

	public ViewCart(WebDriver driver) {
		super(driver);
	}

	private static final String PROCEED_TO_CHECKOUT = "Signup / Login";
	private static final String REGISTER_LOGIN = "Signup / Login";

	@FindBy(linkText = PROCEED_TO_CHECKOUT)
	WebElement proceedToCheckOutBtn;
	
	@FindBy(linkText = REGISTER_LOGIN)
	WebElement registerLoginBtn;
	
	@FindBy(xpath = "//h2[contains(text(),'Subscription')]")
	public WebElement subscriptionMsg;

	@FindBy(id = "susbscribe_email")
	WebElement subscriptionEmailField;

	@FindBy(id = "subscribe")
	WebElement subscribeBtn;

	@FindBy(xpath = "//div[contains(text(),'You have been successfully subscribed!')]")
	public WebElement successfulSubscriptionMsg;

	@FindBy(xpath = "//td[@class='cart_product']")
	public List<WebElement> cartProducts;

	@FindBy(xpath = "//p[@class='cart_total_price']")
	public List<WebElement> carttotal;

	@FindBy(className = "disabled")
	public WebElement productQuantity;
	
	@FindBy (xpath = "//li[@class='address_firstname address_lastname']")
	public WebElement firstNameLastNameField;
	
	@FindBy (xpath = "//li[@class='address_address1 address_address2'][1]")
	public WebElement address1Field;
	
	@FindBy (xpath = "//li[@class='address_address1 address_address2'][2]")
	public WebElement address2Field;
	
	@FindBy (xpath = "//li[@class='address_address1 address_address2'][3]")
	public WebElement address3Field;
	
	@FindBy(xpath = "//li[contains(text(),'Shopping Cart')]")
	public WebElement cartMsg;

	public void addingEmailToSubscriptionField(String Email) {
		subscriptionEmailField.sendKeys(Email);
		subscribeBtn.click();
	}
	public void proceedToCheckOut() {
		proceedToCheckOutBtn.click();
	}
	public void login_RegisterProceed() {
		registerLoginBtn.click();
	}
}
