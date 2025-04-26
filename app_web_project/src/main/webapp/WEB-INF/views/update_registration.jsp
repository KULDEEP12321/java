<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
	<form action="updateStudent" method="post">
	    <h2>Update here</h2>
		Email <input type="text" name="email" value="<%=request.getAttribute("email")%>"/>
		mobile <input type="text" name="mobile" value="<%=request.getAttribute("mobile")%>"/>
		<input type="submit" value="update"/>
	</form>
</body>
</html>