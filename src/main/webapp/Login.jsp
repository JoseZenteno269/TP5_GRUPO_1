<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Iniciar sesión</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/Login.css">
</head>
<body>
	<header></header>

	<main>
		<section>
			<form method="post" action="<%= request.getContextPath() %>/ServletUsuarios">
				<div>
					<h2>Iniciar sesión</h2>
					<% if (request.getAttribute("mensajeError") != null) { %>
						<p class="error"><%= request.getAttribute("mensajeError") %></p>
					<% } %>
					<label for="txtUsuario">Usuario</label>
					<input type="text" id="txtUsuario" name="txtUsuario"
						required autofocus autocomplete="username">

					<label for="txtPassword">Contraseña</label>
					<input type="password" id="txtPassword" name="txtPassword"
						required autocomplete="current-password">

					<input type="submit" name="btnIngresar" value="Ingresar">
				</div>
			</form>
		</section>
	</main>

	<footer></footer>
</body>
</html>
