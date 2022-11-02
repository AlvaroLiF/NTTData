<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.nttdata.tomcat.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NTT Data - Taller JSP / Apache Tomcat</title>
</head>
<body>

	<p>Bienvenid@s a NTT Data - Primer JSP | Contar de 1 a 10.</p>

	<%
	
	for (int i = 0; i <= 10; i++) {
		out.println("A la de... " + i);
	}
	
	%>

	<p><%=NTTDataJSP.helloNTTData("Álvaro")%></p>
</body>
</html>