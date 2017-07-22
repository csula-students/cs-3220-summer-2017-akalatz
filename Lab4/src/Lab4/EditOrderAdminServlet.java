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

@WebServlet("/orders/edit") 
public class EditOrderAdminServlet extends HttpServlet {

	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		List<Order> orders = (List<Order>) getServletContext().getAttribute("orders");

		Order orderedit = null;
		for (Order order : orders) {
			if (order.getId() == id) {
				orderedit = order;
			}
		}

		request.setAttribute("orderedit", orderedit);
		request.getRequestDispatcher("/Editorder.jsp")
			.forward(request, response);
	}


	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		List<Order> orders = (List<Order>) getServletContext().getAttribute("orders");
		
		Order orderedit = null;
		int index = -1;
		for (int i = 0; i < orders.size(); i ++) {
			if (orders.get(i).getId() == id) {
				orderedit = orders.get(i);
				index = i;
			}
		}
		
		orders.set(index, new Order(
			orderedit.getId(),
			orderedit.getFood(),
			orderedit.getName(),
			request.getParameter("status"),
			orderedit.getDate()
		));

		getServletContext().setAttribute("orders", orders);

		response.sendRedirect("../orders");
	}
}
		