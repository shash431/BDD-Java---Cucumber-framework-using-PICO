package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class EdiblesPage {
	

	WebDriver driver;
	
	@FindBy(xpath="//button[@data-ui='add-btn']")
	private WebElement addBtn;

	@FindBy(xpath="//button[@data-ui='save-btn']")
	private WebElement saveBtn;

	@FindBy(xpath="//button[@data-ui='delete-btn']")
	private  List<WebElement> deleteButtons;
	
	@FindBy(xpath="//input[@name='name']")
	private WebElement ediblesName;
	
	@FindBy(xpath="//input[@name='calories']")
	private WebElement ediblesCalories;
	
	@FindBy(xpath="//input[@name='created_at']")
	private WebElement ediblesDate;

	@FindBy(xpath="//*/table")
	private WebElement tableEdibles;
	
	@FindBy(xpath="//button[@data-ui='edit-btn']")
	private List<WebElement> editButtons;
	
	@FindBy(xpath="//div[@data-ui='calory-box']")
	private WebElement caloriesBox;

	@FindBy(xpath="//input[@name='endDate']")
	private WebElement endDateFilter;

	@FindBy(xpath="//input[@name='startDate']")
	private WebElement startDateFilter;

	@FindBy(xpath="//button[text()='Reset filter']")
	public WebElement resetFilterBtn;

	@FindBy(xpath="//button[text()='Filter']")
	private WebElement FilterBtn;

	@FindBy(xpath="//button[text()='Filter by date & time interval']")
	private WebElement FilterByDateBtn;
	
	@FindBy(xpath="//div[text()='Unprocessable Entity']")
	private WebElement unprocessableEntityErrorMessage;

	public EdiblesPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void ResetByDateFilter()
	{
		resetFilterBtn.click();
	}
	public void FilterByDate(String startDate, String endDate) throws InterruptedException
	{	
			FilterByDateBtn.click();
			Thread.sleep(4000);
			startDateFilter.clear();
			startDateFilter.sendKeys(startDate);
			endDateFilter.clear();
			endDateFilter.sendKeys(endDate);
			FilterBtn.click();	
	}
	
	public Boolean isCaloryBoxGreen() {
		String res = caloriesBox.getAttribute("class");
		if (res.contains("red")){
			return false;
		}else {
				return true;
			}			
	}


	public void addEdible(String foodName, String calories, String dateAdded) {
		
		addBtn.click();
		ediblesName.sendKeys(foodName);
		ediblesCalories.sendKeys(calories);
		
		
		String[] dateparts = dateAdded.split("-");
		if (dateparts.length>1) {
			ediblesDate.sendKeys(dateparts[0]);
			ediblesDate.sendKeys(Keys.TAB);
			ediblesDate.sendKeys(dateparts[1]);
		}
		saveBtn.click();
	}
	
	public int isthereEdibleOnTable(String strSearch){
		List<WebElement> rows = tableEdibles.findElements(By.tagName("tr"));
		
		for(int i=1;i<rows.size(); i++) {
			String rowStr = rows.get(i).getText();
			System.out.println(rowStr);
			if (rowStr.contains(strSearch))
				return i;
		}
		return -1;
	}
	
	
	public void DeleteEdible(String edibleName) {
		int row = isthereEdibleOnTable(edibleName);
		deleteButtons.get(row-1).click();
	}
	
	
	public int EditEdible(String edibleName, String newFoodName, String newCalories, String newDate){
		int row = isthereEdibleOnTable(edibleName);
	
		editButtons.get(row-1).click();	
		ediblesName.clear();
		ediblesName.sendKeys(newFoodName);
		ediblesCalories.clear();
		ediblesCalories.sendKeys(newCalories);
		
		String[] dateparts = newDate.split("-");
		if (dateparts.length>1) {
			ediblesDate.sendKeys(dateparts[0]);
			ediblesDate.sendKeys(Keys.TAB);
			ediblesDate.sendKeys(dateparts[1]);
		}
		saveBtn.click();
		return row;
	}
	
	
	public String GetTableCellValue(int row, String columnName) {
		
		if (columnName.equals("Name")){
			  return driver.findElement(By.xpath("//table/tbody/tr["+row+"]/td["+1+"]")).getText();
		}else if (columnName.equals("Calories")) {
			  return driver.findElement(By.xpath("//table/tbody/tr["+row+"]/td["+2+"]")).getText();	 	
		} else {
		  	return driver.findElement(By.xpath("//table/tbody/tr["+row+"]/td["+3+"]")).getText();
		}			
	}
	
	public boolean UnprocessableEntity(){
		if (unprocessableEntityErrorMessage.isDisplayed())	
			return true;
		else
			return false;
	}
	
}

