package Selenium_Web_Driver.NewMavenProject;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class SubscriptionTest_HappyScenario extends TestBase{
	HomePage homeObject;
	String subscribeEmail = "test@test.com";
	
	@BeforeMethod
    public void setUp() {
		 homeObject = new HomePage(driver);
    }
  @Test
  public void testingSubscription() throws InterruptedException {
	  
	 Assert.assertEquals(homeObject.getActualTitle(),"Automation Exercise");
	 Thread.sleep(3000);
	  
	 homeObject.scrollDown();
	 Thread.sleep(3000);
	  
	 homeObject.addSubscribeEmail(subscribeEmail);
	 Thread.sleep(1000);
	  
	 Assert.assertTrue(homeObject.subscribeSuccessMsg.getText().contains("successfully subscribed"));
  }
}
