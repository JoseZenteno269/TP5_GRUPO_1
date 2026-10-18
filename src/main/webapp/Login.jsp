<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Iniciar sesión</title>
<style>
	<jsp:include page="css\Login.css"></jsp:include>
</style>
</head>
<body>
	<header></header>
	
	<main>
		<section>
        	<form method="post" action="LoginServlet">
				<div>
        			<h2>Iniciar sesión</h2>
            		<label for="txtUsuario">Usuario</label>
            		<input type="text" id="txtUsuario" name="txtUsuario" required>

            		<label for="txtPassword">Contraseña</label>
            		<input type="password" id="txtPassword" name="txtPassword" required>

            		<input type="submit" name="btnIngresar" value="Ingresar">
    			</div>
        	</form>
		</section>
	</main>

	<footer></footer>
</body>
</html>