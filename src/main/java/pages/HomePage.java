package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

public class HomePage extends PageBase{
	public HomePage(WebDriver driver) {
		super(driver);
	}
	//Single Responsibility Principal: Each page object should only handle elements and actions related to that specific page.
	//Ensure that any shared functionality (e.g., scrolling) is abstracted out to avoid redundancy.
	
	//Locators as constants to avoid hard coded in case it's going to be changed in the future
    private static final String SIGNUP_LOGIN_LINK = "Signup / Login";
    private static final String DELETE_ACCOUNT_LINK = "Delete Account";
    private static final String CONTACT_US_LINK = "Contact us";
    private static final String TEST_CASES_LINK = "Test Cases";
    private static final String PRODUCTS_LINK = "Products";

    @FindBy(linkText = SIGNUP_LOGIN_LINK)
    private WebElement signUpLoginBtn;

    @FindBy(linkText = DELETE_ACCOUNT_LINK)
    private WebElement deleteAccountBtn;

    @FindBy(linkText = CONTACT_US_LINK)
    private WebElement contactUsBtn;

    @FindBy(linkText = TEST_CASES_LINK)
    private WebElement testCasesBtn;

    @FindBy(partialLinkText = PRODUCTS_LINK)
    private WebElement productsBtn;

    @FindBy(id = "susbscribe_email")
    private WebElement subscribeEmail;

    @FindBy(id = "subscribe")
    private WebElement subscribeBtn;

    @FindBy(className = "alert-success")
	public WebElement subscribeSuccessMsg;

    //method to get the page title
    public String getActualTitle() {
        return driver.getTitle();
    }

    // Scroll utility 
    private void scrollToBottom() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void openRegistrationPage() {
        clickElement(signUpLoginBtn);
    }

    public void deleteAccount() {
        clickElement(deleteAccountBtn);
    }

    public void openContactUs() {
        clickElement(contactUsBtn);
    }

    public void openTestCases() {
        clickElement(testCasesBtn);
    }

    public void openProducts() {
        clickElement(productsBtn);
    }

    public void scrollDown() {
        scrollToBottom();
    }
    //Used try and catch for expecting predicting any error might happen during like timeout or cannot locate the element 
    public void addSubscribeEmail(String email) {
        try {
            subscribeEmail.sendKeys(email);
            subscribeBtn.click();
        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("Failed to subscribe: " + e.getMessage());
        }
    }

    // Utility method for clicking elements
    private void clickElement(WebElement element) {
        try {
            element.click();
        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("Failed to click element: " + e.getMessage());
        }
    }
}