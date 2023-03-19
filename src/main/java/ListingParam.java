import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

@SuppressWarnings({"serial","rawtypes"})
public class ListingParam extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<TITLE>Listing Param</TITLE>");
		out.println("<HEAD></HEAD>");
		out.println("<TABLE BORDER=1 ALIGN=CENTER>");
		out.println("<TR><TH>Parameter Name</TH><TH>Parameter Value(s)</TH></TR>");
		Enumeration paramNames = request.getParameterNames();
		for(;paramNames.hasMoreElements();) {
			String paramName = (String)paramNames.nextElement();
			out.println("<TR><TD>" + paramName + "<TD>");
			String[] paramValues = request.getParameterValues(paramName);
			if (paramValues.length == 1) {
				String paramValue = paramValues[0];
				if (paramValue.length() == 0) out.print("<I>No Value</I>");
				else out.print(paramValue);
			} else {
				out.println("<UL>");
				for(int i=0; i<paramValues.length; i++) {
					out.println("<LI>" + paramValues[i]);
				}
				out.println("</UL>");
			}
		}
		out.println("</TABLE></BODY></HTML>");
  }
  public void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException {
			doGet(request, response);
	}
}