<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>	
	
	<%--Comprobar si es un intento de login erróneo --%>
	<c:if test="${!empty param.error && param.error eq true}">
		<h2 style="color:red">Login o password incorrectos</h2>
	</c:if>
	
	
	<form method="POST" action="j_security_check">
		Usuario: <input type="text" name="j_username" size=20>
		<br/> 
		Password: <input type="password" name="j_password" size=20>
		<br/> 
		<input type="submit" value="Aceptar">
	</form>

</body>
</html>