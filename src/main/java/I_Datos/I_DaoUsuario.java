package I_Datos;

import Entidades.Usuario;

public interface I_DaoUsuario {
    Usuario validarUsuario(String usuario, String contrasenia);
}