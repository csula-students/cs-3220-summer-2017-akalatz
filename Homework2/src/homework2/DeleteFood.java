package homework2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/food/delete")
public class DeleteFood extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<CreateFood> entries = (List<CreateFood>) getServletContext().getAttribute("entries");
		int index = -1;
		for (int i = 0; i < entries.size(); i ++) {
			if (entries.get(i).getId() == id) {
				index = i;
			}
		}
		entries.remove(index);
		getServletContext().setAttribute("entries", entries);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<body style='background-color:#E6E6FA;'>");
		out.println("<h1> Tom's #1 World Famous Chiliburgers </h1>");
		out.println(
				"<img  src=http://nebula.wsimg.com/38c7cffac476fc379ec83d5ec7f94485?AccessKeyId=ED591A06CCEC51484249&disposition=0&alloworigin=1 alt= logo /> </br>");
		out.println("<a href='/hOMEWORK/food'>go back Food Items</a>");
		out.println("</br>");
		out.println("</br>");
		out.println("</br>");
		out.println("<footer> © 2017 Tom's #1 World Famous Chiliburgers Inc.,All Rights Reserved </footer>");
	}
}