import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class CounterCookie extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Listing Cookies");
		int counter = 0;
		Cookie[] cookies = request.getCookies();		
		if(cookies!=null) {
			for(int i=0; i<cookies.length; i++) {
				Cookie cookie = cookies[i];
				out.println(cookie.getName()+" = "+cookie.getValue());
				if("counter".equals(cookie.getName())) {
					if(cookie.getValue()!=null) {
						counter = Integer.parseInt(cookie.getValue());
					}
				}
			}		
		}
		Cookie cookie = new Cookie("counter", ""+(++counter));
		response.addCookie(cookie);
	}
}