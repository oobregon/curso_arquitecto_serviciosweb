<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

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
	<h1>Creación de Contacto</h1>
	<f:form action="altaContacto" method="post" modelAttribute="contacto">
		<div class="form-group">
			<label>Nombre de contacto:</label><f:input path="nombre" class="form-control" style="width:30%"/>
		</div>
		<div class="form-group">
			<label>Edad:</label><f:input path="edad" class="form-control" style="width:30%"/>
		</div>
		<div class="form-group">
			<label>Correo electrónico:</label><f:input path="email" class="form-control" style="width:30%"/>
		</div>		
		<button type="submit" class="btn btn-default">Confirmar</button><br/>	
	</f:form>
	<div class="form-group">
		<a href="aMenu">Menu</a>
	</div>	
</div>		
</body>
</html>