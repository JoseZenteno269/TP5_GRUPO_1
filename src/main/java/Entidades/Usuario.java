package Entidades;

public class Usuario {

	//Attributos
	
		private int idUsuario;
		private String NombreUsuario;
		private String Password;
		
		// Constructor
		
		public Usuario() {}
		
		// SETTER Y GETTER
		
		public int getIdUsuario() {
			return idUsuario;
		}

		public void setIdUsuario(int idUsuario) {
			this.idUsuario = idUsuario;
		}

		public String getNombreUsuario() {
			return NombreUsuario;
		}

		public void setNombreUsuario(String nombreUsuario) {
			NombreUsuario = nombreUsuario;
		}

		public String getPassword() {
			return Password;
		}

		public void setPassword(String password) {
			Password = password;
		}
		
}
