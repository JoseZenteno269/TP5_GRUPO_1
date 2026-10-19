package Servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import I_Negocio.I_NegocioClientes;
import Negocio.NegocioClientes;


public class ServletClientes extends HttpServlet {
    private static final long serialVersionUID = 1L;
	private final I_NegocioClientes negocioClientes = new NegocioClientes();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		mostrarFormulario(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String dni = request.getParameter("txtDni");
		String cuil = request.getParameter("txtCuil");
		String nombre = request.getParameter("txtNombre");
		String apellido = request.getParameter("txtApellido");
		String genero = request.getParameter("ddlGenero");
		String fecha = request.getParameter("txtFecha");
		String direccion = request.getParameter("txtDireccion");
		String nacionalidad = request.getParameter("txtNacionalidad");
		String localidad = request.getParameter("txtLocalidad");
		String provincia = request.getParameter("txtProvincia");
		String correo = request.getParameter("txtCorreo");
		String telefono = request.getParameter("txtTelefono");

		if (hayCamposVacios(dni, cuil, nombre, apellido, genero, fecha, direccion,
				nacionalidad, localidad, provincia, correo, telefono)) {
			request.setAttribute("mensajeError", "Completá todos los campos obligatorios.");
			mostrarFormulario(request, response);
			return;
		}

		if (!genero.equals("M") && !genero.equals("F") && !genero.equals("O")) {
			request.setAttribute("mensajeError", "Seleccioná un género válido.");
			mostrarFormulario(request, response);
			return;
		}

		try {
			LocalDate fechaNacimiento = LocalDate.parse(fecha);
			if (fechaNacimiento.isAfter(LocalDate.now())) {
				request.setAttribute("mensajeError", "La fecha de nacimiento no puede ser futura.");
				mostrarFormulario(request, response);
				return;
			}
		} catch (DateTimeParseException e) {
			request.setAttribute("mensajeError", "Ingresá una fecha de nacimiento válida.");
			mostrarFormulario(request, response);
			return;
		}

		Boolean agregado = negocioClientes.agregarCliente(dni, cuil, nombre, apellido, genero.charAt(0), fecha,
				direccion, nacionalidad, localidad, provincia, correo, telefono);

		if (Boolean.TRUE.equals(agregado)) {
			request.setAttribute("mensajeExito", "Cliente guardado correctamente.");
		} else {
			request.setAttribute("mensajeError", "No se pudo guardar el cliente.");
		}

		mostrarFormulario(request, response);
    }

	private boolean hayCamposVacios(String... campos) {
		for (String campo : campos) {
			if (campo == null || campo.isBlank()) {
				return true;
			}
		}
		return false;
    }

	private void mostrarFormulario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("Fecha", LocalDate.now());
		request.getRequestDispatcher("/Formulario.jsp").forward(request, response);
    }
}
