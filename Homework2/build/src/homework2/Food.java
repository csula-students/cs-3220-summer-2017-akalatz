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




@WebServlet(loadOnStartup = 1, urlPatterns = { "/admin/food" })
public class Food extends HttpServlet {
	public void init() {
		// init the application scope to have pre-set values
		List<CreateFood> entries = new ArrayList<>();
		entries.add(new CreateFood(entries.size(), "CheeseBurger", "$8.89","Ban,beef,cheese,letuce,tomato"));
		entries.add(new CreateFood(entries.size(), "Chilifries", "$9.89","French fries,chili,cheese"));
		getServletContext().setAttribute("entries", entries);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			PrintWriter out = response.getWriter();
			List<CreateFood> entries = (List<CreateFood>) getServletContext().getAttribute("entries");
			// tell browser this is html document
			response.setContentType("text/html");

			out.println("<head>");
			out.println("<style>body { " +
			"}</style>");
			out.println("</head>");
			out.println("<h1> Tom's #1 World Famous Chiliburgers </h1>");
			
			out.println("<body style='background-color:#E6E6FA;'>");
			out.println(
					"<img  src=http://nebula.wsimg.com/38c7cffac476fc379ec83d5ec7f94485?AccessKeyId=ED591A06CCEC51484249&disposition=0&alloworigin=1 alt= logo /> </br>");
			
			out.println("<table>");
			out.println("<h1> Food Items </h1>");
	
		for (CreateFood entry : entries) {
			out.println(
					"<tr>" + 
							"<td>" + entry.getName() + " </td>" + 
							"<td>" + entry.getPrice() + "</td>" +
							"<td>" + entry.getDescription() + "</td>" +
							"<td><a href='food/edit?id=" + entry.getId() + "'>Edit</a> " + 
							"<a href='food/delete?id=" + entry.getId() + "'>Delete</a></td>" +
						"</tr>"
					);
				}
		out.println("</table>");
		out.println("<a href='food/create'>Add Food</a>");
		out.println("</br>");
		out.println("<a href='../menu'>Check your Menu</a>");
		out.println("</br>");
		out.println("<a href='orders'>Manage your order</a>");
		out.println("</br>");
		out.println("</br>");
		out.println("<footer> © 2017 Tom's #1 World Famous Chiliburgers Inc.,All Rights Reserved </footer>");
	}
}