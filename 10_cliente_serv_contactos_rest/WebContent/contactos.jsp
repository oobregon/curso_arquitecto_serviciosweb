<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<h1>Contactos</h1>
	<div class="form-group">	
		<c:choose>
			<c:when test="${not empty contactos}">
				<table border=1>
						<tr>
							<td>idContacto</td>
							<td>Nombre</td>
							<td>Correo Electrónico</td>
							<td>Edad</td>
							<td>Acción</td>									
						</tr>
						<c:forEach var="contacto" items="${contactos}">				
						<tr>
							<td>${contacto.idContacto}</td>
							<td>${contacto.nombre}</td>	
							<td>${contacto.email}</td>
							<td>${contacto.edad}</td>
							<td><a href="eliminar?idContacto=${contacto.idContacto}">Eliminar</a></td>																	
						</tr>			
						</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<h3 >Sin Libros</h3>
			</c:otherwise>		
		</c:choose>
		</div>
		<div class="form-group">
			<a href="aMenu">Menu</a>
		</div>
</div>

</body>
</html>