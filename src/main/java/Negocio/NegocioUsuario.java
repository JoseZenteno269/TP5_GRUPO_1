package Negocio;


import Datos.DaoUsuarios;
import Entidades.Usuario;
import I_Negocio.I_NegocioUsuarios;

public class NegocioUsuario implements I_NegocioUsuarios {

	DaoUsuarios daoUsuarios = new DaoUsuarios();

	@Override
	public Boolean validarUsuario(String user, String password) {
		Usuario usuario = new Usuario();
		usuario.setUser(user);
		usuario.setPassword(password);
		
		return daoUsuarios.validarUsuario(usuario);
	}

}
