import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ReadParam extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<HTML>");
			out.println("<TITLE>Read Param</TITLE>");
			out.println("<HEAD></HEAD>");
			out.println("<BODY><UL>");
			out.println("<LI>"+request.getParameter("id"));
			out.println("<LI>"+request.getParameter("name"));
			out.println("<LI>"+request.getParameter("surname"));
			out.println("</UL></BODY>");
			out.println("</HTML>");
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException {
		doGet(request, response);
	}
}