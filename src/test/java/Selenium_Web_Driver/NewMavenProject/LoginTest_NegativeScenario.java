package Selenium_Web_Driver.NewMavenProject;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

public class LoginTest_NegativeScenario extends TestBase{
	HomePage homeObject;
	RegistrationPage registerObject;
	String loginMessage = "Login to your account";
	String loginEmail = "asdqwefvcv@gmail.com",loginPassword="123456789";
	
@BeforeMethod
    public void setUp() {
		 homeObject = new HomePage(driver);
		 registerObject = new RegistrationPage(driver);
    }
  @Test
  public void loginWithWrongCredentials() {

		Assert.assertEquals(homeObject.getActualTitle(),"Automation Exercise");
		
		homeObject.openRegistrationPage();
		
		Assert.assertTrue(registerObject.loginMsg.getText().equalsIgnoreCase(loginMessage));

		registerObject.loginWithValidCredentials(loginEmail, loginPassword);
		
		Assert.assertTrue(registerObject.wrongCredentialsErrorMsg.getText().contains("Your email or password is incorrect!"));
  }
}
