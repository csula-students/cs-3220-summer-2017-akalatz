package Lab4;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup=1, urlPatterns={"/orders"}) 
public class orderstatus extends HttpServlet {

	public void init() {
		List<Order> orders = new ArrayList<>();
		FoodItem  entry = new FoodItem(0, "Cheeseburger", "tomato,letuce,beef", 2.5);
		List<FoodItem> food = new ArrayList<>();
		food.add(entry);
		orders.add(new Order(0, food, "Apostolos", "IN_PROGRESS", new Date(7, 20, 17)));

		getServletContext().setAttribute("orders", orders);
	}
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Order> orders = (List<Order>) getServletContext().getAttribute("orders");
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/OrderStatus.jsp")
            .forward(request, response);
	}
}