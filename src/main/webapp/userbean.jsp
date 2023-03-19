<jsp:useBean id="fsUser" scope="session" class="com.fs.bean.UserBean"/>
<jsp:setProperty name="fsUser" property="*"/>
<%
	System.out.println(fsUser);
%>
<html>
<head>
   <title>JSP Examples</title>
</head>
<body bgcolor="#FFFFFF">
	<table>
		<tr><td>ID</td><td><jsp:getProperty name="fsUser" property="id"/></td></tr>
		<tr><td>Name</td><td><jsp:getProperty name="fsUser" property="name"/></td></tr>
		<tr><td>Surname</td><td><jsp:getProperty name="fsUser" property="surname"/></td></tr>
	</table>
</body>
</html>
