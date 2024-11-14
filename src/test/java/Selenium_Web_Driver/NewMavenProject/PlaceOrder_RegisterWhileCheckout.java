package Selenium_Web_Driver.NewMavenProject;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Products;
import pages.ProductsDetails;
import pages.RegistrationPage;
import pages.ViewCart;

public class PlaceOrder_RegisterWhileCheckout extends TestBase {

	HomePage homeObject;
	Products productObject;
	ProductsDetails productDetailsObject;
	ViewCart viewCartObject;
	Products productsObject;
	RegistrationPage registerObject;
	private final String[] productsList = { "Blue Top", "Men Tshirt" };
	private int numberOfItems = 0;
	private String newUserSignupMessage = "New User Signup!";
	private String registrationName = "Ammar Hossam", registrationEmail = "ammartest222@gmail.com";
	private String password = "123456789", day = "8", month = "10", year = "1995";
	private String firstName = "ammar", lastName = "hossam", address1 = "maadi", address2 = "zamalek";
	private String company = "SeekMake", country = "Canada", state = "test", city = "test123";
	private String zipCode = "1234", mobileNumber = "01125200217";

	public void setUp() {
		homeObject = new HomePage(driver);
		productDetailsObject = new ProductsDetails(driver);
		productObject = new Products(driver);
		viewCartObject = new ViewCart(driver);
		productsObject = new Products(driver);
		registerObject = new RegistrationPage(driver);
	}

	@Test
	public void RegisterWhileCheckout() throws InterruptedException {
		Assert.assertEquals(homeObject.getActualTitle(), "Automation Exercise");
		getProductsName(productObject.products);
		homeObject.openCart();
		Assert.assertTrue(viewCartObject.cartMsg.getText().equalsIgnoreCase("Shopping Cart"));
		viewCartObject.proceedToCheckOut();
		Thread.sleep(2000);
		viewCartObject.login_RegisterProceed();
		

		// Fill in New User Sign up Form
		registerObject.newUserSignUp(registrationName, registrationEmail);

		// Complete Registration
		registerObject.userCanRegister(password, day, month, year, firstName, lastName, company, address1, address2,
				country, state, city, zipCode, mobileNumber);

		// Verify Account Created Message
		Assert.assertTrue(registerObject.successMessage.getText().equalsIgnoreCase("Account Created!"));

		// Continue after registration
		registerObject.continueAccount();

		// Verify Logged In as message
		Assert.assertTrue(registerObject.loggedInMsg.getText().contains("Logged in as"));

		homeObject.openCart();
		viewCartObject.proceedToCheckOut();
		
		

		
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
