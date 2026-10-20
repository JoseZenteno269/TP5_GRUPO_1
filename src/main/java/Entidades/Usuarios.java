package Entidades;

public class Usuarios {
	
	private String usuario;
	private String password; 
	
	public Usuarios() {
		usuario = "Sin definir"; 
		password = "Sin definir";
	}
	
	public Usuarios(String usuario, String password) {
		this.usuario = usuario; 
		this.password = password; 
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuarios [usuario=" + usuario + ", password=" + password + "]";
	}

}
