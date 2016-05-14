package tul.ppj.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tul.ppj.DAO.*;
import tul.ppj.POJO.Box;
import tul.ppj.entities.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Marek on 11.05.2016.
 */
@Repository
public class MyRepository {
    @Autowired
    AutorDAO autorDAO;
    @Autowired
    ImageDAO imageDAO;
    @Autowired
    TagDAO tagDAO;
    @Autowired
    LikesDAO likesDAO;
    @Autowired
    ImageTagDAO imageTagDAO;
    @Autowired
    CommentDAO commentDAO;
    @Autowired
    LikesCommentDAO likesCommentDAO;

    public AutorDAO getAutorDAO() {
        return autorDAO;
    }

    public void setAutorDAO(AutorDAO autorDAO) {
        this.autorDAO = autorDAO;
    }

    public ImageDAO getImageDAO() {
        return imageDAO;
    }

    public void setImageDAO(ImageDAO imageDAO) {
        this.imageDAO = imageDAO;
    }

    public TagDAO getTagDAO() {
        return tagDAO;
    }

    public void setTagDAO(TagDAO tagDAO) {
        this.tagDAO = tagDAO;
    }

    public LikesDAO getLikesDAO() {
        return likesDAO;
    }

    public void setLikesDAO(LikesDAO likesDAO) {
        this.likesDAO = likesDAO;
    }

    public ImageTagDAO getImageTagDAO() {
        return imageTagDAO;
    }

    public void setImageTagDAO(ImageTagDAO imageTagDAO) {
        this.imageTagDAO = imageTagDAO;
    }

    public CommentDAO getCommentDAO() {
        return commentDAO;
    }

    public void setCommentDAO(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    public LikesCommentDAO getLikesCommentDAO() {
        return likesCommentDAO;
    }

    public void setLikesCommentDAO(LikesCommentDAO likesCommentDAO) {
        this.likesCommentDAO = likesCommentDAO;
    }

    public void insertAutor(Autor autor) {
        autorDAO.insert(autor);
    }

    public void insertImage(Images images) {
        imageDAO.insert(images);
    }

    public void insertTag(Tags tag) {
        tagDAO.insert(tag);
    }

    public void insertTag(Likes likes) {
        likesDAO.insert(likes);
    }

    public void insertImageTag(ImageTag imageTag) {
        imageTagDAO.insert(imageTag);
    }

    public void insertLikesComment(LikesComment likesComment){likesCommentDAO.insert(likesComment);}

    public void insertComment(Comment comment){commentDAO.insert(comment);}

    public boolean insertAutor(List<Box> list) {
        if (list.isEmpty()) {
            return false;
        }
        for (Box item : list) {
            if (item.getName().length() > 0) {
                Autor insert = new Autor(item.getName(), new Date(System.currentTimeMillis()));
                autorDAO.insert(insert);
            } else {
                return false;
            }

        }
        return true;
    }

    public boolean insertImage(List<Box> list) {
        if (list.isEmpty()) {
            return false;
        }
        for (Box item : list) {
            if (item.getName().length() > 0) {
                Autor autor = autorDAO.getAutor(item.getAutorId());
                if (autor != null) {


                    Images insert = new Images( item.getUrl(),item.getName(), new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), autor);
                    imageDAO.insert(insert);
                } else {
                    return false;
                }
            } else {
                return false;
            }

        }
        return true;
    }

    public boolean insertTag(List<Box> list) {
        String tag;
        if (list.isEmpty()) {
            return false;
        }
        for (Box item : list) {
            if (item.getName().length() > 0) {
                if (item.getName().length() > 16) {
                    tag = item.getName().substring(0, 16);
                } else {
                    tag = item.getName();
                }

                Tags insert = new Tags(tag);
                tagDAO.insert(insert);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean insertLikes(List<Box> list) {
        int value = 1;
        if (list.isEmpty()) {
            return false;
        }
        for (Box item : list) {
            Images images = imageDAO.getImages(item.getImageId());
            if (images != null) {


                if (item.getResult() != 0) {
                    if (item.getResult() > 0) {
                        value = 1;
                    }
                    if (item.getResult() < 0) {
                        value = -1;
                    }

                    Likes insert = new Likes(value, images);
                    likesDAO.insert(insert);

                }
            }
        }
        return true;
    }
    public boolean insertImageTag(List<Box> list) {

        if (list.isEmpty()) {
            return false;
        }
        for (Box item : list) {
            Images images = imageDAO.getImages(item.getImageId());
            Tags tag = tagDAO.getTag(item.getTagId());
            if (images != null && tag!=null) {


                    ImageTag insert = new ImageTag( tag,images);
                    imageTagDAO.insert(insert);

                }
            }return true;
        }
    public boolean insertComment(List<Box> list) {

        if (list.isEmpty()) {
            return false;
        }
        for (Box item : list) {
            Images images = imageDAO.getImages(item.getImageId());
            Autor autor = autorDAO.getAutor(item.getAutorId());
            if (images != null && autor!=null) {


                Comment insert = new Comment(item.getDescription(), new Date(System.currentTimeMillis()),images,autor);
                commentDAO.insert(insert);

            }
        }return true;
    }
    public boolean insertLikesComment(List<Box> list) {
        int value = 1;
        if (list.isEmpty()) {
            return false;
        }
        for (Box item : list) {
            Comment comment = commentDAO.getComment(item.getCommentId());
            if (comment != null) {


                if (item.getResult() != 0) {
                    if (item.getResult() > 0) {
                        value = 1;
                    }
                    if (item.getResult() < 0) {
                        value = -1;
                    }

                    LikesComment insert = new LikesComment( value,comment);
                    likesCommentDAO.insert(insert);

                }
            }
        }
        return true;
    }
    public int getCountImages(){
        return imageDAO.getCountImages();
    }
    public Images getImageByID(int id){
        return imageDAO.getImages(id);
    }
    public List<Comment> getAllComments(int id){
        return commentDAO.getAllcoments(id);
    }
    public int getCountLikes(int id){ return likesDAO.getCountLikes(id);}
    public int getCountDisLikes(int id){ return likesDAO.getCountDisLikes(id);}
    public int getCountComentLikes(int id){ return likesCommentDAO.getCountLikes(id);}
    public int getCountComentDisLikes(int id){ return likesCommentDAO.getCountDisLikes(id);}
    public Comment getCommentById(int id){return commentDAO.getComment(id);}
}