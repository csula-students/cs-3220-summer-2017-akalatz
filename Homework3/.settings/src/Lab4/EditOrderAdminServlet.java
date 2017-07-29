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

		Order edititem = null;
		for (Order order : orders) {
			if (order.getId() == id) {
				edititem = order;
			}
		}

		request.setAttribute("editorder", edititem);
		request.getRequestDispatcher("/Editorder.jsp")
			.forward(request, response);
	}


	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		List<Order> orders = (List<Order>) getServletContext().getAttribute("orders");
		
		Order edititem = null;
		int index = -1;
		for (int i = 0; i < orders.size(); i ++) {
			if (orders.get(i).getId() == id) {
				edititem = orders.get(i);
				index = i;
			}
		}
		
		orders.set(index, new Order(
			edititem.getId(),
			edititem.getFood(),
			edititem.getName(),
			request.getParameter("status"),
			edititem.getDate()
		));

		getServletContext().setAttribute("orders", orders);

		response.sendRedirect("../orders");
	}
}
		