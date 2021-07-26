<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Productos - Menú</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="text-center">Práctica Java WEB - Productos</h1>
		<div class="row ">
			<div class="col-md-auto">
				<table class="table table-striped table-primary">
					<thead>
						<tr>
							<th scope="col">Menú</th>
							
						</tr>
					</thead>
					<tbody>
						<tr>
							
							<td><a href="productos?opcion=crear"> Crear Producto</a></td>
						</tr>
						<tr>
							
							<td><a href="productos?opcion=listar">Listado de productos</a></td>
						</tr>
						
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>