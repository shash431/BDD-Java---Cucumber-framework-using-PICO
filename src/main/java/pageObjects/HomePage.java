package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import managers.FileReaderManager;

public class HomePage {

	WebDriver driver;
	
	@FindBy(linkText="LOGIN")
	private WebElement loginBtn;

	@FindBy(linkText="REGISTER")
	private WebElement registerBtn;


	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateTo_HomePage() {
		 driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}
	
	public void click_LogIn() {
		loginBtn.click();
	}
	
	public void click_Register() {
		registerBtn.click();
	}
	
	public WebElement getRegisterBtn() {
		return registerBtn; 
	}	
	
	public WebElement getLoginBtn() {
		return loginBtn; 
	}
}
