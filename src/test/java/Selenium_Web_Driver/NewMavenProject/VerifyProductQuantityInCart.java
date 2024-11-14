package Selenium_Web_Driver.NewMavenProject;

import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Products;
import pages.ProductsDetails;
import pages.ViewCart;

public class VerifyProductQuantityInCart extends TestBase {
	HomePage homeObject;
	Products productObject;
	ProductsDetails productDetailsObject;
	ViewCart viewCartObject;
	final private String quantityOfProduct = "3";

	@BeforeMethod

	public void setUp() {
		homeObject = new HomePage(driver);
		productDetailsObject = new ProductsDetails(driver);
		productObject = new Products(driver);
		viewCartObject = new ViewCart(driver);
	}

	@Test
	public void increaseProductQuantityInCart() throws InterruptedException {

		Assert.assertEquals(homeObject.getActualTitle(), "Automation Exercise");

		homeObject.openProducts();
		
		productObject.viewProduct();
		
		productDetailsObject.increasingProducts(quantityOfProduct);
		
		productDetailsObject.addProductToCart();
		
		Thread.sleep(2000);
		
		productObject.viewCart();
		
		assertEquals(viewCartObject.productQuantity.getText(), quantityOfProduct);
	}
}
