<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCLOME PAGE</title>
</head>
<body>

	<%
 	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//works only for http>1.0
 //for below versions use response.setHeader("Cache-Control", " ");
 
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("login.jsp");
	}
%>
	<h2>Welcome to ${ username }</h2>
	<br>
	<div class="container">
		<a href="Welcomejsp.jsp">Home</a> <a href="aboutUs.jsp">About Us!</a>
		<a href="Admin.jsp">Admin</a>

	</div>
	<form action="logout">
		<br> <br> <input type="submit" value="logout">
	</form>

</body>
</html>