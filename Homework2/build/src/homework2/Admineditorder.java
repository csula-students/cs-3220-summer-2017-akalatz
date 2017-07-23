package homework2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

@WebServlet(loadOnStartup = 1, urlPatterns = { "/admin/orders/edit" })
public class Admineditorder extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<Order> order_items = (List<Order>) getServletContext().getAttribute("order_items");
		Order leEntry = null;

		for (Order entries : order_items) {
			if (entries.getId() == id) {
				leEntry = entries;
			}
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<body style='background-color:#E6E6FA;'>");
		out.println("<h1>Tom's #1 World Famous Chiliburgers</h1>");
		out.println(
				"<img  src=http://nebula.wsimg.com/38c7cffac476fc379ec83d5ec7f94485?AccessKeyId=ED591A06CCEC51484249&disposition=0&alloworigin=1 alt= logo /> </br>");
		out.println("<form method=\"post\"></br>");
		out.println(
				"Food name: <p><input name='name' type='text' value='" + leEntry.getFood().getName() + "'/></br></p>");
		out.println("Food price:<p> <input price='price' type='text' value='" + leEntry.getFood().getPrice()
				+ "'/></br><p>");
		out.println("<select id =\"status\" name = \"status\">");
		out.println("<option value =\"IN_QUEUE\" selected>" + leEntry.getinqueueStatus() + "</option>");
		out.println("<option value =\"IN_PROGRESS\">" + leEntry.getinprogressStatus() + "</option>");
		out.println("<option value =\"COMPLETED\">" + leEntry.getcompletedstatus() + "</option>");
		out.println("</select>");
		
		
		out.println("</br>");
		out.println("</br>");
		out.println("<button>Edit</button>");
		out.println("</form>");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<Order> order_items = (List<Order>) getServletContext().getAttribute("order_items");
		Order leEntry = null;
		int index = -1;
		for (int i = 0; i < order_items.size(); i++) {
			if (order_items.get(i).getId() == id) {
				leEntry = order_items.get(i);
				index = i;
			}
		}


		order_items.set(index, new Order(leEntry.getId(), leEntry.getFood(), leEntry.getName(), leEntry.getStatus(),
				leEntry.getDate()));
		getServletContext().setAttribute("order_items", order_items);
		

		response.sendRedirect("../orders");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

	}
}