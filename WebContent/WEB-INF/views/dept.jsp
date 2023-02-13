<%@page import="com.cruds.entity.User"%>
<%@page import="com.cruds.entity.Department"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department Page</title>

<script type="text/javascript">

	var selDeptId;
	var selDeptName;

	function setData(deptid,deptname)
	{
		//alert(deptid);
		//alert(deptid+deptname)
		selDeptId = deptid;
		selDeptName = deptname;
	}
	
	function dodelete() 
	{
		document.deptform.ACTION.value = "DELETE";
		document.deptform.delDeptId.value = selDeptId;
		document.deptform.submit();
	}
	
	function populateform()
	{
		document.deptform.ACTION.value = "UPDATE";
		document.deptform.deptId.value = selDeptId;
		document.deptform.deptId.readOnly = true;
		document.deptform.btnSubmit.value = "Update";
		document.deptform.deptName.value = selDeptName;
	}

</script>

</head>
<body>
  
 	<%
 		User user = (User) session.getAttribute("USER");
      	String msg = (String)session.getAttribute("MESSAGE");
 		List<Department> dlist = (List<Department>) request.getAttribute("DEPTLIST");
	 %>
	 

    <h1>Department Page</h1>
    <h2> Welcome <%=user.getUserId() %></h2>
    <%
    	if(msg != null){
    %>
		<p> <%=msg %></p>
	<% 
    	}
    %>
    <%
    	if(user.getRole().equals("Admin")){
    %>

	<form name="deptform" action="DepartmentServlet" method="post">
 	    <label>Dept Id:</label>
 	    <input type="text" name="deptId"/>
 	    <br/>
 	    <label>Dept Name:</label>
 	    <input type="text" name="deptName"/>
 	    <br/>
 	    <input type="submit" value="Create" name="btnSubmit"/>	
 	    <input type="hidden" name="ACTION" value="CREATE"/>
 	    <input type="hidden" name="delDeptId"/>
	</form>
	
	<%
    	}
	%>
	
	<h1>Department List</h1>

	
	<table border="1">
		<thead>
			<tr>
				<td>Dept Id</td>
				<td>Dept Name</td>
				<td></td>
			</tr>
		</thead>
	<tbody>
		<%
			for(Department d : dlist){
		%>
			<tr>
				<td> <%= d.getDeptId() %> </td>
				<td> <%= d.getDeptName() %> </td>                                
				<td> <input type="checkbox" onclick="setData(<%= d.getDeptId() %>,'<%= d.getDeptName() %>')"/> </td>
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