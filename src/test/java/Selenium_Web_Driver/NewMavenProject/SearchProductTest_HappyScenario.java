package Selenium_Web_Driver.NewMavenProject;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Products;

public class SearchProductTest_HappyScenario extends TestBase{
	HomePage homeObject;
	Products productObject;
	String productName = "Men Tshirt";
	
	@BeforeMethod
    public void setUp() {
		 homeObject = new HomePage(driver);
		 productObject = new Products(driver);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
	
  @Test
  public void testingSearchingForProduct() throws InterruptedException {
	  
	  homeObject.openHome();
	  
	  Assert.assertEquals(homeObject.getActualTitle(),"Automation Exercise");
	  
	  homeObject.openProducts();
	  
	  Assert.assertTrue(productObject.allProductsMsg.getText().equalsIgnoreCase("All Products"));
	  
	  productObject.searchForItem(productName);
	  
	  Assert.assertEquals(productObject.productName.getText(), "Men Tshirt");
  }
}
