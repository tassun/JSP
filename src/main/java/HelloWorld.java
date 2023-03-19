import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class HelloWorld extends HttpServlet {
	public void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("Hello World");
	}
}
