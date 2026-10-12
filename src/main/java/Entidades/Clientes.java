package Entidades;

public class Clientes {

	// Attributos
	
		private int idCliente;
		private String DNI;
		private String cuil;
		private String nombre;
		private String Apellido;
		private Character sexo;
		private String FechaNacimiento;
		private String domicilio;
		private String Nacionalidad;
		private String Localidad;
		private String Provincia;
		private String email;
		private String Telefono;
		
		// Constructor
		
		public Clientes() {}

		// Setters y Getters
		
		public int getIdCliente() {
			return idCliente;
		}

		public void setIdCliente(int idCliente) {
			this.idCliente = idCliente;
		}

		public String getDNI() {
			return DNI;
		}

		public void setDNI(String dNI) {
			DNI = dNI;
		}

		public String getCuil() {
			return cuil;
		}

		public void setCuil(String cuil) {
			this.cuil = cuil;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return Apellido;
		}

		public void setApellido(String apellido) {
			Apellido = apellido;
		}

		public Character getSexo() {
			return sexo;
		}

		public void setSexo(Character sexo) {
			this.sexo = sexo;
		}

		public String getFechaNacimiento() {
			return FechaNacimiento;
		}

		public void setFechaNacimiento(String fechaNacimiento) {
			FechaNacimiento = fechaNacimiento;
		}

		public String getDomicilio() {
			return domicilio;
		}

		public void setDomicilio(String domicilio) {
			this.domicilio = domicilio;
		}

		public String getNacionalidad() {
			return Nacionalidad;
		}

		public void setNacionalidad(String nacionalidad) {
			Nacionalidad = nacionalidad;
		}

		public String getLocalidad() {
			return Localidad;
		}

		public void setLocalidad(String localidad) {
			Localidad = localidad;
		}

		public String getProvincia() {
			return Provincia;
		}

		public void setProvincia(String provincia) {
			Provincia = provincia;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getTelefono() {
			return Telefono;
		}

		public void setTelefono(String telefono) {
			Telefono = telefono;
		}

}
