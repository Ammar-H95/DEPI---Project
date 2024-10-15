package Selenium_Web_Driver.NewMavenProject;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegistrationPage;

public class RegisterTest_NegativeScenario extends TestBase{
	HomePage homeObject ; 
	RegistrationPage registerObject ; 
	String registrationName = "Ammar Hossam",registrationEmail= "ammar1@gmail.com"; 
	String newUserSignupMessage = "New User Signup!";

	
  @Test
  public void registerWithExistedEmail() {
	  homeObject = new HomePage(driver);
	  registerObject = new RegistrationPage(driver);
	  
 Assert.assertEquals(homeObject.getActualTitle(),"Automation Exercise");
	  
	  homeObject.openRegistrationPage();
	  
	  Assert.assertTrue(registerObject.newUserSignupMsg.getText().equalsIgnoreCase(newUserSignupMessage));
	  
	  registerObject.newUserSignUp(registrationName, registrationEmail);
	  
	  Assert.assertTrue(registerObject.existedEmailErrorMsg.getText().equalsIgnoreCase("Email Address already exist!"));
  }
}
