package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	@FindBy(id="email-input")
	private WebElement userEmail;
	  
	@FindBy(id="password-input")
	private WebElement userPassword;
	  
	@FindBy(className="button")
	private WebElement loginButton;
	 
	@FindBy(id="login")
	private WebElement loginForm;
	
	@FindBy(xpath="//div[@class='flash']")
	private WebElement loginFailedMessage;
	
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void userLogin(String usermail, String password){
		userEmail.sendKeys(usermail);
		userPassword.sendKeys(password);
		loginButton.click();
	}
	
	public String GetLoginFailedMessage(){
		return loginFailedMessage.getText().toLowerCase();
	}
}
