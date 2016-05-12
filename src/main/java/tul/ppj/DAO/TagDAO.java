package tul.ppj.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import tul.ppj.entities.Autor;
import tul.ppj.entities.Tags;

import java.util.List;

/**
 * Created by Marek on 12.05.2016.
 */
@Component
public class TagDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public TagDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public TagDAO() {

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Transactional
    public void insert(Tags tag) {

        Session session = getSessionFactory().getCurrentSession();

        session.save(tag);


    }
    @Transactional
    public Tags getTag(int id) {

        List<Tags> myList = sessionFactory.getCurrentSession().createQuery("from Tags where ID_Tags ='" + id + "'").list();
        if (myList.isEmpty()) {
            return null;
        } else {
            return myList.get(0);
        }

    }
}
