package aplicacion.dao.mysql;

import aplicacion.dao.IClienteDAO;
import aplicacion.hibernate.configuracion.NewHibernateUtil;
import aplicacion.modelo.dominio.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Sofia Deñgado
 */
@ManagedBean
@ViewScoped
public class ClienteDaoImp implements IClienteDAO, Serializable{

    public ClienteDaoImp() {
    }

    @Override
    public Cliente obtenerCliente(int dni) {
        Cliente c = null;
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.like("dniCliente",dni));
        if(!criteria.list().isEmpty())
           c=(Cliente)criteria.list().get(0);
        session.getTransaction().commit();
        session.close();
        return c;
    }

    @Override
    public void modificarCliente(Cliente unCliente) {
        Session session=NewHibernateUtil.getSessionFactory().openSession();//se abre la sesion
        session.beginTransaction();//se comienza la transaccion en la sesion
        session.update(unCliente);
        session.getTransaction().commit();
        session.close(); //se cierra la sesion
    }

    @Override
    public void eliminarCliente(Cliente unCliente) {
        Session session=NewHibernateUtil.getSessionFactory().openSession();//se abre la sesion
        session.beginTransaction();//se comienza la transaccion en la sesion
        session.delete(unCliente);
        session.getTransaction().commit();
        session.close(); //se cierra la sesion
    }

    @Override
    public List<Cliente> obtenerListaClientesActivos() {
        List <Cliente> listado= new ArrayList();
        Session session=NewHibernateUtil.getSessionFactory().openSession();//se abre la sesion
        session.beginTransaction();//se comienza la transaccion en la sesion
        Criteria criteria =session.createCriteria(Cliente.class);
        criteria.add(Restrictions.like("estado",true));
        listado=criteria.list();
        session.getTransaction().commit();
        session.close(); //se cierra la sesion
         return listado;
    }

    @Override
    public void agregarCliente(Cliente unCliente) {
        Session session=NewHibernateUtil.getSessionFactory().openSession();//se abre la sesion
        session.beginTransaction();//se comienza la transaccion en la sesion
        session.save(unCliente); //Para agregar un usuario
        session.getTransaction().commit();
        session.close(); //se cierra la sesion
    }
    
}
