package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
	WebDriver driver;

	@FindBy(id="max-daily-calories")
	private WebElement profileMaxCalories;
	 
	
	
	public ProfilePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void SetMaxCalories(String MaxCalories) {
		profileMaxCalories.clear();
		profileMaxCalories.sendKeys(MaxCalories);
	}
}
