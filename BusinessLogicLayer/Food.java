package BusinessLogicLayer;

import java.io.Serializable;

public class Food implements Serializable {
    
	int mealID;	//ID of the meal type
	String mealType;	//States whether it is adults meal, or kids meal, etc
	String mealChoice;	//Sub devision of mealtype eg. Hamburgers and chips
	double mealPrice;	//price of the mealChoice for 1 Person

	public int getMealID() {
		return mealID;
	}

	public void setMealID(int mealID) {
		this.mealID = mealID;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public double getMealPrice() {
		return mealPrice;
	}

	public void setMealPrice(double mealPrice) {
		this.mealPrice = mealPrice;
	}

	public String getMealChoice() {
		return mealChoice;
	}

	public void setMealChoice(String mealChoice) {
		this.mealChoice = mealChoice;
	}

	public Food(int mealID, String mealType, String mealChoice, double mealPrice) {
		this.mealID = mealID;
		this.mealType = mealType;
		this.mealChoice = mealChoice;
		this.mealPrice = mealPrice;
	}

}
