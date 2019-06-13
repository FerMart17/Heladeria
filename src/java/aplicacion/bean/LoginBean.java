/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;


import aplicacion.dao.IUsuarioDAO;
import aplicacion.dao.mysql.UsuarioDaoImp;
import aplicacion.modelo.dominio.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author HP
 */
@ManagedBean
@ViewScoped
public class LoginBean {
    
    
    public Usuario validarUsuario(String nombreUsuario, String password){
        IUsuarioDAO usuarioDAO = new UsuarioDaoImp();
        return usuarioDAO.validarUsuario(nombreUsuario, password);
    }
    
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
    
}
