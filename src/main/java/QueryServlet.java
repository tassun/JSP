import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class QueryServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException {
			doGet(request, response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Query</title></head><body>");
		out.println(createForm());
		String sql = request.getParameter("sql");
		System.out.println("sql : "+sql);
		if(sql!=null && sql.trim().length()>0) {
			try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://127.0.0.1:3306/mydb";
			String user = "root";
			String password  = "root";
			Class.forName(driver);
			java.sql.Connection conn = java.sql.DriverManager.getConnection(url,user,password);
			java.sql.Statement stm = conn.createStatement();
			java.sql.ResultSet rs = stm.executeQuery(sql);
			java.sql.ResultSetMetaData met = rs.getMetaData();
			out.println("<table border=1>");
			out.println("<tr>");
			for(int i=1,isz=met.getColumnCount();i<=isz;i++) {
				String colname = met.getColumnName(i);
				out.println("<th>"+colname+"</th>");
			}
			out.println("</tr>");
			while(rs.next()) {
				out.println("<tr>");
				for(int i=1,isz=met.getColumnCount();i<=isz;i++) {
					String colname = met.getColumnName(i);
					out.println("<td>"+rs.getString(colname)+"</td>");
				}
				out.println("</tr>");
			}
			out.println("</table>");
			} catch(Exception ex) { ex.printStackTrace(); }
		}
		out.print("</body></html>");
	}
	private String createForm() {
		StringBuilder buf = new StringBuilder();
		buf.append("<form name=\"qform\" action=\"QueryServlet\" method=\"post\">");
		buf.append("<table>");
		buf.append("<tr><td>SQL</td><td><input name=\"sql\" size=\"30\"></input></td></tr>");
		buf.append("<tr><td></td><td><input type=submit name=\"submit\" value=\"Execute\"></input></tr>");
		buf.append("</table>");
		buf.append("</form>");	
		return buf.toString();
	}
}