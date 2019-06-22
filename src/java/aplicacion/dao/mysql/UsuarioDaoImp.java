package aplicacion.dao.mysql;

import aplicacion.dao.IUsuarioDAO;
import aplicacion.hibernate.configuracion.NewHibernateUtil;
import aplicacion.modelo.dominio.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Sofia Delgado
 */
@ManagedBean
@ViewScoped
public class UsuarioDaoImp implements IUsuarioDAO{

    //Implementacion del DAO de Usuario
    public UsuarioDaoImp() {
    }
    /**
     * Metodo Abstracto para validar un Usuario ingresado por pantalla
     * @param nombreUsuario
     * @param password (contraseña del usuario)
     * @return 
     */
    @Override
    public Usuario validarUsuario(String nombreUsuario, String password) {
        Usuario u = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.like("nombreUsuario",nombreUsuario));
        criteria.add(Restrictions.like("password",password));
        criteria.add(Restrictions.eq("estado",true));
        if(!criteria.list().isEmpty())
           u=(Usuario)criteria.list().get(0);
        session.getTransaction().commit();
        session.close();
        return u;
    }
    /**
     * Metodo abstracto para obtener un usuario con el nombre
     * @param nombreUsuario
     * @return 
     */
    @Override
    public Usuario obtenerUsuario(String nombreUsuario) {
        Usuario u=null;
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.like("nombreUser",nombreUsuario));
        if(!criteria.list().isEmpty())
           u=(Usuario)criteria.list().get(0);
        session.getTransaction().commit();
        session.close();
        return u;
    }
    /**
     * Metodo abstracto que devuelve la lista de usuario activos
     * @return listado
     */
    @Override
    public List <Usuario> obtenerListaUsuariosActivos(){
        List <Usuario> listado= new ArrayList();
        Session session=NewHibernateUtil.getSessionFactory().openSession();//se abre la sesion
        session.beginTransaction();//se comienza la transaccion en la sesion
        Criteria criteria =session.createCriteria(Usuario.class);
        criteria.add(Restrictions.like("estado",true));
        listado=criteria.list();
        session.getTransaction().commit();
        session.close(); //se cierra la sesion
         return listado;
    }
    /**
     * Metodo abstracto para modificar un usuario mediante session.update
     * @param unUsuario 
     */
    @Override
    public void modificarUsuario(Usuario unUsuario){
       Session session=NewHibernateUtil.getSessionFactory().openSession();//se abre la sesion
        session.beginTransaction();//se comienza la transaccion en la sesion
        session.update(unUsuario);
        session.getTransaction().commit();
        session.close(); //se cierra la sesion
    }
    /**
     * Metodo abstracto para eliminar un usuario mediante session.delete
     * @param unUsuario 
     */
    @Override
    public void eliminarUsuario(Usuario unUsuario) {
        Session session=NewHibernateUtil.getSessionFactory().openSession();//se abre la sesion
        session.beginTransaction();//se comienza la transaccion en la sesion
        session.delete(unUsuario);
        session.getTransaction().commit();
        session.close(); //se cierra la sesion
    }
   /**
    * Metodo abstracto para agregar un usuario mediante session.save
    * @param unUsuario 
    */
    @Override
    public void agregarUsuario(Usuario unUsuario){
        Session session=NewHibernateUtil.getSessionFactory().openSession();//se abre la sesion
        session.beginTransaction();//se comienza la transaccion en la sesion
        session.save(unUsuario); //Para agregar un usuario
        session.getTransaction().commit();
        session.close(); //se cierra la sesion
    }
    
}
