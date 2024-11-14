package Selenium_Web_Driver.NewMavenProject;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ViewCart;

public class SubscriptionTest_HappyScenario extends TestBase{
	HomePage homeObject;
	ViewCart 	cartObject;
	String subscribeEmail = "test@test.com",SubscriptionMsg ="SUBSCRIPTION";
	
	@BeforeMethod
    public void setUp() {
		 homeObject = new HomePage(driver);
		 cartObject = new ViewCart(driver);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
  @Test (priority = 1)
  public void testingSubscription() throws InterruptedException {
	  
	 Assert.assertEquals(homeObject.getActualTitle(),"Automation Exercise");
	  
	 homeObject.scrollDown();
	 
	 homeObject.addSubscribeEmail(subscribeEmail);
	  
	 Assert.assertTrue(homeObject.subscribeSuccessMsg.getText().contains("successfully subscribed"));
  }
  @Test (priority = 2)
  public void testSubscriptionInCartPage() {
	  
	  homeObject.openCart();
	  
	  homeObject.scrollDown();
	  
	  Assert.assertTrue(cartObject.subscriptionMsg.getText().contains(SubscriptionMsg));
	  
	  cartObject.addingEmailToSubscriptionField(subscribeEmail);
	  
	  Assert.assertTrue(cartObject.successfulSubscriptionMsg.getText().equalsIgnoreCase("You have been successfully subscribed!"));	
}
}
