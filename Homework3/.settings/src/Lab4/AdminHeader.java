package Lab4;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class AdminHeader extends SimpleTagSupport {
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.println("<header>");
		out.println("<h1>Tom's #1 World Famous Chiliburgers </h1>");	
		out.println("<img src='http://nebula.wsimg.com/38c7cffac476fc379ec83d5ec7f94485?AccessKeyId=ED591A06CCEC51484249&disposition=0&alloworigin=1' 'width='140' height='100'>");
		out.println("</header>");
	}
	
}