import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class CounterSession extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		PrintWriter out = response.getWriter();
		Integer counter = new Integer(0);
		String heading = "";
		if (session.isNew()) {
			heading = "Welcome, Newcomer";
		} else {
			heading = "Welcome Back";
			Integer oldCounter = (Integer)session.getAttribute("counter"); 
			if(oldCounter!=null) {
				counter = new Integer(oldCounter.intValue() + 1);
			}
		}
		session.setAttribute("counter", counter);
		out.println(heading);
		out.println("Session ID = "+session.getId());
		out.println("Number of Access = "+counter);
	}
}