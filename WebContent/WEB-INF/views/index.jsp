<%@page import="com.cruds.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index page</title>
</head>
<body>
   <%
	User user = (User) session.getAttribute("USER");
  %>

 <h1>Hello Index </h1>
 
 <h2>Welcome <%= user.getUserId()%> </h2>
 
   <a href="greeting.html">Say hello</a>
   <br/>
   <a href="DepartmentServlet" >Department</a>
   <br/>
   <a href="BookServlet">Book</a>
 

</body>
</html>