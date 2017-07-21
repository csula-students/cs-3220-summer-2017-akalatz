package homework2;

import java.util.List;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;



import javax.servlet.annotation.WebServlet;

@WebServlet("/food/edit")
public class EditFood extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			List<CreateFood> entries = (List<CreateFood>) getServletContext().getAttribute("entries");
			CreateFood leEntry = null;
			for (CreateFood entry: entries) {
				if (entry.getId() == id) {
					leEntry = entry;
				}
			}
		
   

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<body style='background-color:#E6E6FA;'>");
		out.println("<h1>Tom's #1 World Famous Chiliburgers</h1>");
		out.println(
				"<img  src=http://nebula.wsimg.com/38c7cffac476fc379ec83d5ec7f94485?AccessKeyId=ED591A06CCEC51484249&disposition=0&alloworigin=1 alt= logo /> </br>");
		out.println("<form method=\"post\"></br>");
		out.println("Food name: <p><input name='name' type='text' value='" + leEntry.getName() + "'/></br></p>");
		out.println("Food price:<p> <input price='price' type='text' value='" + leEntry.getPrice() + "'/></br><p>");
		out.println("<p><textarea description='description'>" + leEntry.getDescription() + "</textarea></br></p>");
		out.println("</br>");
		out.println("</br>");
		out.println("<button>Edit</button>");
		out.println("</form>");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<CreateFood> entries = (List<CreateFood>) getServletContext().getAttribute("entries");
		CreateFood leEntry = null;
		int index = -1;
		for (int i = 0; i < entries.size(); i++) {
			if (entries.get(i).getId() == id) {
				leEntry = entries.get(i);
				index = i;
			}
		}
		entries.set(index, new CreateFood(leEntry.getId(), request.getParameter("name"), request.getParameter("price"),
				request.getParameter("description")));
		getServletContext().setAttribute("entries", entries);

		response.sendRedirect("../food");
	}
	
	
	
	
	
	
	
}