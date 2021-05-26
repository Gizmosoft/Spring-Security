<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<h2>Employee Management System</h2>
	<a href="${pageContext.request.contextPath}/LoadSaveEmployee.html">Add Employee</a><br><br><br>
	<a href="${pageContext.request.contextPath}/LoadUpdateEmployee.html">Update Employee</a><br><br><br>
	<a href="${pageContext.request.contextPath}/GetDetails.html">Get All Employee Details</a><br><br><br>
	<a href="${pageContext.request.contextPath}/LoadGetDetailsInDateRange.html">Employee Details with in Date Range</a><br><br><br>
	<a href="${pageContext.request.contextPath}/LoadDeleteEmployeeByName.html">Delete Employee By-Name</a><br><br><br>
</center>
</body>
</html>