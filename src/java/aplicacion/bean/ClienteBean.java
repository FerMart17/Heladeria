package aplicacion.bean;

import aplicacion.dao.IClienteDAO;
import aplicacion.dao.mysql.ClienteDaoImp;
import aplicacion.modelo.dominio.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Sofia Delgado
 */
@ManagedBean
@ViewScoped
public class ClienteBean {

    private List<Cliente> listaClientes;
    private IClienteDAO clienteDAO;
    private Cliente unCliente;

    public ClienteBean(List<Cliente> listaClientes, IClienteDAO clienteDAO, Cliente unCliente) {
        this.listaClientes = listaClientes;
        this.clienteDAO = clienteDAO;
        this.unCliente = unCliente;
    }

    
    public ClienteBean() {
        clienteDAO= new ClienteDaoImp();
        listaClientes=new ArrayList<>();
    }
   
    public Cliente obtenerCliente (int dni){
        return getClienteDAO().obtenerCliente(dni);
    }
    public void modificarCliente (Cliente unCliente){
        getClienteDAO().modificarCliente(unCliente);
    }
    public void eliminarCliente (Cliente unCliente){
        getClienteDAO().eliminarCliente(unCliente);
    }
    public List <Cliente> obtenerListaClientesActivos(){
        return getClienteDAO().obtenerListaClientesActivos();
    }
    public void agregarUsuario (Cliente unCliente){
        getClienteDAO().agregarCliente(unCliente);
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public IClienteDAO getClienteDAO() {
        return clienteDAO;
    }

    public void setClienteDAO(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public Cliente getUnCliente() {
        return unCliente;
    }

    public void setUnCliente(Cliente unCliente) {
        this.unCliente = unCliente;
    }
    
}
