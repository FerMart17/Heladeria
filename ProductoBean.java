/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apliacion.form.bean;

import aplicacion.dao.IProductoDAO;
import aplicacion.dao.mysql.ProductoDaoImp;
import aplicacion.modelo.dominio.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author BRENDA
 */
@ManagedBean
@ViewScoped
public class ProductoBean implements Serializable{
    private Producto unProducto;
    private IProductoDAO productoDao;
    private List<Producto> listaProductos;

    public ProductoBean(Producto unProducto, IProductoDAO productoDao, List<Producto> listaProductos) {
        this.unProducto = unProducto;
        this.productoDao = productoDao;
        this.listaProductos = listaProductos;
    }
    
    /**
     * Creates a new instance of ProductoBean
     */
    public ProductoBean() {
        IProductoDAO productoDAO= new ProductoDaoImp();
        listaProductos= new ArrayList<>();
    }
    public Producto validarProducto (String nombreProducto, int codigo){
       return getProductoDao().validarProducto(nombreProducto, codigo);
     }
    public Producto obtenerProducto (String nombreProducto){
        return getProductoDao().obtenerProducto(nombreProducto);
    }
    void modificarProducto (Producto unProducto){
        getProductoDao().modificarProducto(unProducto);
    }
    void eliminarProducto (Producto unProducto){
        getProductoDao().eliminarProducto(unProducto);
    }
    public List <Producto> obtenerListaProductosCatalogo(){
        return getProductoDao().obtenerListaProductosCatalogo();
    }
    public void agregarProducto (Producto unProducto){
        getProductoDao().agregarProducto(unProducto);
    }
    //metodo consultar producto
    

    /**
     * @return the unProducto
     */
    public Producto getUnProducto() {
        return unProducto;
    }

    /**
     * @param unProducto the unProducto to set
     */
    public void setUnProducto(Producto unProducto) {
        this.unProducto = unProducto;
    }

    /**
     * @return the productoDao
     */
    public IProductoDAO getProductoDao() {
        return productoDao;
    }

    /**
     * @param productoDao the productoDao to set
     */
    public void setProductoDao(IProductoDAO productoDao) {
        this.productoDao = productoDao;
    }

    /**
     * @return the listaProductos
     */
    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    /**
     * @param listaProductos the listaProductos to set
     */
    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
