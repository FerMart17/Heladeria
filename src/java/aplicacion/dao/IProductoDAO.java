package aplicacion.dao;

import aplicacion.modelo.dominio.Producto;
import java.util.List;

/**
 *
 * @author Sofia Delgado
 */
public interface IProductoDAO {
    Producto validarProducto (String nombreProducto, int codigo);
    Producto obtenerProducto (String nombreProducto);
    void modificarProducto (Producto unProducto);
    void eliminarProducto (Producto unProducto);
    public List <Producto> obtenerListaProductosCatalogo();
    public void agregarProducto (Producto unProducto);
}
