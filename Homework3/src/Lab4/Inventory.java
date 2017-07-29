package Lab4;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(loadOnStartup = 1, urlPatterns = { "/admin/foods" })
public class Inventory extends HttpServlet {

	public void init() {
		List<FoodItem> inventory = new ArrayList<>();
		inventory.add(new FoodItem(0, "CheeseBurger", "Tomato,letuce,beef,ban", 7.8));
		inventory.add(new FoodItem(1, "ChiliFries", "French fries,chili,cheese", 6.9));
		getServletContext().setAttribute("inventory", inventory);
	}
	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FoodItem> inventory = (List<FoodItem>) getServletContext().getAttribute("inventory");
		request.setAttribute("inventory", inventory);
		request.getRequestDispatcher("/inventory.jsp")
            .forward(request, response);
	}
}