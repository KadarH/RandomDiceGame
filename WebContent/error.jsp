<%@page import="bo.Message"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Page d'erreur</h1>

	<%
		Message mess = (Message) session.getAttribute("mess");
		if (mess != null) {
			out.print(mess.getAllMessagesAsString());

			//Les messages d'erreur sont affichés dans on vide la liste
			mess.clear();
		}
	%>




</body>
</html>