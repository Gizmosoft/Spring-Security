<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WithInDateRange</title>
<style>
.error {
color: #ff0000;
font-style: italic;
}
.cst_table {
    border: 2px solid black;
}
</style>
</head>
<body>
<center>
<h2>Employee Details with in Date Range</h2>
<h3>Welcome : ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/cstlogout" />" > Logout</a></h3>
<form:form action="${pageContext.request.contextPath}/GetDataWithinDateRange.html" method="GET">
	<table class="cst_table">
		<tr>
			<td>From Date</td>
			<td><input name="fromDate"/><td>
			<td>To Date</td>
			<td><input name="toDate"/><td>
		</tr>
	</table>
	
	<br>
	<input type="submit" value="Get Details"/>
	
	<br><br>
	<c:if test="${not empty empList}">
	<table border="2">
		
			<tr>
				<th>EmployeeID</th><th>EmployeeName</th><th>Role</th><th>Salary</th><th>EmpDate</th>
			</tr>
			<c:forEach var="var" items="${empList}">
			<tr>
				<td>${var.id}</td><td>${var.name}</td><td>${var.role}</td><td>${var.salary}</td><td>${var.insertTime}</td>
			</tr>		
			</c:forEach>
		
	</table>
	
	</c:if>
	<c:if test="${empty empList}">
		<h3>No Employee details to show, try with valid From-Date and To-date</h3>
	</c:if>
</form:form>
</center>
</body>
</html>