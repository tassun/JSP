<%!
public void jspInit() {
	System.out.println(getClass().getName()+" jsp init ...");
}
public void jspDestroy() {
	System.out.println(getClass().getName()+" jsp destroy ...");
}
%>
<%
	String hello = "Hello World";
%>
<html>
<head>
   <title>Hello JSP</title>
</head>
<body>
<%=hello%>
</body>
</html>
