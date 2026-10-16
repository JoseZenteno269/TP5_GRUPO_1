package Negocio;

import java.util.ArrayList;

import Datos.DaoClientes;
import Entidades.Clientes;
import I_Negocio.I_NegocioClientes;

public class NegocioClientes implements I_NegocioClientes {
	
	DaoClientes daoCli = new DaoClientes();

	@Override
	public Boolean agregarCliente(String dni, String cuil, String nombre, String apellido, Character sexo, String fecha_nacimiento, String direccion, String nacionalidad, String localidad, String provincia,String correo, String telefono) 
	{
		Clientes clientes = new Clientes();
		
		clientes.setDNI(dni);
		clientes.setCuil(cuil);
		clientes.setNombre(nombre);
		clientes.setApellido(apellido);
		clientes.setSexo(sexo);
		clientes.setFechaNacimiento(fecha_nacimiento);
		clientes.setDomicilio(direccion);
		clientes.setNacionalidad(nacionalidad);
		clientes.setLocalidad(localidad);
		clientes.setProvincia(provincia);
		clientes.setEmail(correo);
		clientes.setTelefono(telefono);
		
		return daoCli.agregarCliente(clientes);
	}

	@Override
	public ArrayList<Clientes> obtenerClientes() {
		return daoCli.listarClientes();
	}

}
