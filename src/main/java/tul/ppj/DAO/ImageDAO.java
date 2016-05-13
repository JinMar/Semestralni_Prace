package tul.ppj.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tul.ppj.entities.Autor;
import tul.ppj.entities.Images;

import java.util.List;

/**
 * Created by Marek on 12.05.2016.
 */
@Component
public class ImageDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public ImageDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ImageDAO() {

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void insert(Images images) {
        System.out.println("Image Saving");
        Session session = getSessionFactory().getCurrentSession();

        session.save(images);


    }
    @Transactional
    public Images getImages(int id) {

        List<Images> myList = sessionFactory.getCurrentSession().createQuery("from Images where ID_images ='" + id + "'").list();
        if (myList.isEmpty()) {
            return null;
        } else {
            return myList.get(0);
        }

    }
    @Transactional
    public int getCountImages() {

        List<Images> myList = sessionFactory.getCurrentSession().createQuery("from Images" ).list();
        return myList.size();

    }
}
