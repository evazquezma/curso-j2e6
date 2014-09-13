<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>

<head>

</head>


<body>
	<h1>Hola mundo</h1>
	
	<%--Por EL --%>
	<h2>Parámetro y atributos recuperados por EL</h2>
		
	<p> Atributo string de request: ${requestScope.atributoDeNegocio}</p>
	<p> Lista de usuariosBean como atributos</p>
	<c:forEach items="${requestScope.usuariosBean}" var="usuarioBean">
		${usuarioBean.login} - ${usuarioBean.pass}
		<br/>
	</c:forEach>
		
	<p> Parámetro de request: ${param.nombre} </p>	
	<p>Todos los parámetros de la request: </p>
	
	<c:forEach items="${paramValues}" var="parametro">
	 	<c:out value='${parametro.key}:'/> 		
	 	<c:forEach var='value' items='${parametro.value}'>  
        	<c:out value='${value}'/>     
    	</c:forEach>
    	</br>   
	</c:forEach>
	
	<hr/>
	
	
	<%--Por Scriptlet --%>
	<h2>Parámetro y atributos recuperados por scriptlet</h2>
	<p> Atributo de request: <%= request.getAttribute("atributoDeNegocio")%></p>
	<p> Parámetro de request: <%= request.getParameter("nombre")%></p>	
			
</body>

</html>