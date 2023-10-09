<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registro</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 100px;
        }
        .card {
            border: 1px solid #dcdcdc;
            border-radius: 10px;
            box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }
        .card-title {
            font-size: 24px;
            text-align: center;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .btn-primary {
            width: 100%;
        }
        .mt-3 {
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <h2 class="card-title mb-4">Registro</h2>
                    <form action="../RegisterController" method="post">
                        <div class="form-group">
                            <label for="username">Nombre de Usuario</label>
                            <input type="text" class="form-control" id="username" name="username">
                        </div>
                        <div class="form-group">
                            <label for="password">Contraseña</label>
                            <input type="password" class="form-control" id="password" name="password">
                        </div>
                        <div class="form-group">
	                        <label for="tipo_usuario">Rol del usuario:</label>
							<input type="text" id="tipo_usuario" name="tipo_usuario" value="Usuario normal" disabled class="form-control">
							<span class="form-text text-muted">Si desea ser administrador, debe hablar con algun administrador de la aplicacion.</span>
							
                        </div>
                        <button type="submit" class="btn btn-primary">Registrarse</button>
                    </form>
                    <p class="mt-3">¿Ya tienes una cuenta? <a href="login.jsp">Inicia sesión</a></p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
