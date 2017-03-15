<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Gestion des Etudiants</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="w3.css" />
<link type="text/css" rel="stylesheet" href="Style.css" />

</head>
<body>


<div class="w3-card-4 hall0"  >
<div class="w3-container w3-green hall2">
<h2 class="w3-lobster w3-xxlarge w3-text-shadow"> Fast Registration :</h2>
</div>
<div class="w3-container insc w3-center">
	<form action="<%=request.getServletContext().getContextPath()%>/Register" method="post" class="w3-container">
	
			<p>
				<input class="w3-input w3-border w3-light-grey w3-hover-blue-gray" placeholder="Votre nom" type="text" name="nom"/>
			</p>
			<p>
			  	<input class="w3-input w3-border w3-light-grey w3-sand w3-hover-blue-gray" placeholder="Votre prenom" type="text" name = "prenom" />
			</p>
			<p> 
			  	<input class="w3-input w3-border w3-light-grey w3-hover-blue-gray" placeholder=" username" type="text"  name="username" />
			</p>
			<p>
			 	<input class="w3-input w3-border w3-light-grey w3-hover-blue-gray" placeholder=" password" type="password" name ="password" />
			</p> 
			
			  <input class="w3-btn w3-blue-grey  w3-margin w3-padding-4 w3-hover-green w3-border-amber " value="Sign in" type="submit" />
			  <a class="w3-btn w3-blue-grey w3-margin w3-padding-4 w3-hover-green w3-border-amber " href="<%=request.getServletContext().getContextPath()%>/Login.jsp" >Login</a>
	</form>
</div>	
</div>
</body>
</html>