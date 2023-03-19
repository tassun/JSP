<%@ page errorPage="errorpage.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
   <title>Query</title>
</head>
<body>
<form name="qform" action="jdbc.jsp" method="post">
	<table>
		<tr><td>SQL</td><td><input name="sql" size="30"></input></td></tr>
		<tr><td></td><td><input type=submit name="submit" value="Execute"></input></tr>
	</table>
</form>
<table border=1>
<%
	String sql = request.getParameter("sql");
	System.out.println("sql : "+sql);
	if(sql!=null && !sql.trim().equals("")) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/mydb";
		String user = "root";
		String password  = "root";
		Class.forName(driver);
		java.sql.Connection conn = java.sql.DriverManager.getConnection(url,user,password);
		java.sql.Statement stm = conn.createStatement();
		java.sql.ResultSet rs = stm.executeQuery(sql);
		java.sql.ResultSetMetaData met = rs.getMetaData();
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
				//out.println("<td>"+BeanUtility.nativeToUnicode(rs.getString(colname))+"</td>");
			}
			out.println("</tr>");
		}	
	}
%>
</table>
</body>
</html>
