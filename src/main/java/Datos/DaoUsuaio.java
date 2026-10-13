package Datos;

import Entidades.Usuario;
import I_Datos.I_DaoUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DaoUsuaio implements I_DaoUsuario {

	@Override
	public Usuario validarUsuario(String usuario, String contrasenia) {
		
		String consulta = "SELECT * FROM usuarios AS u WHERE u.usuario = ? AND u.contrasena = ?";
		
		Datos datos = new Datos();
		try(Connection conexion = datos.obtenerConexion();
			PreparedStatement ps = conexion.prepareStatement(consulta);
			ResultSet RS = ps.executeQuery();) {
			
			ps.setString(1, usuario);
			ps.setString(2, contrasenia);
			
			if(RS.next()) {
				Usuario usuarioEncontrado = new Usuario();
				usuarioEncontrado.setIdUsuario(RS.getInt("id_usuario"));
				usuarioEncontrado.setNombreUsuario(RS.getString("usuario"));
				usuarioEncontrado.setPassword(RS.getString("contrasena"));
				
				return usuarioEncontrado;
			}else
				return null;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
