package midtern;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





@WebServlet(loadOnStartup = 1, urlPatterns = { "/random" })

public class RandomList extends HttpServlet {
	public void init() {
		// init the application scope to have pre-set values
		List<restaurant> entries = new ArrayList<>();
		entries.add(new restaurant(entries.size(), "students 25 restaurant ", "http://www.tomschiliburgers.com/menu.html" , 4, 5));
		entries.add(new restaurant(entries.size(), "student 25", "http://www.tomschiliburgers.com/menu.html" ,6,7));
		getServletContext().setAttribute("entries", entries);
	}

	public void doGet( HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<restaurant> entries = (List<restaurant>) getServletContext().getAttribute("entries");
		// tell browser this is html document
		response.setContentType("text/html");

		out.println("<head>");
		out.println("<style>body { " +
		"}</style>");
		out.println("</head>");

		out.println("<h1>List of restaurants! </h1>");
		out.println("<table>");
		for (restaurant entry: entries) {
			out.println(
				"<tr>" + 
					"<td>" + entry.getname() + " says: </td>" + 
					"<td>" + entry.geturl() + "</td>" +
					"<td>" + entry.getDesignRating() + "</td>" +
					"<td>" + entry.getTasteRatings() + "</td>" +
					
				"</tr>"
			);
		}
		out.println("</table>");
		out.println("<a href='/Mid/random'>See the list </a>");
		out.println("<a href='Mid/lucky'>Feeling Lucky</a>");
	}
}