/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean;

import aplicacion.modelo.dominio.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author HP
 */
@ManagedBean
@ViewScoped
public class LoginFormBean {
    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBean;
    private String nombreUs;
   private String passUs;

    public LoginFormBean(LoginBean loginBean, String nombreUs, String passUs) {
        this.loginBean = loginBean;
        this.nombreUs = nombreUs;
        this.passUs = passUs;
    }

    public LoginFormBean() {
        loginBean=new LoginBean ();
    }

    

    public String validarUsuario(){
        String resultado=null;
        Usuario usuario = loginBean.validarUsuario(nombreUs,passUs);
        if(usuario == null){
            FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Credenciales Invalidas","Credenciales Invalidas");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
        }
        else
        {
            FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_INFO,"Usuario Valido","Usuario Valido");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioValidado", usuario);
            resultado="busquedalibros?faces-redirect=true"; //¿busqueda libros?
        }
        return resultado;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public String getNombreUs() {
        return nombreUs;
    }

    public void setNombreUs(String nombreUs) {
        this.nombreUs = nombreUs;
    }

    public String getPassUs() {
        return passUs;
    }

    public void setPassUs(String passUs) {
        this.passUs = passUs;
    }
   
}
