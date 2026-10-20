package Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import Entidades.Clientes;
import Negocio.NegocioClientes;

@WebServlet("/ServletClientes")
public class ServletClientes extends HttpServlet {
	NegocioClientes negocioClientes = new NegocioClientes(); 
	
	private static final long serialVersionUID = 1L;
       
    public ServletClientes() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("accion");
		
		if("listado".equals(accion)) {
			ArrayList<Clientes> aClientes = negocioClientes.obtenerClientes(); 
			request.setAttribute("Clientes", aClientes);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Listado.jsp"); 
			dispatcher.forward(request, response); 
		} 
		else if("formulario".equals(accion)) {
			LocalDate fecha = LocalDate.now(); 
			request.setAttribute("Fecha", fecha);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Formulario.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnGuardar") != null) {
			
			String dni = request.getParameter("txtDni"); 
			String cuil = request.getParameter("txtCuil"); 
			String nombre = request.getParameter("txtNombre");
			String apellido = request.getParameter("txtApellido"); 
			String genero = request.getParameter("ddlGenero");
			String nacionalidad = request.getParameter("txtNacionalidad");
			String fecha = request.getParameter("txtFecha");
			String direccion = request.getParameter("txtDireccion");
			String localidad = request.getParameter("txtLocalidad");
			String provincia = request.getParameter("txtProvincia");
			String correo = request.getParameter("txtCorreo");
			String telefono = request.getParameter("txtTelefono"); 
			
			Boolean estado = false; 
			estado = negocioClientes.agregarCliente(dni, cuil, nombre, apellido, genero, fecha, direccion, nacionalidad, localidad, provincia, correo, telefono);
			request.setAttribute("Estado", estado);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Formulario.jsp");
			dispatcher.forward(request, response); 
		}
		
	}

}
