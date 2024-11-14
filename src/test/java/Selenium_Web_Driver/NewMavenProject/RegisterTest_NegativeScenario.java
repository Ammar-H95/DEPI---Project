package Selenium_Web_Driver.NewMavenProject;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

public class RegisterTest_NegativeScenario extends TestBase{
	HomePage homeObject ; 
	RegistrationPage registerObject ; 
	String registrationName = "Ammar Hossam",registrationEmail= "ammar1@gmail.com"; 
	String newUserSignupMessage = "New User Signup!";

	@BeforeMethod
    public void setUp() {
        homeObject = new HomePage(driver);
        registerObject = new RegistrationPage(driver);
        //wait duration 5 sec in case element takes time to render 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
  @Test
  public void registerWithExistedEmail() {
	  
	  
 Assert.assertEquals(homeObject.getActualTitle(),"Automation Exercise");
	  
	  homeObject.openRegistrationPage();
	  
	  Assert.assertTrue(registerObject.newUserSignupMsg.getText().equalsIgnoreCase(newUserSignupMessage));
	  
	  registerObject.newUserSignUp(registrationName, registrationEmail);
	  
	  Assert.assertTrue(registerObject.existedEmailErrorMsg.getText().equalsIgnoreCase("Email Address already exist!"));
  }
}
