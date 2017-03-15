<%@page import="bo.Message"%>
<%@page import="bo.Player"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="w3.css"/>
<link type="text/css" rel="stylesheet" href="Style.css"/>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RandomGame</title>
</head>
<body>
<div class="w3-bar w3-grey w3-border w3-xxlarge">
  <a href="#" class="w3-bar-item w3-button w3-green"><i class="fa fa-home"></i></a>
  <a href="http://www.google.com" class="w3-bar-item w3-button "><i class="fa fa-search"></i></a>
  <a href="#" class="w3-bar-item w3-button "><i onclick="javascript:document.getElementById('idinfo').style.display='block';" class="fa fa-info"></i></a>
  <a href="#" class="w3-bar-item w3-button w3-right"><i onclick="javascript:document.getElementById('idreset').style.display='block';" class="fa fa-user"></i></a>
  <a href="<%=request.getServletContext().getContextPath()%>/LogoutServlet" class="w3-bar-item w3-button w3-right"><i class="fa fa-sign-out"></i></a>
  
 </div>
<%
    String nom ;

	HttpSession s=request.getSession();
	Player pa = (Player)s.getAttribute("player");
	Message mess = (Message) s.getAttribute("mess");
	String user="";int res = 0,a=0,b=0;int nbrLancee = 0;
	if(mess != null ){
		mess.clear();
	}
	String st= (String)s.getAttribute("clickReplay");
	if(st == null){
		st = "Click";
	}
	
	int c=0;
	if(pa != null ){
		    user =pa.getUsername();
			a = pa.getCurrentScore();
			b = pa.getBestScore();
			res = 0;
		if ( s.getAttribute("res") !=null){
			res = ((Integer)s.getAttribute("res")).intValue();
		}
		
		 nbrLancee=0;
		if ( s.getAttribute("nbrLancee")!=null){
			nbrLancee = ((Integer)s.getAttribute("nbrLancee")).intValue();
		}
		switch(res){
		case 1:{
			c = 1;
			break;
		}
		case 2:{
			c = 6;break;
		}
		case 3:{
			c = 2;break;
		}
		case 4:{
			c = 5;break;
		}
		case 5:{
			c = 3;break;
		}
		case 6:{
			c = 4;break;
		}
		default: {c=0;break;}
		}
	}
	else {
		mess.addMessage("Error player not found !");
	}
%>
<div class="w3-card-4 hall1 w3-display-left w3-center"  >
		<div class="w3-container w3-grey hall3 ">
			
			<button class="w3-btn-floating-large.w3-disabled w3-black w3-hover-grey w3-margin w3-padding-12" >My Score:<%out.print(a+" pt");%></button>
			<button class="w3-btn-floating-large.w3-disabled w3-black w3-hover-grey w3-margin w3-padding-12" >My best Score :<%out.print(b+" pt");%></button>
			<form action="<%=request.getServletContext().getContextPath()%>/zone/play" method="post" class="w3-container " >
	
			
			 <input class="w3-circle w3-green w3-xlarge w3-hover-light-blue  w3-margin w3-padding-12"  type="submit" name="action" value="<%out.print(st); %>" />
		
			</form>
		
			  
			
			<button class="w3-btn-floating-large.w3-disabled w3-black w3-hover-grey w3-margin w3-padding-12" >My Chance:<%out.print(c);%></button>
			<button class="w3-btn-floating-large.w3-disabled w3-black w3-hover-grey w3-margin w3-padding-12" ><% out.print(nbrLancee+"/20"); %></button>
			
			
		</div>
	<div id="container" class="w3-card-4 bb">
		 
		  <div id="cube" class="show<%=res%>">
			    <div class="top"></div>
			    <div class="front"></div>
			    <div class="left"></div>
			    <div class="back"></div>
			    <div class="right"></div>
			    <div class="bottom"></div>
		 </div>
	</div>
	<button class="w3-btn-floating-large.w3-disabled w3-black w3-border-0  w3-margin w3-padding-12"><% out.print(session.getAttribute("resultat")); %></button>
	
	</div>

	
<div id="idreset" class="w3-modal">
	 <div class="w3-modal-content  w3-border-light-blue w3-light-grey w3-card-24  w3-animate-zoom" style="max-width:600px">

     

        	
          	<div class="w3-section">
        
        	<h2> <%out.print(pa.getPrenom());%></h2>
          	</div>
       <form class="w3-container w3-form " action="<%=request.getServletContext().getContextPath()%>/zone/play" method="post">
        	
          <div class="w3-container w3-border-top w3-padding-16 hall9">
         
          <input type="password" placeholder="New Password" class="w3-input w3-margin" />
       	 <input type="password" placeholder="Confirm New Password" class="w3-input w3-margin"/>
       	 
        <button onclick="javascript:document.getElementById('idreset').style.display='none'" type="button" class="w3-btn w3-margin w3-right w3-green">Cancel</button>
        <input type="submit" value="Reset"  name="action" class="w3-btn w3-right w3-margin w3-green"/>
       
      </div>
      </form>

      

    </div>


</div>

<!-- ******************************************************************************** -->

<div id="idinfo" class="w3-modal">
	 <div class="w3-modal-content  w3-border-light-blue w3-light-grey w3-card-24  w3-animate-zoom" style="max-width:600px">

     

        	
	<div class="w3-section w3-lobster w3-card-12 ">
   
      	<h3 class=" w3-text-amber w3-black w3-hide-medium w3-text-light-grey"> This Game Was Created By Kadar Hamza ( Mars 2016 )</h3>
    </div>
      	
   <div class="w3-container w3-border-top w3-padding-16 hall9">
      
      <button onclick="javascript:document.getElementById('idinfo').style.display='none'" type="button" class="w3-btn w3-margin w3-right w3-green">Cancel</button>
      
    </div>
   
     

    </div>


</div>


<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="js/index.js"></script>
	
</body>
</html>