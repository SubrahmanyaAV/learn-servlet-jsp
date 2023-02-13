<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>

   <%
   		String error = (String) request.getAttribute("ERROR");
  		if(error != null )
  		 {
  	 %>
		<p><%=error %> </p>
	<%
  		 }
	%>
	
	<form action="LoginServlet" method="post">
		<label>User Id:</label>
		<input type="text" name="userId"/>
		<br/>
		<label>Password:</label>
		<input type="password" name="pwd"/>
		<br/>
		<input type="submit" value="Login"/>
	
	</form>	      


</body>
</html>