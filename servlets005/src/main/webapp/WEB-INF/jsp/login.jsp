<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>

</head>


<body>
	<h1>Login</h1>
	
	<form action="${pageContext.request.contextPath}/login" method="POST">
		<input type="text" name="login" value="${param.login}">
		<input type="text" name="password" value="">
		
		<input type="submit" value="Submit">
		<input type="reset" value="Reset">
	</form>
		
</body>

</html>