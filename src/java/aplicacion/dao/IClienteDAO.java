package aplicacion.dao;

import aplicacion.modelo.dominio.Cliente;
import java.util.List;

/**
 * EN PROCESO
 * @author Sofia Delgado
 */
public interface IClienteDAO {
    Cliente obtenerCliente (int dni);
    void modificarCliente (Cliente unCliente);
    void eliminarCliente (Cliente unCliente);
    public List <Cliente> obtenerListaClientesActivos();
    public void agregarCliente (Cliente unCliente);
}
