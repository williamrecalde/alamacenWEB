<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Productos - Listado</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="text-center">Práctica Java WEB - Productos - Listado</h1>
		<div class="row ">
			<div class="col-md-auto">

				<table class="table table-dark table-striped table-hover">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Codigo</th>
							<th scope="col">Nombre</th>
							<th scope="col">Precio</th>
							<th scope="col">Existencia</th>
							<th scope="col">Fecha de creación</th>
							<th scope="col">Fecha de actualización</th>
							<th scope="col">Acción</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="producto" items="${lista}">
							<tr>								
								<td><a href="productos?opcion=actualizar&id=<c:out value="${producto.getId()}" ></c:out>"><c:out value="${producto.getId()}" ></c:out></a></td>
								<td><c:out value="${producto.getCodigo()}" ></c:out></td>
								<td><c:out value="${producto.getNombre()}" ></c:out></td>
								<td><c:out value="${producto.getPrecio()}" ></c:out></td>
								<td><c:out value="${producto.getExistencia()}" ></c:out></td>
								<td><c:out value="${producto.getFecha_crear()}" ></c:out></td>
								<td><c:out value="${producto.getFecha_actualizar()}" ></c:out></td>
								<td><a href="productos?opcion=eliminar&id=<c:out value="${producto.getId()}" ></c:out>">Eliminar</a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>