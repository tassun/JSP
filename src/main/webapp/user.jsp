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
<form name="fsform" action="user.jsp" method="post">
	<table>
		<tr><td>ID</td><td><input name="id" value=""></input></td></tr>
		<tr><td>Name</td><td><input name="name" value=""></input></td></tr>
		<tr><td>Surname</td><td><input name="surname" value=""></input></td></tr>
		<tr><td><input type="submit" value="submit"></input></td><td><input type="reset" value="reset"></input></td></tr>
	</table>
</form>
</body>
</html>
