<%@ taglib uri="/WEB-INF/taglibs.tld" prefix="fs"%>
<%
	java.util.Map map = new java.util.TreeMap();
	map.put("01","Male");
	map.put("02","Female");
	map.put("03","Other");
	session.setAttribute("GENDER",map);
%>
<html>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Test TLD</title>
<head>
</head>
<body>
<fs:select name="gender" section="GENDER">&nbsp;</fs:select>
</body>
</html>
