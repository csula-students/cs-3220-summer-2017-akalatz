package homework2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/cart/delete")
public class Deleteitemfromcart extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<CreateFood> cart_items = (List<CreateFood>) getServletContext().getAttribute("cart_items");
		int index = -1;
		for (int i = 0; i < cart_items.size(); i++) {
			if (cart_items.get(i).getId() == id) {
				index = i;
			}
		}
		cart_items.remove(index);
		getServletContext().setAttribute("cart_items", cart_items);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        out.println("<h1> Tom's #1 World Famous Chiliburgers </h1>");
		out.println("<body style='background-color:#E6E6FA;'>");
		out.println(
				"<img  src=http://nebula.wsimg.com/38c7cffac476fc379ec83d5ec7f94485?AccessKeyId=ED591A06CCEC51484249&disposition=0&alloworigin=1 alt= logo /> </br>");
		out.println("<table>");
		out.println("<a href='/Homework2/cart'>Go back to your shopping cart</a>");
		out.println("</br>");
		out.println("</br>");
		out.println("<footer> © 2017 Tom's #1 World Famous Chiliburgers Inc.,All Rights Reserved </footer>");

	}

}