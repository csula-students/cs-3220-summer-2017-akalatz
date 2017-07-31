package practice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/admin/orders/edit") 
public class Editadminorderstatus extends HttpServlet {

	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		List<Order> orders = (List<Order>) getServletContext().getAttribute("orders");
		Order editorder = null;
		for (Order order : orders) {
			if (order.getId() == id) {
				editorder = order;
			}
		}
		request.setAttribute("editorder", editorder);
		request.getRequestDispatcher("/editorder.jsp")
			.forward(request, response);
	}


	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		List<Order> orders = (List<Order>) getServletContext().getAttribute("orders");
		
		Order editorder = null;
		int index = -1;
		for (int i = 0; i < orders.size(); i ++) {
			if (orders.get(i).getId() == id) {
				editorder = orders.get(i);
				index = i;
			}
		}
		
		orders.set(index, new Order(
			editorder.getId(),
		editorder.getFood(), editorder.getName(),
			request.getParameter("new_status"), editorder.getDate()
		
		));
		getServletContext().setAttribute("orders", orders);
		response.sendRedirect("http://localhost:8080/practice/orders");
	}
}