<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Productos - Crear</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="text-center">Práctica Java WEB - Productos - Crear</h1>
		<div class="row ">
			<div class="col-md-auto">

				<form action="productos" method="post">
					<input type="hidden" name="opcion" value="guardar">
					<div class="mb-3">
						<label for="codigo" class="form-label">Código</label>
						<input type="text" class="form-control"	id="codigo" name="codigo" placeholder="Código" required>						
					</div>
					<div class="mb-3">
						<label for="nombre" class="form-label">Nombre</label>
						<input type="text" class="form-control"	id="nombre" name="nombre" placeholder="Nombre" required>						
					</div>
					<div class="mb-3">
						<label for="precio" class="form-label">precio</label>
						<input type="number" class="form-control"	id="precio" name="precio" placeholder="Precio" required>						
					</div>
					<div class="mb-3">
						<label for="existencia" class="form-label">Existencia</label>
						<input type="number" class="form-control"	id="existencia" name="existencia" placeholder="Existencia" required>						
					</div>
					<button type="submit" class="btn btn-primary">Crear</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>