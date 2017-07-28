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

@WebServlet("/admin/orders/edit") 
public class EditAdminOrder extends HttpServlet {

	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		List<Order> orders = (List<Order>) getServletContext().getAttribute("orders");

		Order orderToEdit = null;
		for (Order order : orders) {
			if (order.getId() == id) {
				orderToEdit = order;
			}
		}

		request.setAttribute("orderToEdit", orderToEdit);
		request.getRequestDispatcher("/Editorder.jsp")
			.forward(request, response);
	}


	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		List<Order> orders = (List<Order>) getServletContext().getAttribute("orders");
		
		Order orderToEdit = null;
		int index = -1;
		for (int i = 0; i < orders.size(); i ++) {
			if (orders.get(i).getId() == id) {
				orderToEdit = orders.get(i);
				index = i;
			}
		}
		
		orders.set(index, new Order(
			orderToEdit.getId(),
		orderToEdit.getFood(), orderToEdit.getName(),
			request.getParameter("new_status"), orderToEdit.getDate()
		
		));

		getServletContext().setAttribute("orders", orders);

		response.sendRedirect("http://localhost:8080/Lab4/orders");
	}
}