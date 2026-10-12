package I_Datos;

import java.sql.Connection;
import java.sql.SQLException;

public interface I_Datos {

    Connection obtenerConexion() throws SQLException;

    int ejecutarAccion(String consulta, Object[] parametros);
}
