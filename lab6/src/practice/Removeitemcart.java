package practice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cart/delete") 
public class Removeitemcart extends HttpServlet {

	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		List<FoodItem> cart = (List<FoodItem>) getServletContext().getAttribute("cart");
		
		int index = -1;
		for (int i = 0; i < cart.size(); i ++) {
			if (cart.get(i).getId() == id) {
				index = i;
			}
		}
		cart.remove(index);
		getServletContext().setAttribute("cart", cart);
		response.sendRedirect("http://localhost:8080/practice/cart");
	}
}