<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page  isErrorPage="true"%> 
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
	<body style= "margin: 50px">
		<h2 ><font color="red">Error <%=request.getAttribute("code") %> <% if(((Integer)request.getAttribute("code"))==404){out.print(": Page not found");}%></font></h2> 
		<h3 style= "margin: 20px">To get help, give detail of what caused error and code to customer support team.</h3>
		
		
	</body>
</html>