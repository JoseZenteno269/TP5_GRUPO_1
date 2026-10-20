package Negocio;

import java.util.ArrayList;

import Datos.DaoClientes;
import Entidades.Clientes;
import I_Negocio.I_NegocioClientes;

public class NegocioClientes implements I_NegocioClientes{
	
	DaoClientes daoClientes = new DaoClientes();

	@Override
	public Boolean agregarCliente(String dni, String cuil, String nombre, String apellido, String sexo,
			String fecha_nacimiento, String direccion, String nacionalidad, String localidad, String provincia,
			String correo, String telefono) {
		
		Clientes clientes = new Clientes(); 
		
		clientes.setDni(dni);
		clientes.setCuil(cuil);
		clientes.setNombre(nombre);
		clientes.setApellido(apellido);
		clientes.setSexo(sexo);
		clientes.setFecha_nacimiento(fecha_nacimiento);
		clientes.setDireccion(direccion);
		clientes.setNacionalidad(nacionalidad);
		clientes.setLocalidad(localidad);
		clientes.setProvincia(provincia);
		clientes.setCorreo_electronico(correo);
		clientes.setTelefono(telefono);
		
		return daoClientes.agregarCliente(clientes);
	}

	@Override
	public ArrayList<Clientes> obtenerClientes() {
		return daoClientes.obtenerClientes();
	}

}
