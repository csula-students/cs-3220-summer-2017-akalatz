package homework2;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 1, urlPatterns = { "/admin/orders" })
public class Adminorderstatus extends HttpServlet {
	public void init() {

		List<Order> order_items = new ArrayList<>();
		getServletContext().setAttribute("order_items", order_items);

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<Order> order_items = (List<Order>) getServletContext().getAttribute("order_items");
		response.setContentType("text/html");
        out.println("<h1> Tom's #1 World Famous Chiliburgers </h1>");
		out.println("<body style='background-color:#E6E6FA;'>");
		out.println(
				"<img  src=http://nebula.wsimg.com/38c7cffac476fc379ec83d5ec7f94485?AccessKeyId=ED591A06CCEC51484249&disposition=0&alloworigin=1 alt= logo /> </br>");		
		out.println("<h2> Order Statuses </h2>");		
		out.println("<table>");
	
     		for (Order order : order_items){	
				out.println(
						"<tr>" + "<td>" + order.getFood().getName() + " </td>" +
			            "<td>" + order.getFood().getPrice() + "</td>" + 
						"<td>"+ order.getStatus().toString() + "</td>" + 
						"<td>"+ order.getDate() + "</td>" +
					    "<td><a href='orders/edit?id=" + order.getId() + "'>Edit</a>" + "</td>" +  
						"</tr>");
		                                   }
		out.println("</table>");
		out.println("</br>");
		out.println("<a href='food'>go back to your items</a>");
		out.println("</br>");
		out.println("<footer> © 2017 Tom's #1 World Famous Chiliburgers Inc.,All Rights Reserved </footer>");
		out.println("</body>");
	}
}
