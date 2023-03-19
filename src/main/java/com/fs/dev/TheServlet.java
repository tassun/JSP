package com.fs.dev;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

@SuppressWarnings({"serial","rawtypes"})
public class TheServlet extends HttpServlet implements java.io.Serializable {
public TheServlet() {
	super();
}
public void init(ServletConfig config) throws ServletException {
	super.init(config);
	System.out.println("-----------------------------------------------------------------");
	System.out.println(getClass().getName()+" servlet initialize ...");
	System.out.println("------------------------------------------------------------------");
	System.out.println("init on "+config.getServletContext().getRealPath(""));
	java.util.Enumeration en = config.getInitParameterNames();
	for(;en.hasMoreElements();) {
		String key = (String)en.nextElement();
		System.out.println(key+"="+config.getInitParameter(key));
	}
}
public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/xml; charset=windows-874");
	java.util.Enumeration en = request.getParameterNames();
	for(;en.hasMoreElements();) {
		String key = (String)en.nextElement();
		String value = request.getParameter(key);
		System.out.println(key+"="+value);
	}
	String type = request.getParameter("type");
	if(type!=null && type.equals("reset")) {
		StringBuffer buf = new StringBuffer();
		buf.append("<message type=\"reset\">");
		buf.append("<body>ok</body>");
		buf.append("</message>");				 
		sendResponse(response,buf.toString());
	} else {
		StringBuffer buf = new StringBuffer();
		buf.append("<message type=\"none\">");
		buf.append("<body>Unknown request</body>");
		buf.append("</message>");				 
		sendResponse(response,buf.toString());
	}
}
public void destroy() {
	System.out.println(this+" destroying.");
}
protected void sendResponse(HttpServletResponse response, String text) {
	try {
		String header = "";
		if(!text.trim().equals("")) header = "<?xml version=\"1.0\" encoding=\"windows-874\"?>";
		response.setDateHeader("Expires",System.currentTimeMillis());
		response.getOutputStream().println(header+text);
		response.getOutputStream().flush();
		response.getOutputStream().close();
	} catch (Exception ex) {
	}
}
}
