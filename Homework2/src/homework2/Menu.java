package homework2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

@WebServlet(loadOnStartup = 1, urlPatterns = { "/menu" })
public class Menu extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<CreateFood> entries = (List<CreateFood>) getServletContext().getAttribute("entries");

		out.println("<head>");
		out.println("<style>body { " + "}</style>");
		out.println("</head>");
		out.println("<h1> Tom's #1 World Famous Chiliburgers </h1>");
		
		out.println("<body style='background-color:#E6E6FA;'>");
		out.println(
				"<img  src=http://nebula.wsimg.com/38c7cffac476fc379ec83d5ec7f94485?AccessKeyId=ED591A06CCEC51484249&disposition=0&alloworigin=1 alt= logo /> </br>");
		out.println("<table>");
		out.println("<h1> Menu </h1>");
		
		for (CreateFood entry : entries) {
			out.println(
					"<tr>" + "<td>" + entry.getName() + " </td>" +
		            "<td>" + entry.getPrice() + "</td>" + 
					"<td>"+ entry.getDescription() + "</td>" + 
					"<td><a href='menu/add?id=" + entry.getId() + "'>Add item to cart</a> </td>" +
				    "</tr>");
		}
		out.println("</table>");

		out.println("</br>");
		out.println("</br>");
		out.println("<footer> © 2017 Tom's #1 World Famous Chiliburgers Inc.,All Rights Reserved </footer>");
	}

	
	
}