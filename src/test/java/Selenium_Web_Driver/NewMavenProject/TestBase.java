package Selenium_Web_Driver.NewMavenProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
	WebDriver driver;
	String baseURL = "https://automationexercise.com/";
	
  @BeforeClass
  public void openWebsite() {
	  driver = new ChromeDriver();
	  driver.navigate().to(baseURL);
	  
  }

  @AfterClass
  public void closeWebsite() {
	  driver.quit();
  }

}
