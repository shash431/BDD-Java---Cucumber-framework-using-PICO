package dataObjects;

//The edible class is used in order to share a state between steps in cucumber-JVM
//dependency: PicoContainer
public class Edible {
	
	private String foodName;
	private String calories;
	private String addedDate;
	
	public Edible() {}
	
	public Edible(String foodName, String calories, String addedDate) {
		this.foodName=foodName;
		this.calories=calories;
		this.addedDate=addedDate;
	}
	
	public void setfoodName(String newFoodName) {
		this.foodName=newFoodName;
	}

	public String getfoodName() {
		return foodName;
	}

	public void setCalories(String newCalories) {
		this.calories=newCalories;
	}
	
	public String getCalories() {
		return calories;
	}
	
	public void setAddedDate(String newAddedDate) {
		this.addedDate=newAddedDate;
	}
	
	public String getAddedDate() {
		return addedDate;
	}
	
	
	
	
	
}
