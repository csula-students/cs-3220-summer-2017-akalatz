package homework2;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* Shopping cart which guest can see */

@WebServlet(loadOnStartup = 1, urlPatterns = { "/cart" })
public class Cart extends HttpServlet {

	public void init() {
		List<CreateFood> cart_items = new ArrayList<>();
		getServletContext().setAttribute("cart_items", cart_items);

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<CreateFood> entries = (List<CreateFood>) getServletContext().getAttribute("entries");
		response.setContentType("text/html");
		out.println("<head>");
		out.println("<style>body { " + "}</style>");
		out.println("</head>");
		out.println("<h1> Tom's #1 World Famous Chiliburgers </h1>");
		out.println("<body style='background-color:#E6E6FA;'>");
		out.println(
				"<img  src=http://nebula.wsimg.com/38c7cffac476fc379ec83d5ec7f94485?AccessKeyId=ED591A06CCEC51484249&disposition=0&alloworigin=1 alt= logo /> </br>");
		out.println("<table>");
		out.println("<h1> Shopping cart </h1>");
		List<CreateFood> cart_items = (List<CreateFood>) getServletContext().getAttribute("cart_items");
			out.println("<table>");
			for (CreateFood entry : cart_items) {

				out.println(
						"<tr>" + "<td>" + entry.getName() + " </td>" +
			            "<td>" + entry.getPrice() + "</td>" + 
						"<td>"+ entry.getDescription() + "</td>" + 
						"<td><a href='cart/delete?id=" + entry.getId() + "'>Remove item to cart</a> </td>" +
				        "</tr>");

			out.println("</table>");
			
			out.println("<form method=\"post\">");
			out.println("<button>Confirm Your order</button>");
			out.println("</form>");
			out.println("</br>");
			out.println("</br>");
		    out.println("<footer> © 2017 Tom's #1 World Famous Chiliburgers Inc.,All Rights Reserved </footer>");
            out.println("</body>");
	}	

}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Order> order_items = (List<Order>) getServletContext().getAttribute("order_items");
		List<CreateFood> cart_items = (List<CreateFood>) getServletContext().getAttribute("cart_items");

		for (CreateFood entry : cart_items) {

			order_items
					.add(new Order(order_items.size(), entry, request.getParameter("name"), "IN_PROGRESS", new Date()));
			getServletContext().setAttribute("order_items", order_items);
		}

		cart_items.clear();

		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
       out.println("<h1> Tom's #1 World Famous Chiliburgers </h1>");
		
		out.println("<body style='background-color:#E6E6FA;'>");
		out.println(
				"<img  src=http://nebula.wsimg.com/38c7cffac476fc379ec83d5ec7f94485?AccessKeyId=ED591A06CCEC51484249&disposition=0&alloworigin=1 alt= logo /> </br>");
		
		out.println("<h1> Confirmed</h1>");
		out.println("<button onclick=\"location.href='orders'\">Check your Orders</button>");
		
	}

	
	
}