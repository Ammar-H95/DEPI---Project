package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteAccount extends PageBase{

	public DeleteAccount(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
	public WebElement deleteSuccessMsg;
	
	@FindBy(css = "button.btn.btn-default")
	 private WebElement continueAfterDeleteBtn;
	
	public void continueAfterDelete() {
		continueAfterDeleteBtn.click();
	}
}
