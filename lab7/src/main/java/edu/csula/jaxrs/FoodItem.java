package edu.csula.jaxrs;

public class FoodItem {
	public final int id;
	public final String foodName;
	public final String description;
	public final double price;


	
	public FoodItem() {
		this.id = 0;
		this.foodName = "";
		this.description = "";
		this.price = 0;
	}
	public FoodItem (int id, String foodName, String description, double price) {
		this.id = id;
		this.foodName = foodName;
		this.description = description;
		this.price = price;
	
	}
	
	public int getId() {
		return id;
	}

	public String getFoodName() {
		return foodName;
	}

	public String getDescription() {
		return description;
	}


	public double getPrice() {
		return price;
	}
	
}