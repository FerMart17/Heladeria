/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.form.bean;

import aplicacion.bean.ClienteBean;
import aplicacion.modelo.dominio.Cliente;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Sofia Delgado
 */
@ManagedBean
@ViewScoped
public class ClienteFormBean implements Serializable{
    @ManagedProperty(value = "#{clienteBean}")
    private ClienteBean clienteBean;
    private Cliente unCliente;
    private String nombre;
    private List<Cliente> listaClientes;
    private Usuario unUsuario;
    public ClienteFormBean() {
        unCliente=new Cliente();
        listaClientes=new ArrayList<>();
        unUsuario=new Usuario();
    }

    public ClienteFormBean(ClienteBean clienteBean, Cliente unCliente, String nombre, List<Cliente> listaClientes, Usuario unUsuario) {
        this.clienteBean = clienteBean;
        this.unCliente = unCliente;
        this.nombre = nombre;
        this.listaClientes = listaClientes;
        this.unUsuario = unUsuario;
    }
    
       public Cliente obtenerCliente (int dni){
        return null;
    }


     public void agregarCliente (Cliente unCliente){
         getUnUsuario().setEstado(true);
         getUnUsuario().setTipoUsuario("");
       
    }

    public void modificarCliente (Cliente unCliente){
       
    }
    public void eliminarCliente (Cliente unCliente){
       
    }

    public ClienteBean getClienteBean() {
        return clienteBean;
    }

    public void setClienteBean(ClienteBean clienteBean) {
        this.clienteBean = clienteBean;
    }

    public Cliente getUnCliente() {
        return unCliente;
    }

    public void setUnCliente(Cliente unCliente) {
        this.unCliente = unCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }
    
    
}
