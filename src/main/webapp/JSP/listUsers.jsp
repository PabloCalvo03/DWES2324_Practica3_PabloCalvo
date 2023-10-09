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
	List<User> users = (ArrayList<User>) request.getAttribute("users");
	%>
	<div class="container mt-5">
		<h1>Lista de Usuarios - Bienvenido ${sessionScope.usuario.getUserName()}! Rol: ${sessionScope.usuario.getRole()}</h1>
    <div class="d-flex justify-content-between align-items-center mb-3">
        <c:if test="${sessionScope.usuario.getRole() eq 'ADMIN'}">
            <a href="ListProductsController" class="btn btn-success">Volver a la lista de productos</a>
        </c:if>
        <form action="LogoutController" method="POST">
            <button type="submit" class="btn btn-danger">Logout</button>
        </form>
    </div>

		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Rol</th>
					<th>Cambiar rol</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${users}">
					<tr>
						<td>${user.getId()}</td>
						<td>${user.getUserName()}</td>
						<td>${user.getRole()}</td>
						<td>
						<c:if test="${user.getRole() == 'ADMIN' && !user.getUserName().equals('admin') && !sessionScope.usuario.getUserName().equals(user.getUserName())}">
							<form action="UserChangeToStandardController" method="post">
						        <input type="hidden" name="id" value="${user.getId()}">
						        <button type="submit" class="btn btn-danger">Quitar privilegios</button>
						    </form>
						</c:if>
						<c:if test="${user.getRole() == 'ADMIN' && user.getUserName().equals('admin')}">
							<input type="text" id="tipo_usuario" name="tipo_usuario" value="Este usuario no puede cambiar de rol, siempre debe haber un admin" disabled class="form-control">
						</c:if>
						<c:if test="${user.getRole() != 'ADMIN' && !user.getUserName().equals('admin')}">
							<form action="UserChangeToAdminController" method="post">
						        <input type="hidden" name="id" value="${user.getId()}">
						        <button type="submit" class="btn btn-success">Hacer Administrador</button>
						    </form>
						</c:if>
						<c:if test="${user.getRole() == 'ADMIN' && sessionScope.usuario.getUserName().equals(user.getUserName())}">
								<input type="text" id="tipo_usuario" name="tipo_usuario" value="No puedes quitarte los privilegios a ti mismo" disabled class="form-control">
						</c:if>
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
