import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

@SuppressWarnings("serial")
public class  HelloServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<TITLE>Hello Servlet</TITLE>");
		out.println("<HEAD></HEAD>");
		out.println("<BODY>Hello World</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
}
