<%@page import="bo.Message"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="w3.css" />
<link type="text/css" rel="stylesheet" href="Style.css" />
</head>
<body>

<%
if(session.getAttribute("authenticated")!=null && session.getAttribute("authenticated").equals(true))
{
   response.sendRedirect(request.getServletContext().getContextPath()+"/zone/Game.jsp");
}
		
	%>
<div class="w3-card-4 hall11"  >
<div class="w3-container w3-green w3-border-bottom hall2">
<h2 class="w3-lobster w3-xxlarge w3-text-shadow">Login :</h2>
</div>
<div class="w3-container insc w3-center">
	<form action="<%=request.getServletContext().getContextPath()%>/Login" method="post" class="w3-container " >
			<p>
				<%
				Message msg = (Message) session.getAttribute("mess");

				if (msg != null) {
					out.print(msg.getAllMessagesAsString());

					//Les messages d'erreur sont affichés dans on vide la liste
					msg.clear();
				}
		
				%>
			</p>
			<p>
				<input class="w3-input w3-border w3-light-grey w3-hover-blue-gray" placeholder="Username" type="text" name="username"/>
			</p>
			<p>
			 	<input class="w3-input w3-border w3-light-grey w3-hover-blue-gray" placeholder="Password" type="password" name="password" />
			</p> 
			
			  <input class="w3-btn w3-green w3-margin w3-text-black w3-hover-blue-gray" type="submit" value="Log in" />
			  <a href="<%=request.getServletContext().getContextPath()%>/add.jsp"> 
			  <p class="w3-btn w3-green w3-margin w3-text-black w3-hover-blue-gray">
			  Sign in
			  </p>
			  </a>
	</form>
</div>	
</div>

</body>
</html>