package practice;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(loadOnStartup = 1, urlPatterns = { "/admin/foods" })
public class Inventory extends HttpServlet {

	public void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		InventoryDAO dao = new InventoryDAO();
        request.setAttribute("list", dao.list());
        request.getRequestDispatcher("/inventory.jsp")
            .forward(request, response);
    }
}