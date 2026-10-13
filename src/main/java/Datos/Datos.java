package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import I_Datos.I_Datos;

public class Datos implements I_Datos{
	
    private String host = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String pass = "root";
    private String dbName = "sistema_clientes";
    
    public Datos() {
    	
    }
    
    @Override
    public Connection obtenerConexion() throws SQLException {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(host + dbName + "?useSSL=false&serverTimezone=UTC", user, pass);
    }
    
    @Override
	public int ejecutarAccion(String consulta, Object[] parametros) {
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

}
