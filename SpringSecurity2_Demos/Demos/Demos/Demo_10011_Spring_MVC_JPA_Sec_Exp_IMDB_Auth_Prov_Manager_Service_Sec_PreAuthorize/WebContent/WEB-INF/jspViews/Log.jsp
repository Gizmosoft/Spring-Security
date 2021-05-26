<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
	<h1>Welcome to Log Page</h1>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h3>Welcome : ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/cstlogout" />" > Logout</a></h3>  
	</c:if>
	<div style="border-style: solid;">
			 ${logData}
		
	</div>
		
	
</body>
</html>