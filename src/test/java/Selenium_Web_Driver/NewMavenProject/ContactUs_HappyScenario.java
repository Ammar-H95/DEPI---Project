package Selenium_Web_Driver.NewMavenProject;

import java.awt.AWTException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactUs;
import pages.HomePage;

public class ContactUs_HappyScenario extends TestBase{
	ContactUs contactObject ;
	HomePage homeObject;
	String name = "ammar",email = "test@test.com",subject = "test",message = "hello world";
	
	@BeforeMethod
    public void setUp() {
		 homeObject = new HomePage(driver);
         contactObject = new ContactUs(driver);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
  @Test
  public void testContactUs() throws AWTException, InterruptedException {
	  
	  
	  Assert.assertEquals(homeObject.getActualTitle(),"Automation Exercise");

	  homeObject.openContactUs();
	  
	  Assert.assertTrue(contactObject.getInTouchMsg.getText().equalsIgnoreCase("Get In Touch"));
	  
	  contactObject.usingContactUs(name, email, subject, message);
	  
	  Assert.assertTrue(contactObject.submitSuccessMsg.getText().contains("submitted successfully"));
	  
	  contactObject.gotHome();
	  
	  Assert.assertEquals(homeObject.getActualTitle(),"Automation Exercise");

  }
}
