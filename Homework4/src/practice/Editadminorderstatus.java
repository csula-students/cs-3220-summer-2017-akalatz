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
	
	    OrderDAO dao = new OrderDAO();
		Order orderToEdit = dao.get(id).get();

		request.setAttribute("orderToEdit", orderToEdit);
		request.getRequestDispatcher("/editorder.jsp")
			.forward(request, response);
	}


	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
	
		OrderDAO dao = new OrderDAO();

		Order orderToUpdate = new Order(
												dao.get(id).get().getId(),
												dao.get(id).get().getCustomerName(),
												request.getParameter("new_status")
												);
		dao.update(orderToUpdate);

		response.sendRedirect("http://localhost:8080/practice/orders");
	}
}