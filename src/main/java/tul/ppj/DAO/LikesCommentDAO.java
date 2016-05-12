package tul.ppj.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tul.ppj.entities.LikesComment;

/**
 * Created by Marek on 12.05.2016.
 */
@Component
public class LikesCommentDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public LikesCommentDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public LikesCommentDAO() {

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Transactional
    public void insert(LikesComment likesComment) {

        Session session = getSessionFactory().getCurrentSession();

        session.save(likesComment);


    }

}
