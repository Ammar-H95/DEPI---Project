package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products extends PageBase{

	public Products(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (className  = "title")
	public WebElement allProductsMsg;
	
	//we want to check if all product are shown on the web page
	//we are going to make a list of all the product 
	@FindBy (className = "single-products")
	public List<WebElement> products;
	
	//the case want the 1st product so this will always choose the 1st product 
	@FindBy (linkText = "View Product")
	private WebElement viewProductBtn;
	
	@FindBy (id ="search_product")
	private WebElement productSearchBar;
	
	@FindBy (id ="submit_search")
	private WebElement searchBtn;
	
	@FindBy (xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/p")
	public WebElement productName;
	
	public void clickFirstProduct() {
		viewProductBtn.click();
	}
	
	 public void searchForItem(String productName) {
	        try {
	            productSearchBar.sendKeys(productName);
	            searchBtn.click();
	        } catch (Exception e) {
	            System.out.println("Failed to search for item: " + e.getMessage());
	        }
	    }
	 
}
