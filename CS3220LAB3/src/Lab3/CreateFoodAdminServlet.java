package Lab3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/food/create")
public class CreateFoodAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<body style='background-color:#E6E6FA;'>");
		out.println("<form method=\"post\">");
		out.println("<H1>Tom's #1 World Famous Chiliburgers</h2>");
		out.println(
				"<img  src=http://nebula.wsimg.com/38c7cffac476fc379ec83d5ec7f94485?AccessKeyId=ED591A06CCEC51484249&disposition=0&alloworigin=1 alt= logo /> </br>");
		out.println("Food  name:<p> <input name='name' type='text'/></br></p>");
		out.println("Food  price:<p> <input name='price' type='text'/></br></p>");
		out.println("Food description :<p> <textarea name='description'></textarea></br></p>");
		out.println("<button>Create Food </button>");
		out.println("</form>");
		out.println("</br>");
		out.println("</br>");
		out.println("<footer> © 2017 Tom's #1 World Famous Chiliburgers Inc.,All Rights Reserved </footer>");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CreateFood> entries = (List<CreateFood>) getServletContext().getAttribute("entries");
		entries.add(new CreateFood(entries.size(), request.getParameter("name"), request.getParameter("price"),
				request.getParameter("description")));
		getServletContext().setAttribute("entries", entries);
		PrintWriter out = response.getWriter();
	
		out.println("<a href='/CS3220LAB3/food'>go back to your items</a>");
		

	}
}