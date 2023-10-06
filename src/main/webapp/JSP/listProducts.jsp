<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.model.Product"%>
<%@ page import="com.model.User"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<title>Lista de Productos</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

	<%
	List<Product> products = (ArrayList<Product>) request.getAttribute("products");
	User usuario = (User) request.getSession().getAttribute("usuario");
	%>
	<div class="container mt-5">
		<h1>Lista de Productos - Bienvenido <%= usuario.getUserName() %>!</h1>

		<a href="JSP/createProduct.jsp" class="btn btn-success mb-3">Crear
			Producto</a>
		<form action="LogoutController" method="POST" style="margin-bottom: 1rem;">
            <button type="submit" class="btn btn-danger">Logout</button>
        </form>

		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Descripcion</th>
					<th>Peso</th>
					<th>Stock</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="producto" items="${products}">
					<tr>
						<td>${producto.getId()}</td>
						<td>${producto.getNombre()}</td>
						<td>${producto.getDescripcion()}</td>
						<td>${producto.getPeso()}</td>
						<td>${producto.getStock()}</td>
						<td>
							<form action="UpdateProductController" method="GET"
								style="display: inline;">
								<input type="hidden" style="display: none;" name="id" value="${producto.getId()}">
								<input type="hidden" style="display: none;" name="nombre" value="${producto.getNombre()}">
								<input type="hidden" style="display: none;" name="descripcion" value="${producto.getDescripcion()}">
								<input type="hidden" style="display: none;" name="peso" value="${producto.getPeso()}">
								<input type="hidden" style="display: none;" name="stock" value="${producto.getStock()}">
								
								<button type="submit" class="btn btn-primary">Editar</button>
							</form>
							<form action="DeleteProductController" method="post"
								style="display: inline;">
								<input type="hidden" name="id" style="display: none;" value="${producto.getId()}">
								<button type="submit" class="btn btn-danger">Borrar</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
