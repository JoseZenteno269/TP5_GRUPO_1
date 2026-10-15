package Entidades;

public class Usuario {

	//Attributos
	
		private int idUsuario;
		private String user;
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

		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}

		public String getPassword() {
			return Password;
		}

		public void setPassword(String password) {
			Password = password;
		}
		
}
