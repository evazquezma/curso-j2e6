<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>

<head>

</head>


<body>
	<h1>Hola mundo</h1>
	
	<%--Por EL --%>
	<h2>Par�metro y atributos recuperados por EL</h2>
		
	<p> Atributo string de request: ${requestScope.atributoDeNegocio}</p>
	<p> Lista de usuariosBean como atributos</p>
	<c:forEach items="${requestScope.usuariosBean}" var="usuarioBean">
		${usuarioBean.login} - ${usuarioBean.pass}
		<br/>
	</c:forEach>
		
	<p> Par�metro de request: ${param.nombre} </p>	
	<p>Todos los par�metros de la request: </p>
	
	<c:forEach items="${paramValues}" var="parametro">
	 	<c:out value='${parametro.key}:'/> 		
	 	<c:forEach var='value' items='${parametro.value}'>  
        	<c:out value='${value}'/>     
    	</c:forEach>
    	</br>   
	</c:forEach>
	
	<hr/>
	
	
	<%--Por Scriptlet --%>
	<h2>Par�metro y atributos recuperados por scriptlet</h2>
	<p> Atributo de request: <%= request.getAttribute("atributoDeNegocio")%></p>
	<p> Par�metro de request: <%= request.getParameter("nombre")%></p>	
			
</body>

</html>