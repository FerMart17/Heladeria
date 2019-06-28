/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.bean.LoginBean;
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
        Usuario usuario = loginBean.validarUsuario(getNombreUs(),getPassUs());
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+getNombreUs());
        if(usuario == null){
            FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Credenciales Invalidas","Credenciales Invalidas");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
            System.out.println("bbbbbbbbbbbbbbbbbbbbb");
        }
        else
        {
            System.out.println("llllllllllllllllllll");
            FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_INFO,"Usuario Valido","Usuario Valido");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioValidado", usuario); 
            //se guarda el "usuario" con el nombre "usuarioValidado" en el SessionMap del Context
            if(usuario.getTipoUsuario().equals("ADMINISTRADOR")){
                resultado="paginaAdministrador?faces-redirect=true";
                System.out.println("hhhhhhhhhhhhhhhh");
            }
            else{
                resultado="paginaCliente?faces-redirect=true";
                System.out.println("mmmmmmmmmmmmmmmmmmmmmmmm");
            }
            
        }
        return resultado;
    }
    /**
     * Metodo get que ayuda a disponer del usuario cuando se lo necesite
     * actuará como un atributo de la Clase
     * @return usuario
     */
    public String getNombreUsuarioValidado (){
        Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado"); 
        //crea un usuario con el usuarioValidado extraido del contexto
        return usuario.getApellidos();
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
