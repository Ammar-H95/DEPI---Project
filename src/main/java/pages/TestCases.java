package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestCases extends PageBase{

	public TestCases(WebDriver driver) {
		super(driver);
	}
	@FindBy (xpath = "//*[@id=\"form\"]/div/div[2]/h5/span")
	public WebElement testCasesMsg;
	
}
