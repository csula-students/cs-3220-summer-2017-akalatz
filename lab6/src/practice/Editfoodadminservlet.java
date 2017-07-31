package practice;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/admin/foods/edit")
public class Editfoodadminservlet extends HttpServlet {

		public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			int id = Integer.parseInt(request.getParameter("id"));
			InventoryDAO dao = new InventoryDAO();
			FoodItem edititem = dao.get(id).get();
			request.setAttribute("edititem", edititem);
			request.getRequestDispatcher("/EditFood.jsp").forward(request, response);
		}
        
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  FoodItem updateentry = new  FoodItem(
			Integer.parseInt(request.getParameter("id")),
			request.getParameter("name"),
			request.getParameter("description"),
			Double.parseDouble(request.getParameter("price"))
			);

		InventoryDAO dao = new InventoryDAO();
		dao.update(updateentry);
		response.sendRedirect("http://localhost:8080/practice/admin/foods");
	}
}
      
	


