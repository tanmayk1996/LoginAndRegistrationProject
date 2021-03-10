<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<a href="UserController">Click Here For Details</a>

	<%
	if (session.getAttribute("username") == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	<h3>This is Admin Module</h3>

	<ul>
		<c:forEach var="register" items="${list}">
			<li>${register}</li>
			<br>
		</c:forEach>

	</ul>

</body>
</html>