<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Estudiante</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
					integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="<%=request.getContextPath()%>/PacienteList">
		<img src="https://www.ehcos.com/wp-content/uploads/2017/03/ico-paciente.png" width="30" height="30" class="d-inline-block align-top" alt="">
			    Pacientes
		</a>
	</nav>
	<br>
	<div class="row">
		<div class="container">
	    	<h3 class="text-center">Listado de Estudiantes</h3>
	    	<hr>
	        <div class="container text-left">
	        	<a href="<%=request.getContextPath()%>/Nuevo_Paciente" class="btn btn-success" style="background-color:#343a40; border:none">Inscribir estudiante</a>
	        </div>
	        <br>
	        <table class="table table-sm table-bordered " Style="text-align:center" >
				<thead>
					<tr>
						<th>Id</th>
						<th>Documento</th>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Email</th>
						<th>Genero</th>
						<th>Fecha de nacimiento</th>
						<th>Telefono</th>
						<th>Direccion</th>
						<th>Peso</th>
						<th>Estatura</th>
						<th>IMC</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="pac" items="${listPacientes}">

						<tr>
							<td><c:out value="${pac.id}" /></td>
							<td><c:out value="${pac.documento}" /></td>
							<td><c:out value="${pac.nombre}" /></td>
							<td><c:out value="${pac.apellido}" /></td>
							<td><c:out value="${pac.email}" /></td>
							<td><c:out value="${pac.genero}" /></td>
							<td><c:out value="${pac.fechanacimiento}" /></td>
							<td><c:out value="${pac.telefono}" /></td>
							<td><c:out value="${pac.direccion}" /></td>
							<td><c:out value="${pac.peso}" /></td>
							<td><c:out value="${pac.estatura}" /></td>
							<td><c:out value="${pac.imc}" /></td>
							<td><a href="edit?id=<c:out value='${est.id}' />"
								style="color: #343a40; text-decoration: underline">Editar</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${est.id}' />"
								style="color: #343a40; text-decoration: underline">Eliminar</a></td>
						</tr>
					</c:forEach>
					</tbody>
		    </table>
		</div>
	</div>
</body>
</html>