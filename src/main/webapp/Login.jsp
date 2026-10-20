<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	<jsp:include page="css\Login.css"></jsp:include>
</style>
<title>TP 5</title>
</head>
<body>
<header></header>
	<main>
		<section>
			<form method="post" action="ServletUsuarios">
				<div>
					<h2>Iniciar Sesión</h2>
					<p>Usuario</p>
					<input name="txtUsuario" type="text" required>
					
					<p>Contraseña</p>
					<input name="txtPassword" type="password" required>
					
					<br>
					<%
						if(request.getAttribute("Estado") != null){
							
							Boolean estado = (Boolean)request.getAttribute("Estado");
							
							if(estado){
								session.setAttribute("Usuario", request.getParameter("txtUsuario")); 
								response.sendRedirect("ServletClientes?accion=formulario");
							}
							else{
								%>
									Usuario o contraseña incorrectos
								<%
							}
						}
					%>
					<br>
					<br>
					<input type="submit" name="btnIngresar" value="Ingresar">
				</div>
			</form>
		</section>
	</main>
	<footer></footer>
</body>
</html>