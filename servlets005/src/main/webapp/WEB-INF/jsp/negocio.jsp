<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>

</head>


<body>
	<h1>P�gina de negocio de la aplicaci�n</h1>
	
	<c:if test="${sessionScope.autenticacion != null}">
		<h2>Usuario autenticado</h2>
		<p>Login : ${sessionScope.autenticacion.login}</p>
		<p>Rol : ${sessionScope.autenticacion.rol}</p>
	</c:if>
		
	<h2>Haciendo negocio...</h2>
</body>

</html>