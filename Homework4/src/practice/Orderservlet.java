package practice;

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

@WebServlet("/cart/orders") 
public class Orderservlet extends HttpServlet {

	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FoodItem> cart = (List<FoodItem>) getServletContext().getAttribute("cart");


		OrderDAO dao = new OrderDAO();
	

		cart = new ArrayList<>();

		getServletContext().setAttribute("cart", cart);
		

		response.sendRedirect("http://localhost:8080/practice/orders");
	}
}