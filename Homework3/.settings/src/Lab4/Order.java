package Lab4;

import java.util.List;
import java.util.Date;

import java.util.Date;
import java.util.List;


public class Order {

	public enum Status {
		IN_QUEUE, IN_PROGRESS, COMPLETED
	}

	public final int id;
	public final List<FoodItem> food;
	public final String name;
	public String status;
	public final Date date;

	public Order(int id, List<FoodItem> food, String name, String status, Date date) {
		this.id = id;
		this.food = food;
		this.name = name;
		this.status = status;
		this.date = date;

	}

	public int getId() {
		return id;
	}

	public List<FoodItem> getFood() {
		return food;
	}

	public String getName() {
		return name;
	}

	public String getinqueueStatus() {
		return Status.IN_QUEUE.toString();
	}

	public String getinprogressStatus() {
		return Status.IN_PROGRESS.toString();
	}

	public String getcompletedstatus() {
		return Status.COMPLETED.toString();
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public Date getDate() {
		return date;
	}

}