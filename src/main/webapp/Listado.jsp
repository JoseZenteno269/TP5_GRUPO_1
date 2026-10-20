<%@page import="Entidades.Clientes"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TP 5</title>
<link rel="stylesheet" href="https://cdn.datatables.net/3.1.3/css/dataTables.dataTables.css">

<style>
    <jsp:include page="css\Listado.css"></jsp:include>
</style>
</head>
<body>
	<header></header>
	
	<main>
		<section class="section1">
			<h2>Menú</h2>
			<a href="ServletClientes?accion=formulario" >Alta de Cliente</a>
			<br>
			<a href="ServletClientes?accion=listado" >Listado de Cliente</a>
		</section>
		<section class="section2">
			<h1>Listado de Clientes</h1>
			<%
				String usuario = session.getAttribute("Usuario").toString();
			%>
			<p>Usuario: <%= usuario %></p>
			<form method="get" action="ServletClientes">
			<input type="hidden" name="accion" value="listado">
				<div>
					<table id="tabla-clientes" class="display">
						<thead>
							<tr>
								<th>DNI</th>
								<th>CUIL</th>
								<th>Nombre y Apellido</th>
								<th>Sexo</th>
								<th>Fecha de Nacimiento</th>
								<th>Direccion</th>
								<th>Nacionalidad</th>
								<th>Localidad</th>
								<th>Provincia</th>
							</tr>
						</thead>
						<tbody>
							<%
								ArrayList<Clientes> aClientes = (ArrayList<Clientes>)request.getAttribute("Clientes"); 
								if(aClientes != null){
									for(Clientes c : aClientes){
										%>
											<tr>
												<td><%= c.getDni() %></td>
												<td><%= c.getCuil() %></td>
												<td><%= c.getNombre() + " " + c.getApellido() %></td>
												<td><%= c.getSexo() %></td>
												<td><%= c.getFecha_nacimiento() %></td>
												<td><%= c.getDireccion() %></td>
												<td><%= c.getNacionalidad() %></td>
												<td><%= c.getLocalidad() %></td>
												<td><%= c.getProvincia() %></td>
											</tr>
										<%
									}
								}
							%>
						</tbody>
					</table>
				</div>
			</form>
		</section>
	</main>
	
	<footer></footer>
	    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://cdn.datatables.net/2.3.4/js/dataTables.js"></script>

    <script>
        $(document).ready(function () {
            new DataTable('#tabla-clientes', {
                pageLength: 10,
                lengthMenu: [5, 10, 25, 50],
                language: {
                    url: 'https://cdn.datatables.net/plug-ins/2.3.4/i18n/es-ES.json'
                }
            });
        });
    </script>
</body>
</html>