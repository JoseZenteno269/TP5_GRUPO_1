<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Entidades.Clientes" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Clientes</title>
    <link rel="stylesheet" href="css/Listado.css">
</head>
<body>
		<section class="section1">
			<h2>Menú</h2>
			<a href="ServletClientes" >Alta de Cliente</a>
			<br>
			<a href="ServletListadoClientes">Listado de Cliente</a>
		</section>

    <h1>Listado de Clientes</h1>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>DNI</th>
                <th>CUIL</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Sexo</th>
                <th>Fecha Nacimiento</th>
                <th>Domicilio</th>
                <th>Nacionalidad</th>
                <th>Localidad</th>
                <th>Provincia</th>
                <th>Email</th>
                <th>Teléfono</th>
            </tr>
        </thead>

        <tbody>
            <%
                ArrayList<Clientes> lista =
                    (ArrayList<Clientes>) request.getAttribute("listaClientes");

                if (lista != null && !lista.isEmpty()) {
                    for (Clientes cliente : lista) {
            %>
                <tr>
                    <td><%= cliente.getIdCliente() %></td>
                    <td><%= cliente.getDNI() %></td>
                    <td><%= cliente.getCuil() %></td>
                    <td><%= cliente.getNombre() %></td>
                    <td><%= cliente.getApellido() %></td>
                    <td><%= cliente.getSexo() %></td>
                    <td><%= cliente.getFechaNacimiento() %></td>
                    <td><%= cliente.getDomicilio() %></td>
                    <td><%= cliente.getNacionalidad() %></td>
                    <td><%= cliente.getLocalidad() %></td>
                    <td><%= cliente.getProvincia() %></td>
                    <td><%= cliente.getEmail() %></td>
                    <td><%= cliente.getTelefono() %></td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="13">No hay clientes para mostrar.</td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>

</body>
</html>