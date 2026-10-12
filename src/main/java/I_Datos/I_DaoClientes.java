package I_Datos;

import java.util.ArrayList;

import Entidades.Clientes;

public interface I_DaoClientes {

    boolean agregarCliente(Clientes cliente);

    ArrayList<Clientes> listarClientes();
    boolean existeEmail(String email);
}
