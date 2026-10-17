<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Iniciar sesión</title>
<link rel="stylesheet" href="css/Login.css">
</head>
<body>

    <div class="login-card">
        <h1>Iniciar sesión</h1>

        <form method="post" action="LoginServlet">

            <label for="txtUsuario">Usuario</label>
            <input type="text" id="txtUsuario" name="txtUsuario" required>

            <label for="txtPassword">Contraseña</label>
            <input type="password" id="txtPassword" name="txtPassword" required>

            <input type="submit" name="btnIngresar" value="Ingresar">

        </form>
    </div>

</body>
</html>