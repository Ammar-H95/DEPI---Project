package Selenium_Web_Driver.NewMavenProject;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Products;
import pages.ViewCart;

public class AddProductsInCart extends TestBase {
	HomePage homeObject;
	Products productsObject;
	ViewCart cartObject;
	// array of added items
	private final String[] productsList = { "Blue Top", "Men Tshirt" };

	// to add break to if condition so we don't go through all the items
	int numberOfItems = 0;

	@BeforeMethod
	public void setUp() {
		homeObject = new HomePage(driver);
		productsObject = new Products(driver);
		cartObject = new ViewCart(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test
	public void testingAddingProductsInCart() throws InterruptedException {

		
		Assert.assertEquals(homeObject.getActualTitle(), "Automation Exercise");
		
		homeObject.openProducts();
		
		getProductsName(productsObject.products);
		
		homeObject.openCart();
		
		Thread.sleep(1000);
		
		Assert.assertEquals(cartObject.cartProducts.size(), productsList.length);
		

	}

	public void getProductsName(List<WebElement> products) throws InterruptedException {

		for (int i = 0; i < productsObject.products.size(); i++) {

			String[] name = products.get(i).getText().split("\n");

			String formatedName = name[1];

			List<String> addedProductsToCart = Arrays.asList(productsList);

			if (addedProductsToCart.contains(formatedName)) {
				// we can't use break here as we are adding multiple items
				productsObject.addToCartBtn.get(i).click();
				productsObject.continueShopping();
				numberOfItems++;

				if (numberOfItems == productsList.length) {
					break;
				}
			}
		}
		
	}
	
	}