package I_Datos;

import java.util.ArrayList;

import Entidades.Clientes;

public interface I_DaoClientes {
	
	Boolean agregarCliente(Clientes clientes); 
	
	ArrayList<Clientes> obtenerClientes(); 

}
