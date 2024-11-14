package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsDetails extends PageBase {

	public ProductsDetails(WebDriver driver) {
		super(driver);
	}

	public String pageTitle = driver.getTitle();
    private static final String VIEW_CART = "View Cart";

	private static final String FORM_PREFIX = "/html/body/section/div/div/div[2]/div[2]/div[2]/div";

	@FindBy(xpath = FORM_PREFIX + "/h2")
	public WebElement productName;

	@FindBy(xpath = FORM_PREFIX + "/p[1]")
	public WebElement productCategory;

	@FindBy(xpath = FORM_PREFIX + "/span/span")
	public WebElement productPrice;

	@FindBy(xpath = FORM_PREFIX + "/p[2]/b")
	public WebElement productAvailabilty;

	@FindBy(xpath = FORM_PREFIX + "/p[3]/b")
	public WebElement productCondition;

	@FindBy(xpath = FORM_PREFIX + "/p[4]/b")
	public WebElement productBrand;

	@FindBy(id = "quantity")
	WebElement productQuantity;

	@FindBy(xpath = "//button[@type='button']")
	WebElement addToCartBtn;

	@FindBy (linkText = VIEW_CART)
	WebElement viewCart;
	public void increasingProducts(String numberOfProducts) {
		productQuantity.clear();
		productQuantity.sendKeys(numberOfProducts);

	}
	public void addProductToCart() {
		addToCartBtn.click();
	}
}
