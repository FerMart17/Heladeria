package aplicacion.dao;

import aplicacion.modelo.dominio.Usuario;
import java.util.List;

/**
 *  Interfaz del objeto Usuario
 * @author Sofia Delgado
 */
public interface IUsuarioDAO {
    Usuario validarUsuario (String nombreUsuario, String password);
    Usuario obtenerUsuario (String nombreUsuario);
    void modificarUsuario (Usuario unUsuario);
    void eliminarUsuario (Usuario unUsuario);
    public List <Usuario> obtenerListaUsuariosActivos();
    public void agregarUsuario (Usuario unUsuario);
}
