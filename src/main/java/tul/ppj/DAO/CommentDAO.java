package tul.ppj.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tul.ppj.entities.Comment;

import java.util.List;

/**
 * Created by Marek on 12.05.2016.
 */
@Component
public class CommentDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public CommentDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public CommentDAO() {

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Transactional
    public void insert(Comment comment) {

        Session session = getSessionFactory().getCurrentSession();

        session.save(comment);


    }
    @Transactional
    public Comment getComment(int id) {

        List<Comment> myList = sessionFactory.getCurrentSession().createQuery("from Comment where ID_Coment ='" + id + "'").list();
        if (myList.isEmpty()) {
            return null;
        } else {
            return myList.get(0);
        }

    }
    @Transactional
    public List<Comment> getAllcoments(int id){
        List<Comment> myList = sessionFactory.getCurrentSession().createQuery("from Comment where ID_images ='" + id + "'").list();
        if (myList.isEmpty()) {
            return null;
        } else {
            return myList;
        }
    }
}
