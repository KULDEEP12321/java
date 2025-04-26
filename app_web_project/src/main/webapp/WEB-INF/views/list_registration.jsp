<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Students</title>
</head>
<body>
	<h2>All Students</h2>
	
	<table>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>mobile</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		
		<%
			ResultSet res = (ResultSet)request.getAttribute("result");
		while(res.next()){
		%>
		<tr>
			<td><%=res.getString(1)%></td>
			<td><%=res.getString(2)%></td>
			<td><%=res.getString(3)%></td>
			<td><a href = "deleteStudent?email=<%=res.getString(2)%>">delete</a> 
			<td><a href = "updateStudent?email=<%=res.getString(2)%>&mobile=<%=res.getString(3)%>">update</a> 
		</tr>
		<%} %>
		
	</table>
	
</body>
</html>