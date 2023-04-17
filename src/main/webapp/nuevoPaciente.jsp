<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Paciente</title>
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
	<div class="container col-md-5">
                <div class="card">
                    <div class="card-body">

                        <c:if test="${pac != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${pac == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${pac != null}">
                                    Editar paciente
                                </c:if>
                                <c:if test="${pac == null}">
                                    Agregar nuevo paciente
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${pac != null}">
                            <input type="hidden" name="id" value="<c:out value='${pac.id}' />" />
                        </c:if>
						<fieldset class="form-group">
                            <label>Documento del paciente</label> <input type="text" maxlength="12" value="<c:out value='${pac.documento}' />" class="form-control" name="documento">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Nombre del paciente</label> <input type="text" maxlength="30" value="<c:out value='${pac.nombre}' />" class="form-control" name="nombre" required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Apellido del paciente</label> <input type="text" maxlength="30" value="<c:out value='${pac.apellido}' />" class="form-control" name="apellido"required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Email del paciente</label> <input type="email" maxlength="100" value="<c:out value='${pac.email}' />" class="form-control" name="email">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Genero del paciente</label> <input type="text" maxlength="1" value="<c:out value='${pac.genero}' />" class="form-control" name="genero">
                        </fieldset> <fieldset class="form-group">
                            <label>Fecha de nacimiento del paciente</label> <input type="date" value="<c:out value='${pac.fechanacimiento}' />" class="form-control" name="fechanacimiento">
                        </fieldset>
						<fieldset class="form-group">
                            <label>Telefono del paciente</label> <input type="text"   maxlength="10" value="<c:out value='${pac.telefono}' />" class="form-control" name="telefono">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Direccion del paciente</label> <input type="text" maxlength="100" value="<c:out value='${pac.direccion}' />" class="form-control" name="direccion">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Peso del paciente</label> <input type="number"  step="0.01"  value="<c:out value='${pac.peso}' />" class="form-control" name="peso">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Estatura del paciente</label> <input type="number"  step="0.01" value="<c:out value='${pac.estatura}' />" class="form-control" name="estatura">
                        </fieldset>
                        <button type="submit" class="btn btn-success" style="background-color:#343a40; border:none">Guardar</button>
                        </form>
                    </div>
                </div>
            </div>
</body>
</html>