package practice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/admin/orders/delete") 
public class deleteorderadmin extends HttpServlet {

	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		OrderDAO dao = new OrderDAO();
		dao.delete(id);

		response.sendRedirect("http://localhost:8080/practice/orders");
	}
}