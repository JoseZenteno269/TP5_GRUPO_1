package Negocio;

import Datos.DaoUsuarios;
import Entidades.Usuarios;
import I_Negocio.I_NegocioUsuarios;

public class NegocioUsuarios implements I_NegocioUsuarios {
	
	DaoUsuarios daoUsuarios = new DaoUsuarios(); 

	@Override
	public Boolean validarUsuario(String usuario, String password) {
		
		Usuarios usuarios = new Usuarios(); 
		
		usuarios.setUsuario(usuario);
		usuarios.setPassword(password);
		
		return daoUsuarios.validarUsuario(usuarios); 
	}

}
