package Selenium_Web_Driver.NewMavenProject;

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
    }
	
  @Test
  public void testingSearchingForProduct() throws InterruptedException {
	  
	  Assert.assertEquals(homeObject.getActualTitle(),"Automation Exercise");
	  Thread.sleep(3000);
	  
	  homeObject.openProducts();
	  
	  Assert.assertTrue(productObject.allProductsMsg.getText().equalsIgnoreCase("All Products"));
	  Thread.sleep(5000);
	  
	  productObject.searchForItem(productName);
	  Thread.sleep(3000);
	  
	  Assert.assertEquals(productObject.productName.getText(), productName);
  }
}
