<%@page import="com.cruds.entity.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">

	var selBId;
	var selBName;
	
	function setdate(bid,bname)
	{
		selBId = bid;
		selBName = bname;
		
	}
	
	function dodelete()
	{
		document.bookform.ACTION.value = "DELETE";
		document.bookform.delBId.value = selBId;
		document.bookform.submit();
	}

	function populateform()
	{
		document.bookform.ACTION.value = "UPDATE";
		document.bookform.bId.value = selBId;
		document.bookform.bId.readOnly = true;
		document.bookform.btnSubmit.value = "Update";
		document.bookform.bName.value = selBName;
	}


</script>
</head>
<body>

	<%
      	String msg = (String)session.getAttribute("MESSAGE");
		List<Book> listbook = (List<Book>) request.getAttribute("BOOKLIST");
	 %>
	 

    <h1>Book Page</h1>
    <%
    	if(msg != null){
    %>
		<p> <%=msg %></p>
	<% 
    	}
    %>

	<form name="bookform" action="BookServlet" method="post">
 	    <label>Book Id:</label>
 	    <input type="text" name="bId"/>
 	    <br/>
 	    <label>Book Name:</label>
 	    <input type="text" name="bName"/>
 	    <br/>
 	    <input type="submit" value="Create" name="btnSubmit"/>	
 	    <input type="hidden" name="ACTION" value="CREATE"/>
 	    <input type="hidden" name="delBId"/>
	</form>

	<h1>Book List</h1>
	
	
	<table border="1">
		<thead>
			<tr>
				<td>Book Id</td>
				<td>Book Name</td>
				<td></td>
			</tr>
		</thead>
	<tbody>
		<%
			for(Book b : listbook){
		%>
			<tr>
				<td> <%= b.getBid()%> </td>
				<td> <%= b.getBname() %> </td>
				<td> <input type="checkbox" onclick="setData(<%= b.getBid() %>,'<%= b.getBname() %>')"/> </td>
			</tr>
		<%
			}
		%>		
	
	</tbody>				
	</table>
	
		<input type="button" onclick="dodelete()" value="Delete"/>
		<input type="button" onclick="populateform()" value="Edit"/>


</body>
</html>