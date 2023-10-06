<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
  <div class="row justify-content-center">
    <div class="col-md-6">
      <form action="../LoginController" method="post">
        <h2 class="mb-4">Iniciar sesion</h2>
        <div class="form-group">
          <label for="username">Nombre de Usuario</label>
          <input type="text" class="form-control" id="username" name="username">
        </div>
        <div class="form-group">
          <label for="password">Contraseña</label>
          <input type="password" class="form-control" id="password" name="password">
        </div>
        <button type="submit" class="btn btn-primary">Iniciar sesion</button>
      </form>
      <p class="mt-3">¿No tienes una cuenta aún? <a href="registro.jsp">Regístrate</a></p>
    </div>
  </div>
</div>
</body>
</html>