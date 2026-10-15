package I_Negocio;

import java.util.ArrayList;
import Entidades.Clientes;

public interface I_NegocioClientes {
	
	public Boolean agregarCliente(String dni, String cuil, String nombre, String apellido, String sexo, String fecha_nacimiento, 
			String direccion, String nacionalidad, String localidad, String provincia, String correo, String telefono);
	
	public ArrayList<Clientes> obtenerClientes();

}
