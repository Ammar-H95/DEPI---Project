package Selenium_Web_Driver.NewMavenProject;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Products;
import pages.ProductsDetails;

public class ProductsTest_HappyScenario extends TestBase {
	HomePage homeObject;
	Products productObject;
	ProductsDetails productDetailsObject;

	private int productsNumber = 34;

	@BeforeMethod
	public void setUp() {
		homeObject = new HomePage(driver);
		productObject = new Products(driver);
		productDetailsObject = new ProductsDetails(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@Test(priority = 1)
	public void testingAllProductsAreVisabile() throws InterruptedException {

		Assert.assertEquals(homeObject.getActualTitle(), "Automation Exercise");
		Thread.sleep(1000);
		homeObject.openProducts();

		Assert.assertTrue(productObject.allProductsMsg.getText().equalsIgnoreCase("All Products"));
		Thread.sleep(2000);

		// to check the visibility of all products we need to loop over them
		// we are going to use "for-each loop"
		List<WebElement> products = productObject.products;
		int visibleProductCount = countVisibleProducts(products);

		Assert.assertEquals(productsNumber, visibleProductCount);

		Thread.sleep(1000);

	}

	@Test(priority = 2)
	public void testingViewProduct() throws InterruptedException {
		productObject = new Products(driver);
		productDetailsObject = new ProductsDetails(driver);

		productObject.clickFirstProduct();

		assertTitle(productDetailsObject.pageTitle, "Automation Exercis");

		Assert.assertTrue(productDetailsObject.productName.isDisplayed());

		Assert.assertTrue(productDetailsObject.productCategory.isDisplayed());

		Assert.assertTrue(productDetailsObject.productPrice.isDisplayed());

		Assert.assertTrue(productDetailsObject.productAvailabilty.isDisplayed());

		Assert.assertTrue(productDetailsObject.productCondition.isDisplayed());

		Assert.assertTrue(productDetailsObject.productCondition.isDisplayed());

		Assert.assertTrue(productDetailsObject.productBrand.isDisplayed());

	}

	private void assertTitle(String actualTitle, String expectedSubstring) {
		Assert.assertTrue(actualTitle.contains(expectedSubstring),
				"Page title does not contain the expected substring. Expected to contain: " + expectedSubstring
						+ ", but found: " + actualTitle);
		System.out.println("Title is valid and contains: " + expectedSubstring);
	}

	// to check the visibility of all products we need to loop over them
	// we are going to use "for-each loop"
	private int countVisibleProducts(List<WebElement> products) {
		int count = 0;
		for (WebElement product : products) {
			if (product.isDisplayed()) {
				count++;
			}
		}
		return count;
	}
}
