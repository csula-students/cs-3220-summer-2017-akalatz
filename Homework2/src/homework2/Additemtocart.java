package homework2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;



@WebServlet("/menu/add")
public class Additemtocart extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<CreateFood> entries = (List<CreateFood>) getServletContext().getAttribute("entries");
		CreateFood addEntry = null;
		for (CreateFood entry : entries) {
			if (entry.getId() == id) {
				addEntry = entry;
			}
		}
        response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1> Tom's #1 World Famous Chiliburgers </h1>");
		out.println("<body style='background-color:#E6E6FA;'>");
		out.println(
				"<img  src=http://nebula.wsimg.com/38c7cffac476fc379ec83d5ec7f94485?AccessKeyId=ED591A06CCEC51484249&disposition=0&alloworigin=1 alt= logo /> </br>");

		List<CreateFood> cart_items = (List<CreateFood>) getServletContext().getAttribute("cart_items");

		cart_items.add(new CreateFood(id, addEntry.getName(), addEntry.getPrice(), addEntry.getDescription()

		));

		getServletContext().setAttribute("cart_items", cart_items);
		out.println("<a href='/Homework2/menu'>Go back to add something else</a>");
		out.println("<a href='/Homework2/cart'>Check your shopping cart</a>");
		out.println("</br>");
		out.println("</br>");
	    out.println("<footer> © 2017 Tom's #1 World Famous Chiliburgers Inc.,All Rights Reserved </footer>");
        out.println("</body>");
	

	}

}