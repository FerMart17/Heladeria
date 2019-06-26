/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apliacion.form.bean;

import apliacion.form.bean.UsuarioBean;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author BRENDA
 */
@ManagedBean
@ViewScoped
public class UsuarioFormBean implements Serializable{
    @ManagedProperty(value = "#{usuarioBean}")
    private UsuarioBean usuarioBean;
    private Usuario unUsuario;
    private String nombre;
    private List<Usuario> listaUsarios;

    /**
     * Creates a new instance of UsuarioFormBean
     */
    public UsuarioFormBean() {
        
    }
    public  void init(){
        unUsuario=new Usuario();
        listaUsarios=new ArrayList<>();
    }
    
    public UsuarioFormBean(UsuarioBean usuarioBean, Usuario unUsuario, String nombre, List<Usuario> listaUsarios) {
        this.usuarioBean = usuarioBean;
        this.unUsuario = unUsuario;
        this.nombre = nombre;
        this.listaUsarios = listaUsarios;
    }
    public Usuario validarUsuario ( String  nombreUsuario ,String password ){
        String resultado=null;
        Usuario unUsuario = usuarioBean.validarUsuario(nombreUsuario, password);
        if(unUsuario== null){
            FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Credenciales Invalidas","Credenciales Invalidas");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
        }
        else
        {
            FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Producto Valido", "ProductoValido");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioValidado", unUsuario);
            if (unUsuario.getNombreUsuario().equals("usuario")){
                    resultado="usuario?faces-redirect=true";
            }
            else
                {
                resultado="usuarios";
                }  
        }
       return unUsuario;
    }
       public Usuario obtenerUsuario (String nombreUsuario){
        String resultado=null;
        Usuario unUsuario = usuarioBean.obtenerUsuario(nombreUsuario);
        if(unUsuario== null){
            FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Credenciales Invalidas","Credenciales Invalidas");
            FacesContext.getCurrentInstance().addMessage(null, facesmessage);
        }
        else
        {
            FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Producto Valido", "ProductoValido");
            if (unUsuario.getNombreUsuario().equals("usuario")){
                    resultado="usuario?faces-redirect=true";
            }
            else
                {
                resultado="usuarios";
                }  
        }
       return unUsuario;
    }
  
    
     public void agregarUsuario (Usuario unUsuario){
        getUnUsuario().setEstado(true);
        if(getListaUsarios()!=null){
            getUsuarioBean().agregarUsuario(getUnUsuario());
            FacesMessage facesMessage=new FacesMessage
                (FacesMessage.SEVERITY_INFO,"Usuario agregado correctamente ","Usuario"+getUnUsuario().getTipoUsuario());
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        else {
            FacesMessage facesMessage=new FacesMessage
                (FacesMessage.SEVERITY_WARN,"Error grave", "No se puede agregar usuarios");
           FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        setUnUsuario(new Usuario());
    }
    
    public void modificarUsuario (Usuario unUsuario){
       getUnUsuario().setEstado(true);
        if(getListaUsarios()!=null){
            getUsuarioBean().modificarUsuario(unUsuario);
            FacesMessage facesMessage=new FacesMessage
                (FacesMessage.SEVERITY_INFO,"Usuario modificado correctamente ","Usuario"+getUnUsuario().getTipoUsuario());
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        else {
            FacesMessage facesMessage=new FacesMessage
                (FacesMessage.SEVERITY_WARN,"Error grave", "No se puede modificar usuario");
           FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        setUnUsuario(unUsuario);
    }
    public void eliminarUsuario (Usuario unUsuario){
        getUnUsuario().setEstado(true);
        if(getListaUsarios()!=null){
            getUsuarioBean().eliminarUsuario(unUsuario);
            FacesMessage facesMessage=new FacesMessage
                (FacesMessage.SEVERITY_INFO,"Usuario eliminado correctamente ","Usuario"+getUnUsuario().getTipoUsuario());
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        else {
            FacesMessage facesMessage=new FacesMessage
                (FacesMessage.SEVERITY_WARN,"Error grave", "No se puede eliminar usuarios");
           FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        setUnUsuario(unUsuario);
    }
    
    /**
     * @return the usuarioBean
     */
    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    /**
     * @param usuarioBean the usuarioBean to set
     */
    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    /**
     * @return the unUsuario
     */
    public Usuario getUnUsuario() {
        return unUsuario;
    }

    /**
     * @param unUsuario the unUsuario to set
     */
    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the listaUsarios
     */
    public List<Usuario> getListaUsarios() {
        return listaUsarios;
    }

    /**
     * @param listaUsarios the listaUsarios to set
     */
    public void setListaUsarios(List<Usuario> listaUsarios) {
        this.listaUsarios = listaUsarios;
    }
    
}
