<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
<c:set var="producto" value="${producto }"></c:set>
	<div class="container">
		<h1 class="text-center">Práctica Java WEB - Productos - Listado</h1>
		<div class="row ">
			<div class="col-md-auto">
				<form action="productos" method="post">
					<input type="hidden" name="opcion" value="editar">
					<input type="hidden" name="id" value="${producto.id}">
					<div class="mb-3">
						<label for="codigo" class="form-label">Código</label> <input
							type="text" class="form-control" id="codigo" name="codigo"
							value="${producto.codigo}" required>
					</div>
					<div class="mb-3">
						<label for="nombre" class="form-label">Nombre</label> <input
							type="text" class="form-control" id="nombre" name="nombre"
							value="${producto.nombre}" required>
					</div>
					<div class="mb-3">
						<label for="precio" class="form-label">precio</label> <input
							type="number" class="form-control" id="precio" name="precio"
							value="${producto.precio}" required>
					</div>
					<div class="mb-3">
						<label for="existencia" class="form-label">Existencia</label> <input
							type="number" class="form-control" id="existencia"
							name="existencia" value="${producto.existencia}" required>
					</div>
					<button type="submit" class="btn btn-primary">Editar</button>
				</form>
			</div>
		</div>
</body>
</html>