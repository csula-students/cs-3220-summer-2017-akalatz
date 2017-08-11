package practice;


import java.util.List;

public class Order {

	public enum Status {
		IN_QUEUE, IN_PROGRESS, COMPLETED
	}

	public int id;

	public String customerName;
	public String status;
	

	public Order (int id, String customerName, String status) {
		this.id = id;
		this.customerName = customerName;
		this.status = status;
		
	}
	
	public int getId() {
		return id;
	}



	public String getCustomerName() {
		return customerName;
	}

	public String getStatus() {
		return status;
	}

	
}