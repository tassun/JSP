<%
	String hello = "Hello JSP";
	String who = request.getParameter("who");
	if(who!=null) hello = "Hello "+who;
%>
<html>
<head>
   <title>JSP Examples</title>
</head>
<body bgcolor="#FFFFFF">
	<%=hello%>
</body>
</html>
