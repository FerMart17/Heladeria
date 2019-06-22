package aplicacion.dao.mysql;

import aplicacion.dao.IProductoDAO;
import aplicacion.hibernate.configuracion.NewHibernateUtil;
import aplicacion.modelo.dominio.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Sofia Delgado
 */
@ManagedBean
@ViewScoped
public class ProductoDaoImp implements IProductoDAO{

    /**
     * Implementacion del DAO de Producto
     */
    public ProductoDaoImp() {
    }
    /**
     * Metodo abstracto para validar un producto
     * @param nombreProducto
     * @param codigo
     * @return 
     */
    @Override
    public Producto validarProducto(String nombreProducto, int codigo) {
        Producto p = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.like("nombreProducto",nombreProducto));
        criteria.add(Restrictions.like("codigo",codigo));
        criteria.add(Restrictions.eq("estado",true));
        if(!criteria.list().isEmpty())
           p=(Producto)criteria.list().get(0);
        session.getTransaction().commit();
        session.close();
        return p;
    }
    /**
     * Metodo abstracto para obtener un producto mediante el nombre del producto
     * @param nombreProducto
     * @return producto
     */
    @Override
    public Producto obtenerProducto(String nombreProducto) {
        Producto p = null;
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.like("nombreProducto",nombreProducto));
        if(!criteria.list().isEmpty())
           p=(Producto)criteria.list().get(0);
        session.getTransaction().commit();
        session.close();
        return p;
    }

    @Override
    public void modificarProducto(Producto unProducto) {
        Session session=NewHibernateUtil.getSessionFactory().openSession();//se abre la sesion
        session.beginTransaction();//se comienza la transaccion en la sesion
        session.update(unProducto);
        session.getTransaction().commit();
        session.close(); //se cierra la sesion
    }

    @Override
    public void eliminarProducto(Producto unProducto) {
        Session session=NewHibernateUtil.getSessionFactory().openSession();//se abre la sesion
        session.beginTransaction();//se comienza la transaccion en la sesion
        session.delete(unProducto);
        session.getTransaction().commit();
        session.close(); //se cierra la sesion
    }

    @Override
    public List<Producto> obtenerListaProductosCatalogo() {
     List <Producto> listado= new ArrayList();
        Session session=NewHibernateUtil.getSessionFactory().openSession();//se abre la sesion
        session.beginTransaction();//se comienza la transaccion en la sesion
        Criteria criteria =session.createCriteria(Producto.class);
        criteria.add(Restrictions.like("estado",true));
        listado=criteria.list();
        session.getTransaction().commit();
        session.close(); //se cierra la sesion
         return listado;
    }

    @Override
    public void agregarProducto(Producto unProducto) {
         Session session=NewHibernateUtil.getSessionFactory().openSession();//se abre la sesion
        session.beginTransaction();//se comienza la transaccion en la sesion
        session.save(unProducto); //Para agregar un usuario
        session.getTransaction().commit();
        session.close(); //se cierra la sesion
    }
    
}
