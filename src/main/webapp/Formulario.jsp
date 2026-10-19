<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	<jsp:include page="css\Formulario.css"></jsp:include>
</style>
</head>
<body>
	<header></header>
	
	<main>
		<section class="section1">
			<h2>Menú</h2>
			<a href="ServletClientes" >Alta de Cliente</a>
			<br>
			<a href="ServletListadoClientes">Listado de Cliente</a>
		</section>
		<section class="section2">
			<h1>Formulario de Cliente</h1>

			<% if (session.getAttribute("usuario") != null) { %>
				<p>Usuario: <%= session.getAttribute("usuario") %></p>
			<% } %>
			<% if (request.getAttribute("mensajeExito") != null) { %>
				<p><%= request.getAttribute("mensajeExito") %></p>
			<% } %>
			<% if (request.getAttribute("mensajeError") != null) { %>
				<p><%= request.getAttribute("mensajeError") %></p>
			<% } %>
			
			<form method="post" action="<%= request.getContextPath() %>/ServletClientes">
				<div class="formulario">
					<table>
						<tr>
							<td style="padding-right: 20px">
								<p>DNI*</p>
								<input type="text" name="txtDni" pattern="[0-9]{6,8}" title="Numeros de 6 a 8 digitos" required>
							</td>
							<td>
								<p>CUIL*</p>
								<input type="text" name="txtCuil" pattern="[0-9]{11}" title="Numeros de 11 digitos" required>
							</td>
						</tr>
						<tr>
							<td>
								<p>Nombre*</p>
								<input type="text" name="txtNombre" pattern="[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ]{0,100}" title="Solo letras" required>
							</td>
							<td>
								<p>Apellido*</p>
								<input type="text" name="txtApellido" pattern="[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ]{0,100}" title="Solo letras" required>
							</td>
						</tr>
						<tr>
							<td>
								<p>Sexo*</p>
								<Select name="ddlGenero"  required>
									<option value="" selected disabled>--Seleccione--</option>
									<option value="M">Masculino</option>
									<option value="F">Femenino</option>
									<option value="O">Otros</option>
								</Select>
							</td>
							<td>
								<p>Nacionalidad</p>
								<input type="text" name="txtNacionalidad" pattern="[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ]{0,50}" required>
							</td>
						</tr>
						<tr>
							<td>
								<p>Fecha de nacimiento*</p>
								<input type="date" name="txtFecha" max="<%= request.getAttribute("Fecha") %>" required>
							</td>
							<td>
								<p>Direccion</p>
								<input type="text" name="txtDireccion" pattern="[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ0-9 ]{0,150}" required>
							</td>
						</tr>
						<tr>
							<td>
								<p>Localidad</p>
								<input type="text" name="txtLocalidad" pattern="[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]{0,50}" required>
							</td>
							<td>
								<p>Provincia</p>
								<input type="text" name="txtProvincia" pattern="[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]{0,50}" required>
							</td>
						</tr>
						<tr>
							<td>
								<p>Correo electronico*</p>
								<input type="email" name="txtCorreo" maxlength="100" required>
							</td>
							<td>
								<p>Telefono</p>
								<input type="text" name="txtTelefono" pattern="[0-9]{10}" title="Numeros de 10 digitos" required>
							</td>
						</tr>
						<tr>
							<td>
								<input type="submit" value="Guardar cliente" name="btnGuardar">
							</td>
							<td>
							</td>
						</tr>
					</table>
				</div>
			</form>
		</section>
	</main>
	
	<footer></footer>
</body>
</html>
