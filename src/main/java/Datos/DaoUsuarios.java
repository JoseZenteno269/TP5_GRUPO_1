package Datos;

import Entidades.Usuario;
import I_Datos.I_DaoUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DaoUsuarios implements I_DaoUsuario {
	
	Datos datos = new Datos();

	@Override
	public Boolean validarUsuario(Usuario usuario) {
		
		Object[] parametros = {usuario.getUser(), usuario.getPassword()}; 
		
		return datos.EjecutarAccionSELECT("SELECT * FROM Usuarios WHERE usuario = ? AND contrasena = ?", parametros) != 0;
	}

}
