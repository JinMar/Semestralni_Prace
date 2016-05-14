package tul.ppj.Logic;

import tul.ppj.DAO.LikesCommentDAO;
import tul.ppj.DTO.CommentDTO;
import tul.ppj.entities.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marek on 14.05.2016.
 */
public class DTOCreater {
    public static List<CommentDTO> commetDTOLIST(List<Comment> list, LikesCommentDAO dao) {
        List<CommentDTO> dtolist= new ArrayList<>();
        for(Comment a :list){
            CommentDTO add = new CommentDTO();
            add.setText(a.getDescription());
            add.setLikes(dao.getCountLikes(a.getId()));
            add.setDislikes(dao.getCountDisLikes(a.getId()));
            add.setId(a.getId());
            dtolist.add(add);
        }


        return dtolist;}
}
