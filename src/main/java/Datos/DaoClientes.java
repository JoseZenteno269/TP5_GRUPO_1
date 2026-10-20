package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.Clientes;
import I_Datos.I_DaoClientes;

public class DaoClientes implements I_DaoClientes {
	
	Datos datos = new Datos(); 

	@Override
	public Boolean agregarCliente(Clientes clientes) {
		Object[] parametros = {clientes.getDni(), clientes.getCuil(), clientes.getNombre(), clientes.getApellido(), clientes.getSexo(), 
				clientes.getFecha_nacimiento(), clientes.getDireccion(), clientes.getNacionalidad(), clientes.getLocalidad(), clientes.getProvincia(), 
				clientes.getCorreo_electronico(), clientes.getTelefono()};
		
		return datos.EjecutarAccionIUD("INSERT INTO clientes (dni, cuil, nombre, apellido, sexo, fecha_nacimiento, "
				+ "direccion, nacionalidad, localidad, provincia, correo_electronico, telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", 
				parametros) != 0;
	}

	@Override
	public ArrayList<Clientes> obtenerClientes() {
		
		String consulta = "SELECT dni, cuil, nombre, apellido, sexo, fecha_nacimiento, direccion, nacionalidad, localidad, provincia, correo_electronico, telefono FROM Clientes";
		ArrayList<Clientes> aClientes = new ArrayList<Clientes>(); 
		
		try(Connection connection = datos.obtenerConexion(); 
			PreparedStatement preparedStatement = connection.prepareStatement(consulta);
			ResultSet resultSet = preparedStatement.executeQuery();){
			
			while(resultSet.next()) {
				Clientes clientes = new Clientes(); 
				
				clientes.setDni(resultSet.getString(1));
				clientes.setCuil(resultSet.getString(2));
				clientes.setNombre(resultSet.getString(3));
				clientes.setApellido(resultSet.getString(4));
				clientes.setSexo(resultSet.getString(5));
				clientes.setFecha_nacimiento(resultSet.getString(6));
				clientes.setDireccion(resultSet.getString(7));
				clientes.setNacionalidad(resultSet.getString(8));
				clientes.setLocalidad(resultSet.getString(9));
				clientes.setProvincia(resultSet.getNString(10));
				clientes.setCorreo_electronico(resultSet.getString(11));
				clientes.setTelefono(resultSet.getString(12));
				
				aClientes.add(clientes); 
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return aClientes; 
	}

}
