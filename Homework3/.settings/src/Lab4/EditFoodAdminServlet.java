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

@WebServlet("/foods/edit") 
public class EditFoodAdminServlet extends HttpServlet {

	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		List<FoodItem> inventory = (List<FoodItem>) getServletContext().getAttribute("inventory");
		
		FoodItem edititem = null;
		for (FoodItem item : inventory) {
			if (item.getId() == id) {
				edititem = item;
			}
		}
		request.setAttribute("edititem", edititem);
		request.getRequestDispatcher("/EditFood.jsp")
            .forward(request, response);
	}

	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		List<FoodItem> inventory = (List<FoodItem>) getServletContext().getAttribute("inventory");
		
		FoodItem edititem = null;
		int index = -1;
		for (int i = 0; i < inventory.size(); i ++) {
			if (inventory.get(i).getId() == id) {
				edititem = inventory.get(i);
				index = i;
			}
		}
		
		inventory.set(index, new FoodItem(
			edititem.getId(),
			request.getParameter("name"),
			request.getParameter("description"),
			Double.parseDouble(request.getParameter("price"))
		));
		
		getServletContext().setAttribute("inventory", inventory);

		response.sendRedirect("../foods");
	}
}