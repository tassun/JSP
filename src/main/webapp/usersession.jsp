<%
	com.fs.bean.UserBean fsUser = (com.fs.bean.UserBean)session.getAttribute("fsUser");
%>
<html>
<head>
   <title>JSP Examples</title>
</head>
<body bgcolor="#FFFFFF">
	<table>
		<tr><td>ID</td><td><%=fsUser.getId()%></td></tr>
		<tr><td>Name</td><td><%=fsUser.getName()%></td></tr>
		<tr><td>Surname</td><td><%=fsUser.getSurname()%></td></tr>
	</table>
</body>
</html>
