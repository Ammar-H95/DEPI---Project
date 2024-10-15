package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ContactUs extends PageBase{

	public ContactUs(WebDriver driver) {
		super(driver);
	}
	
	 @FindBy(xpath = "//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2")
	    public WebElement getInTouchMsg;

	    @FindBy(name = "name")
	    private WebElement nameTxt;

	    @FindBy(name = "email")
	    private WebElement emailTxt;

	    @FindBy(name = "subject")
	    private WebElement subjectTxt;

	    @FindBy(id = "message")
	    private WebElement messageTxt;

	    @FindBy(className = "form-control")
	    private WebElement uploadFileBtn;

	    @FindBy(css = "input.btn.btn-primary.pull-left.submit_form")
	    private WebElement submitBtn;

	    @FindBy(xpath = "//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]")
	    public WebElement submitSuccessMsg;

	    @FindBy(linkText = "Home")
	    private WebElement homeBtn;
	    
	    private final String filePath = "test.png";
	
	public void usingContactUs(String name,String email,String subject,String message) throws AWTException, InterruptedException {
	
        fillContactForm(name, email, subject, message);

        useRobotToUploadFile(filePath);
        
		//here we are handling the alert pop up
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
		
	}
	 private void fillContactForm(String name, String email, String subject, String message) {
	        nameTxt.sendKeys(name);
	        
	        emailTxt.sendKeys(email);
	        
	        subjectTxt.sendKeys(subject);
	        
	        messageTxt.sendKeys(message);
	    }
	 private void useRobotToUploadFile(String filePath) throws AWTException, InterruptedException {
	        uploadFileBtn.click();  // Trigger file dialog
			//robo class so we can upload file by copy and paste the name of the file 
	        Robot robo = new Robot();
	        
	        StringSelection fileName = new StringSelection(filePath);
	        
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileName, null);
			//we used toolkit so we can copy the file to clip board
	        
			//robo class to use the key events like hold control+v

	        robo.keyPress(KeyEvent.VK_CONTROL);
	        robo.keyPress(KeyEvent.VK_V);
			//we have to release the action we made 

	        robo.keyRelease(KeyEvent.VK_CONTROL);
	        robo.keyRelease(KeyEvent.VK_V);
			//same for the Enter key

	        robo.keyPress(KeyEvent.VK_ENTER);
	        robo.keyRelease(KeyEvent.VK_ENTER);

	        Thread.sleep(1000);  // Replace with WebDriverWait if possible
	    }
	 
	public void gotHome() {
		homeBtn.click();
		
	}
	
}
