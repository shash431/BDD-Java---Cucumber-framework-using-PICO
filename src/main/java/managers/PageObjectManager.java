package managers;


import org.openqa.selenium.WebDriver;

import pageObjects.*;
 
// PageObjectManager class provides the page objects
public class PageObjectManager {
 
	private WebDriver driver;
	private EdiblesPage ediblesPage;
	private LoginPage loginPage;
	private HomePage homePage;
	private ProfilePage profilePage;
	private RegistrationPage registrationPage;
	private MenuPage menuPage;

 
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;	
	}
 
	public HomePage getHomePage(){
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}
 
	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}
 
	public ProfilePage getProfilePage() {
		return (profilePage == null) ? profilePage = new ProfilePage(driver) : profilePage;
	}

	public EdiblesPage getEdiblesPage() {
		return (ediblesPage == null) ? ediblesPage = new EdiblesPage(driver) : ediblesPage;
	}

	public RegistrationPage getRegistrationPage() {
		return (registrationPage == null) ? registrationPage = new RegistrationPage(driver) : registrationPage;
	}

	public MenuPage getMenuPage() {
		return (menuPage == null) ? menuPage = new MenuPage(driver) : menuPage;
	}
}