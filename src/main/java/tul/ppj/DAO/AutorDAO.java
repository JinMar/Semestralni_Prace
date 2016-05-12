package tul.ppj.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tul.ppj.entities.Autor;

import java.util.List;

/**
 * Created by Marek on 11.05.2016.
 */
@Component
public class AutorDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public AutorDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public AutorDAO() {

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void insert(Autor autor) {

        Session session = getSessionFactory().getCurrentSession();

        session.save(autor);


    }

    @Transactional
    public Autor getAutor(int id) {

        List<Autor> myList = sessionFactory.getCurrentSession().createQuery("from Autor where ID ='" + id + "'").list();
        if (myList.isEmpty()) {
            return null;
        } else {
            return myList.get(0);
        }

    }

}
