package aplicacion.bean;


import aplicacion.dao.IUsuarioDAO;
import aplicacion.dao.mysql.UsuarioDaoImp;
import aplicacion.modelo.dominio.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Sofia Delgado
 */
@ManagedBean
@ViewScoped
public class LoginBean {
    
    
    public Usuario validarUsuario(String nombreUsuario, String password){
        
        IUsuarioDAO usuarioDAO = new UsuarioDaoImp();
        return usuarioDAO.validarUsuario(nombreUsuario, password);
    }
    
    public LoginBean() {
    }
    
}
