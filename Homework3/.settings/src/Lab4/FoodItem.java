package Lab4;

public class FoodItem {
	public final int id;
	public final String name;
	public final String description;
	public final double price;

	public FoodItem (int id, String name, String description, double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}


	public double getPrice() {
		return price;
	}
}