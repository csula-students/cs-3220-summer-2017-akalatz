package practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/menu/add")
public class Additemtocart extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		

			int id = Integer.parseInt(request.getParameter("id"));

			InventoryDAO dao = new InventoryDAO();
			FoodItem itemToAdd = dao.get(id).get();

			List<FoodItem> cart = (List<FoodItem>) getServletContext().getAttribute("cart");
			PrintWriter out = response.getWriter();
			
			for (FoodItem item : cart) {
				if (item.getId() == itemToAdd.getId()) {
					itemToAdd = item;
				}
			}
			cart.add(itemToAdd);

			getServletContext().setAttribute("cart", cart);

			response.sendRedirect("../cart");
		}
	}
