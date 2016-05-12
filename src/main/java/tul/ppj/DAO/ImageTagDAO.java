package tul.ppj.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tul.ppj.entities.ImageTag;

import java.util.List;

/**
 * Created by Marek on 12.05.2016.
 */
@Component
public class ImageTagDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public ImageTagDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ImageTagDAO() {

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Transactional
    public void insert(ImageTag imageTag) {
        if(getAutor(imageTag.getImages().getId(),imageTag.getTags().getId())) {
            Session session = getSessionFactory().getCurrentSession();

            session.save(imageTag);
        }

    }
    @Transactional
    public boolean getAutor(int idIMG,int idTag) {

        List<ImageTag> myList = sessionFactory.getCurrentSession().createQuery("from ImageTag where ID_images ='" + idTag + "' and ID_tags ='" + idIMG + "'").list();
        if (myList.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }
}
