<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.model.Product"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Actualizar Producto</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<% 
 if(request.getSession().getAttribute("usuario") == null){
	response.sendRedirect("./login.jsp");
}
Product product = (Product) request.getAttribute("product"); %>
    <div class="container mt-5">
        <h1>Actualizar producto</h1>
        <form action="UpdateProductController" method="POST">

            <input type="hidden" id="id" name="id" value="${product.getId()}" required>

            <div class="form-group">
                <label for="nombre">Nombre del Producto</label>
                <input type="text" class="form-control" id="nombre" name="nombre" value="${product.getNombre()}" required>
            </div>
            <div class="form-group">
                <label for="descripcion">Descripción</label>
                <textarea class="form-control" id="descripcion" name="descripcion" rows="3" required>${product.getDescripcion()}</textarea>
            </div>
            <div class="form-group">
                <label for="peso">Peso</label>
                <input type="number" class="form-control" id="peso" name="peso" value="${product.getPeso()}" required>
            </div>
            <div class="form-group">
                <label for="stock">Stock</label>
                <input type="number" class="form-control" id="stock" name="stock" value="${product.getStock()}" required>
            </div>
            <button type="submit" class="btn btn-primary">Actualizar producto</button>
        </form>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
