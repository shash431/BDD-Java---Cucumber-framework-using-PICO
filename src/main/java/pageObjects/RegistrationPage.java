package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegistrationPage {
	 WebDriver driver;

	 @FindBy(id="name-input")
	 private WebElement userName;
	 
	 @FindBy(id="email-input")
	 private WebElement email;
	 
	 @FindBy(id="password-input")
	 private WebElement password;
	 
	 @FindBy(id="password-confirmation-input")
	 private WebElement confirmPassword;
	 
	 @FindBy(xpath="//input[@value='Join']")
	 private WebElement joinBtn;
	 
	 @FindBy(id="registration")
	 private WebElement registrationForm;
	 
	
	 @FindBy(xpath="//div[text()='Registration failed. Please try again']")
	 private WebElement registrationFailedMessage;
	 
	public RegistrationPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void RegisterNewUser(String user_name,String user_mail, String user_password, String user_confirmpassword) {
		  userName.sendKeys(user_name);
		  email.sendKeys(user_mail);
		  password.sendKeys(user_password);
		  confirmPassword.sendKeys(user_confirmpassword);
		  joinBtn.click();
	}
	
	public boolean registrationFailed(){
			if (registrationFailedMessage.isDisplayed())
				return true;
			else
				return false;
	}
	
	
}
