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
	%>
	<div class="container mt-5">
		<h1>Lista de Productos <c:if test="${sessionScope.usuario != null}">- Bienvenido ${sessionScope.usuario.getUserName()}! Rol: ${sessionScope.usuario.getRole()}</c:if></h1>
    <div class="d-flex justify-content-between align-items-center mb-3">
        <c:if test="${sessionScope.usuario.getRole() eq 'ADMIN'}">
            <a href="JSP/createProduct.jsp" class="btn btn-success">Crear Producto</a>
        </c:if>
        <c:if test="${sessionScope.usuario.getRole() eq 'ADMIN'}">
            <a href="ListUsersController" class="btn btn-secondary">Gestionar usuarios</a>
        </c:if>
		<c:if test="${sessionScope.usuario != null}">
	        <form action="LogoutController" method="POST">
	            <button type="submit" class="btn btn-danger">Logout</button>
	        </form>
        </c:if>
        <c:if test="${sessionScope.usuario == null}">
	        <a href="JSP/login.jsp"><button type="submit" class="btn btn-success">Login</button></a>
	    </c:if>
    </div>

		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Descripcion</th>
					<th>Peso</th>
					<th>Stock</th>
					<c:if test="${sessionScope.usuario != null}">
					<th>Acciones</th>
					</c:if>
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
						<c:if test="${sessionScope.usuario.getRole() eq 'ADMIN'}">
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
						</c:if>
						<c:if test="${sessionScope.usuario.getRole() eq 'STANDARD'}">
						<td>
							<form action="AñadirAlCarritoController" method="post"
									style="display: inline;">
									<input type="hidden" name="id" style="display: none;" value="${producto.getId()}">
									<button type="submit" class="btn btn-success">Añadir al carrito</button>
								</form>
						</td>
						</c:if>
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
