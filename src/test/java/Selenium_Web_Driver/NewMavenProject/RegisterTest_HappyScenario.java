package Selenium_Web_Driver.NewMavenProject;


import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import pages.DeleteAccount;
import pages.HomePage;
import pages.RegistrationPage;

public class RegisterTest_HappyScenario extends TestBase{
	HomePage homeObject;
	RegistrationPage registerObject;
	DeleteAccount deleteObject;
	
	String newUserSignupMessage = "New User Signup!";
	String registrationName = "Ammar Hossam",registrationEmail= "ammartest22@gmail.com";
	String password = "123456789",day = "8",month="10",year = "1995";
	String firstName = "ammar",lastName = "hossam",address1 = "maadi",address2 = "zamalek";
	String company = "SeekMake",country = "Canada",state = "test",city = "test123";
	String zipCode = "1234",mobileNumber = "01125200217";
	
	@BeforeMethod
    public void setUp() {
        homeObject = new HomePage(driver);
        registerObject = new RegistrationPage(driver);
        deleteObject = new DeleteAccount(driver);
    }
	
  @Test
  public void testRegister_NewEmail() {
	  
	  // Verify Home Page Title
      Assert.assertEquals(homeObject.getActualTitle(), "Automation Exercise", "Home page title mismatch!");

      // Navigate to Registration Page
      homeObject.openRegistrationPage();

      // Verify New User Signup Message
      Assert.assertEquals(registerObject.newUserSignupMsg.getText(), newUserSignupMessage, "Signup message mismatch!");

      // Fill in New User Signup Form
      registerObject.newUserSignUp(registrationName, registrationEmail);

      // Verify 'Enter Account Information' message
      Assert.assertEquals(registerObject.enterAccountInfo.getText(), "ENTER ACCOUNT INFORMATION");

      // Complete Registration
      registerObject.userCanRegister(password, day, month, year, firstName, lastName, company, address1, address2, country, state, city, zipCode, mobileNumber);

      // Verify Account Created Message
      Assert.assertTrue(registerObject.successMessage.getText().equalsIgnoreCase("Account Created!"));

      // Continue after registration
      registerObject.continueAccount();

      // Verify Logged In as message
      Assert.assertTrue(registerObject.loggedInMsg.getText().contains("Logged in as"));

      // Delete account after registration
      homeObject.deleteAccount();

      // Verify Account Deleted Message
      Assert.assertTrue(deleteObject.deleteSuccessMsg.getText().equalsIgnoreCase("Account Deleted!"));

      deleteObject.continueAfterDelete();
  }
}
