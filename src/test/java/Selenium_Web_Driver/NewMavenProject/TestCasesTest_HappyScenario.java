package Selenium_Web_Driver.NewMavenProject;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TestCases;

public class TestCasesTest_HappyScenario extends TestBase{
	HomePage homeObject ;
	TestCases testCasesObject;
	
@BeforeMethod
    public void setUp() {
		 homeObject = new HomePage(driver);
		 testCasesObject = new TestCases(driver);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
  @Test
  public void testNavigationToTestCasesPage() {
	   
	  Assert.assertEquals(homeObject.getActualTitle(),"Automation Exercise");
	  
	  homeObject.openTestCases();
	  
	  Assert.assertTrue(testCasesObject.testCasesMsg.getText().contains("Below is the list"));
  }
}
