package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {
	
	WebDriver driver;

	
	@FindBy(xpath="//li[@data-ui='logout-btn']")
	private WebElement logoutBtn;

	
	@FindBy(xpath="//a[text()='Edibles']")
	private WebElement ediblesBtn;

	@FindBy(xpath="//a[text()='Profile']")
	private WebElement profileBtn;

	@FindBy(xpath="//header[@data-ui='greeting']")
	private WebElement greeting;

	
	public MenuPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void LogOut() {
		logoutBtn.click();
	}
	
	public void ClickEdibles() {
		ediblesBtn.click();
	}

	public void ClickProfile() {
		profileBtn.click();
	}

	public String getGreetingsText() {
		return greeting.getText();
	}

}
