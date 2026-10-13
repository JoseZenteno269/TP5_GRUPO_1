package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Entidades.Clientes;
import I_Datos.I_DaoClientes;

public class DaoClientes implements I_DaoClientes {

    Datos datos = new Datos();

    @Override
    public boolean agregarCliente(Clientes cliente) {
    	String consulta = "INSERT INTO clientes (dni, cuil, nombre, apellido, sexo, fecha_nacimiento, direccion, nacionalidad, localidad, provincia, correo_electronico, telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        Object[] parametros= {
        	cliente.getDNI(),
        	cliente.getCuil(),
        	cliente.getNombre(),
        	cliente.getApellido(),
        	cliente.getSexo(),
        	cliente.getFechaNacimiento(),
        	cliente.getDomicilio(),
        	cliente.getNacionalidad(),
        	cliente.getLocalidad(),
        	cliente.getProvincia(),
        	cliente.getEmail(),
        	cliente.getTelefono()
        }; 
        
        Datos datos = new Datos();
    	return datos.ejecutarAccion(consulta, parametros) != 0;
    }

    @Override
    public ArrayList<Clientes> listarClientes() {
    	
    	ArrayList<Clientes> listaClientes= new ArrayList<Clientes>();
    	
    	String consulta = "SELECT * FROM clientes";

    	try (Connection conexion = datos.obtenerConexion();
    	     PreparedStatement ps = conexion.prepareStatement(consulta);
    	     ResultSet RS = ps.executeQuery()) {

    	    while(RS.next()) {
    	    	Clientes c = new Clientes();
    	    	
    	    	c.setIdCliente(RS.getInt("id_cliente"));
    	    	c.setDNI(RS.getString("dni"));
    	    	c.setCuil(RS.getString("cuil"));
    	    	c.setNombre(RS.getString("nombre"));
    	    	c.setApellido(RS.getString("apellido"));
    	    	c.setSexo(RS.getString("sexo").charAt(0));
    	    	c.setFechaNacimiento(RS.getString("fecha_nacimiento"));
    	    	c.setDomicilio(RS.getString("direccion"));
    	    	c.setNacionalidad(RS.getString("nacionalidad"));
    	    	c.setLocalidad(RS.getString("localidad"));
    	    	c.setProvincia(RS.getString("provincia"));
    	    	c.setEmail(RS.getString("correo_electronico"));
    	    	c.setTelefono(RS.getString("telefono"));
    	    	
    	    	listaClientes.add(c);
    	    }

    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
        return listaClientes;
    }

    @Override
    public boolean existeEmail(String email) {
		String consulta = "SELECT 1 FROM clientes WHERE correo_electronico = ?";
				
				Datos datos = new Datos();
				try (Connection conexion = datos.obtenerConexion();
					     PreparedStatement ps = conexion.prepareStatement(consulta)) {

					    ps.setString(1, email);

					    try (ResultSet RS = ps.executeQuery()) {
					        return RS.next();
					    }

					} catch (Exception e) {
					    e.printStackTrace();
					}
				return false;

    }
}