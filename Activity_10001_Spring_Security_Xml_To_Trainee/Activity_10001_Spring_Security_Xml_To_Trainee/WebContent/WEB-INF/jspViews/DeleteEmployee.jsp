<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Employee Page</title>
<style>
.error {
color: #ff0000;
font-style: italic;
}
</style>
</head>
<body>
<center>
<h2>Delete Employee </h2>
<h3>Welcome : ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/cstlogout" />" > Logout</a></h3>

<form:form method="POST" modelAttribute="employeeBean" action="${pageContext.request.contextPath}/DeleteEmployeeByName.html">
	<table border="2">
		<tr>
			<td>Select Employee:</td>
			<td><form:select path="name">
					<form:option value="" label="--Select--" />
					<form:options items="${employeeNamesAndId}"/>
				</form:select>
			</td>
		</tr>	
	</table>
	<br/>
	<input type="Submit" value="Delete Employee">
	
	<br/>
	<h3>${message}</h3>
</form:form>
</center>
</body>
</html>