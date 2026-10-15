package I_Datos;

import java.sql.Connection;
import java.sql.SQLException;

public interface I_Datos {

    Connection obtenerConexion() throws SQLException;
    
    public int EjecutarAccionIUD(String consulta, Object[] parametros);
    		
    public int EjecutarAccionSELECT(String consulta, Object[] parametros);
}
