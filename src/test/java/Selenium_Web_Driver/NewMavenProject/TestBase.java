package Selenium_Web_Driver.NewMavenProject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
	WebDriver driver;
	String baseURL = "https://automationexercise.com/";

	@BeforeTest
	public void openWebsite() {
		driver = new ChromeDriver();
		// we wanted to maximize the window so all elements will be visible
		driver.manage().window().maximize();
		// we used get instead of navigate to as get waits for all elements to be loaded
		driver.get(baseURL);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@AfterTest
	public void closeWebsite() {
		driver.close();
	}

}
