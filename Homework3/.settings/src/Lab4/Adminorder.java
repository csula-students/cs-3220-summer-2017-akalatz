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

@WebServlet("/admin/orders") 
public class Adminorder extends HttpServlet {

	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Order> orders = (List<Order>) getServletContext().getAttribute("orders");
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/OrderAdmin.jsp").forward(request, response);
	}
}