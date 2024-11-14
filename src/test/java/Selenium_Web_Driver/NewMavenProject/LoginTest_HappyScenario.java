package Selenium_Web_Driver.NewMavenProject;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

public class LoginTest_HappyScenario extends TestBase{
	HomePage homeObject;
	RegistrationPage registerObject;
	String loginMessage = "Login to your account";
	String loginEmail = "ammar2@gmail.com",loginPassword="123456789";
	
	@BeforeMethod
    public void setUp() {
		 homeObject = new HomePage(driver);
		 registerObject = new RegistrationPage(driver);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
	
  @Test
  public void testLoginWithValidCredentials() {
	HomePage homeObject = new HomePage(driver);
	registerObject = new RegistrationPage(driver);

	Assert.assertEquals(homeObject.getActualTitle(),"Automation Exercise");
	
	homeObject.openRegistrationPage();
	
	Assert.assertTrue(registerObject.loginMsg.getText().equalsIgnoreCase(loginMessage));

	registerObject.loginWithValidCredentials(loginEmail, loginPassword);
	
	Assert.assertTrue(registerObject.loggedInMsg.getText().contains("Logged in as"));
	
	registerObject.logOut();
	
  }
}
