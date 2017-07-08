package Lab3;

public class CreateFood {
	public final int id;
	public final String price ;
	public final String name;
	public final String description;

	public CreateFood(int id ,String name ,String  price, String description) {
		this.id=id;
		this.price = price;
		this.name = name;
		this.description = description;
	}

	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	
	}
	
	public String getPrice() {
		return price;
	}

	
	

	public String getDescription() {
		return description;
	}
}