package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Datos {
	
    private String host = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String pass = "asusrog7";
    private String dbName = "sistema_clientes";
    
    public Datos() {
    	
    }
    
    public Connection obtenerConexion() throws SQLException {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(host + dbName, user, pass);
    }
    
    /**
     * Ejecuta una consulta SQL de tipo INSERT, UPDATE o DELETE.
     *
     * @param consulta Consulta SQL a ejecutar.
     * @param parametros Parámetros que se asignarán a la consulta.
     * @return Cantidad de filas afectadas.
     */
    public int EjecutarAccionIUD(String consulta, Object[] parametros) {
		int filasafectadas = 0; 
		
		try(Connection connection = obtenerConexion(); 
			PreparedStatement preparedStatement = connection.prepareStatement(consulta);){
			
			for(int i = 0; i < parametros.length; i ++) {
				preparedStatement.setObject(i + 1, parametros[i]);
			}
			
			filasafectadas = preparedStatement.executeUpdate(); 
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return filasafectadas; 
	}
	
    /**
    * Ejecuta una consulta SQL de tipo SELECT y verifica si devuelve al menos una fila.
	*
    * @param consulta Consulta SQL que se desea ejecutar.
    * @param parametros Valores que serán asignados a los parámetros de la consulta.
    * @return 1 si la consulta devuelve al menos una fila, 0 si no devuelve ninguna.
    */
	public int EjecutarAccionSELECT(String consulta, Object[] parametros) {
		
		try(Connection connection = obtenerConexion(); 
			PreparedStatement preparedStatement = connection.prepareStatement(consulta);){
			
			for(int i = 0; i < parametros.length; i ++) {
				preparedStatement.setObject(i + 1, parametros[i]);
			}
			
			try(ResultSet resultSet = preparedStatement.executeQuery()){
				return resultSet.next() ? 1 : 0; 
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0; 
	}

}
