package pages;



import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends PageBase{
	
	
	
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	// Constants to avoid redundancy as the 1st part is the same in each xpath element
    private static final String FORM_PREFIX = "//*[@id=\"form\"]/div/div/div";
    
    @FindBy (xpath = FORM_PREFIX + "/div[1]/h2/b")
	public WebElement accountInfo;
    
    @FindBy (xpath = FORM_PREFIX + "/div/h2/b")
	public WebElement enterAccountInfo ; 
    
    @FindBy(xpath = FORM_PREFIX + "[3]/div/h2")
    public WebElement newUserSignupMsg;

    @FindBy(xpath = FORM_PREFIX + "[1]/div/h2")
    public WebElement loginMsg;

    @FindBy(xpath = FORM_PREFIX + "[3]/div/form/p")
    public WebElement existedEmailErrorMsg;

    @FindBy(xpath = FORM_PREFIX + "[1]/div/form/p")
    public WebElement wrongCredentialsErrorMsg;
    
    @FindBy( xpath = FORM_PREFIX + "/h2/b")
	 public WebElement successMessage;
    
    @FindBy(xpath = FORM_PREFIX + "[3]/div/form/button")
    private WebElement signUpBtn;

    @FindBy(name = "name")
    private WebElement nameText;

    @FindBy (name="email")
	WebElement loginEmail;
    
    @FindBy (name="password")
	WebElement loginPassword;
    
    @FindBy (name="email")
	List<WebElement> emailText;	

    @FindBy(id = "id_gender1")
    private WebElement genderRadioBtn;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "days")
    private WebElement daysList;

    @FindBy(id = "months")
    private WebElement monthsList;

    @FindBy(id = "years")
    private WebElement yearsList;

    @FindBy(id = "newsletter")
    private WebElement newsLetterCheckBox;

    @FindBy(id = "optin")
    private WebElement specialOfferCheckBox;

    @FindBy(id = "first_name")
    private WebElement firstName;

    @FindBy(id = "last_name")
    private WebElement lastName;

    @FindBy(id = "company")
    private WebElement company;

    @FindBy(id = "address1")
    private WebElement address1;

    @FindBy(id = "address2")
    private WebElement address2;

    @FindBy(id = "country")
    private WebElement countryDropDownMenu;

    @FindBy(id = "state")
    private WebElement state;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "zipcode")
    private WebElement zipCode;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumber;

    @FindBy(css = "button.btn.btn-default")
    private WebElement createAccountBtn;

    @FindBy(linkText = "Continue")
    private WebElement continueBtn;

    @FindBy(css = "button.btn.btn-default")
    private WebElement loginBtn;

    @FindBy(partialLinkText = "Logged in")
    public WebElement loggedInMsg;

    @FindBy(linkText = "Logout")
    private WebElement logOutBtn;
    

    // New user sign-up method
    public void newUserSignUp(String name, String email) {
        try {
            nameText.sendKeys(name);
            emailText.get(1).sendKeys(email);
            signUpBtn.click();
        } catch (NoSuchElementException e) {
            System.out.println("Error during sign-up: " + e.getMessage());
        }
    }

    // User registration method with form input
    public void userCanRegister(String password, String day, String month, String year, String firstName, String lastName, String company, 
                                String address1, String address2, String country, String state, String city, String zipCode, String mobileNumber) {
        genderRadioBtn.click();
        this.password.sendKeys(password);
        
        selectDropdownValue(daysList, day);
        selectDropdownValue(monthsList, month);
        selectDropdownValue(yearsList, year);
        
        newsLetterCheckBox.click();
        specialOfferCheckBox.click();
        
        fillTextField(this.firstName, firstName);
        fillTextField(this.lastName, lastName);
        fillTextField(this.address1, address1);
        fillTextField(this.address2, address2);
        fillTextField(this.state, state);
        fillTextField(this.city, city);
        fillTextField(this.zipCode, zipCode);
        fillTextField(this.mobileNumber, mobileNumber);

        selectDropdownValue(countryDropDownMenu, country);
        
        createAccountBtn.click();
    }

    public void loginWithValidCredentials(String email, String password) {
        loginEmail.sendKeys(email);
        loginPassword.sendKeys(password);
        loginBtn.click();
    }

    public void logOut() {
        logOutBtn.click();
    }

    // Utility method to select drop down by value to reduce duplication and make the code cleaner.
    private void selectDropdownValue(WebElement dropdownElement, String value) {
        new Select(dropdownElement).selectByValue(value);
    }

    // Utility method to fill text fields to reduce duplication and make the code cleaner.
    private void fillTextField(WebElement element, String value) {
        try {
            element.clear();
            element.sendKeys(value);
        } catch (NoSuchElementException e) {
            System.out.println("Error filling text field: " + e.getMessage());
        }
    }

    // Continue button click
    public void continueAccount() {
        continueBtn.click();
    }
}