package Datos;

import Entidades.Usuarios;
import I_Datos.I_DaoUsuarios;

public class DaoUsuarios implements I_DaoUsuarios {
	
	Datos datos = new Datos(); 

	@Override
	public Boolean validarUsuario(Usuarios usuarios) {
		
		Object[] parametros = {usuarios.getUsuario(), usuarios.getPassword()}; 
		
		return datos.EjecutarAccionSELECT("SELECT * FROM Usuarios WHERE usuario = ? AND contrasena = ?", parametros) != 0;
	}

}
