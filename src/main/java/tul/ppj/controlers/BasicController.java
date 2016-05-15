package tul.ppj.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tul.ppj.DTO.CommentDTO;
import tul.ppj.Logic.DTOCreater;
import tul.ppj.POJO.Box;
import tul.ppj.POJO.MyBox;
import tul.ppj.Repository.MyRepository;
import tul.ppj.entities.Comment;
import tul.ppj.entities.Images;
import tul.ppj.entities.Likes;
import tul.ppj.entities.LikesComment;

import java.util.Date;
import java.util.List;

/**
 * Created by Marek on 11.05.2016.
 */
@Controller
@RequestMapping("/")
public class BasicController {
    @Autowired
    MyRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("index");
        int count = repository.getCountImages();
        int next = 1, previos = 1, current = 1;
        int imglikes ;
        int imgDislike;
        String infodata ;
        if (count < 4) {
            switch (count) {
                case 1:
                    next = 1;
                    previos = 1;
                    current = 1;
                    break;
                case 2:
                    next = 1;
                    current = 2;
                    previos = 1;
                    break;
                case 3:
                    previos = 1;
                    current = 2;
                    next = 3;

            }
        } else if (count % 2 == 0) {
            current = count / 2;
            previos = current - 1;
            next = current + 1;

        }
        if (count != 0) {
            List<CommentDTO> dtoCm = null;
            List<Comment> allCom = repository.getAllComments(current);
            if(allCom!= null){
                dtoCm = DTOCreater.commetDTOLIST(allCom,repository.getLikesCommentDAO());}
            Images image = repository.getImageByID(current);
             imglikes = repository.getCountLikes(current);
             imgDislike =repository.getCountDisLikes(current);

            infodata= "Vytvořeno: "+image.getCreateDate()+" Autor: "+image.getAutor().getName()+ " Nazev: "+image.getName();
            view.addObject("next", next);
            view.addObject("url", image.getUrl());
            view.addObject("previous", previos);
            view.addObject("current", current);
            view.addObject("mybox",new MyBox());
            view.addObject("likes",imglikes);
            view.addObject("dislikes", imgDislike);
            System.out.println(image.getName());
            view.addObject("infodata",infodata);
            if(dtoCm != null){
                view.addObject("comemnt", dtoCm);}
        }

        return view;
    }

    @RequestMapping(value = "/next/id={id}", method = RequestMethod.GET)
    public ModelAndView next(@PathVariable("id") int id) {
        ModelAndView view = new ModelAndView("index");
        int count = repository.getCountImages();
        int next = 1, previos = 1, current = 1;
        int imglikes = repository.getCountLikes(id);
        int imgDislike =repository.getCountDisLikes(id);
        String infodata ;
            if (count == id) {
                next = 1;
                current = id;
                previos = id - 1;
            }
            if (count > id) {
                next = id + 1;
                current = id;
                previos = id - 1;
            }
        List<CommentDTO> dtoCm = null;
        List<Comment> allCom = repository.getAllComments(current);
        if(allCom!= null){
         dtoCm = DTOCreater.commetDTOLIST(allCom,repository.getLikesCommentDAO());}
        Images image = repository.getImageByID(current);
        infodata= "Vytvořeno: "+image.getCreateDate()+" Autor: "+image.getAutor().getName()+ " Nazev: "+image.getName();

        view.addObject("next", next);
        view.addObject("url", image.getUrl());
        view.addObject("previous", previos);
        view.addObject("current", current);
        view.addObject("mybox",new MyBox());
        view.addObject("likes",imglikes);
        view.addObject("dislikes", imgDislike);
        view.addObject("infodata",infodata);
        if(dtoCm != null){
            view.addObject("comemnt", dtoCm);}

        return view;
    }

    @RequestMapping(value = "/previous/id={id}", method = RequestMethod.GET)
    public ModelAndView previous(@PathVariable("id") int id) {
        ModelAndView view = new ModelAndView("index");
        int count = repository.getCountImages();
        int next = 1, previos = 1, current = 1;
        String infodata ;

            if (id == 1) {
                next = id + 1;
                current = id;
                previos = count;
            }
            if (id > 1) {
                next = id + 1;
                current = id;
                previos = id - 1;
            }

        List<CommentDTO> dtoCm = null;
        List<Comment> allCom = repository.getAllComments(current);
        if(allCom!= null){
            dtoCm = DTOCreater.commetDTOLIST(allCom,repository.getLikesCommentDAO());}
        Images image = repository.getImageByID(current);
        infodata= "Vytvořeno: "+image.getCreateDate()+" Autor: "+image.getAutor().getName()+ " Nazev: "+image.getName();
        view.addObject("next", next);
        view.addObject("url", image.getUrl());
        view.addObject("mybox",new MyBox());
        view.addObject("previous", previos);
        view.addObject("current", current);
        view.addObject("infodata",infodata);
        if(dtoCm != null){
            view.addObject("comemnt", dtoCm);}

        return view;
    }

    @RequestMapping(value = "/like/id={id}&com={idc}&next={next}&prv={prev}", method = RequestMethod.GET)
    public ModelAndView addLikeComent(@PathVariable("id")int id,@PathVariable("idc") int idc,@PathVariable("next") int next,@PathVariable("prev") int prev) {
        ModelAndView view = new ModelAndView("index");
        String infodata ;
        LikesComment lk = new LikesComment();
        lk.setResult(1);
        lk.setComment(repository.getCommentById(idc));
        repository.insertLikesComment(lk);
        int imglikes = repository.getCountLikes(id);
        int imgDislike =repository.getCountDisLikes(id);

        List<CommentDTO> dtoCm = null;
        List<Comment> allCom = repository.getAllComments(id);
        if(allCom!= null){
            dtoCm = DTOCreater.commetDTOLIST(allCom,repository.getLikesCommentDAO());}
        Images image = repository.getImageByID(id);
        infodata= "Vytvořeno: "+image.getCreateDate()+" Autor: "+image.getAutor().getName()+ " Nazev: "+image.getName();
        view.addObject("next", next);
        view.addObject("url", image.getUrl());
        view.addObject("previous", prev);
        view.addObject("mybox",new MyBox());
        view.addObject("current", id);
        view.addObject("likes",imglikes);
        view.addObject("dislikes", imgDislike);
        view.addObject("infodata",infodata);
        if(dtoCm != null){
            view.addObject("comemnt", dtoCm);}

        return view;
    }
    @RequestMapping(value = "/dislike/id={id}&com={idc}&next={next}&prv={prev}", method = RequestMethod.GET)
    public ModelAndView addDisLikeComent(@PathVariable("id")int id,@PathVariable("idc") int idc,@PathVariable("next") int next,@PathVariable("prev") int prev) {
        ModelAndView view = new ModelAndView("index");
        String infodata ;
        LikesComment lk = new LikesComment();
        lk.setResult(-1);
        lk.setComment(repository.getCommentById(idc));
        repository.insertLikesComment(lk);
        int imglikes = repository.getCountLikes(id);
        int imgDislike =repository.getCountDisLikes(id);

        List<CommentDTO> dtoCm = null;
        List<Comment> allCom = repository.getAllComments(id);
        if(allCom!= null){
            dtoCm = DTOCreater.commetDTOLIST(allCom,repository.getLikesCommentDAO());}
        Images image = repository.getImageByID(id);
        infodata= "Vytvořeno: "+image.getCreateDate()+" Autor: "+image.getAutor().getName()+ " Nazev: "+image.getName();
        view.addObject("next", next);
        view.addObject("url", image.getUrl());
        view.addObject("previous", prev);
        view.addObject("mybox",new MyBox());
        view.addObject("current", id);
        view.addObject("likes",imglikes);
        view.addObject("dislikes", imgDislike);
        view.addObject("infodata",infodata);
        if(dtoCm != null){
            view.addObject("comemnt", dtoCm);}

        return view;
    }

    @RequestMapping(value = "/saveComment/id={id}&next={next}&prv={prev}", method = RequestMethod.POST)
    public ModelAndView saveComment(@ModelAttribute("mybox") MyBox tb,@PathVariable("id")int id,  @PathVariable("next") int next, @PathVariable("prev") int prev) {
        Comment comment =new Comment(tb.getText(),new Date(System.currentTimeMillis()),repository.getImageByID(id),repository.getAutorById(1));
        repository.insertComment(comment);
        ModelAndView view = new ModelAndView("index");
        List<CommentDTO> dtoCm = null;
        List<Comment> allCom = repository.getAllComments(id);
        String infodata ;
        int imglikes = repository.getCountLikes(id);
        int imgDislike =repository.getCountDisLikes(id);
        if(allCom!= null){
            dtoCm = DTOCreater.commetDTOLIST(allCom,repository.getLikesCommentDAO());}
        Images image = repository.getImageByID(id);
        infodata= "Vytvořeno: "+image.getCreateDate()+" Autor: "+image.getAutor().getName()+ " Nazev: "+image.getName();
        view.addObject("next", next);
        view.addObject("url", image.getUrl());
        view.addObject("previous", prev);
        view.addObject("mybox",new MyBox());
        view.addObject("current", id);
        view.addObject("likes",imglikes);
        view.addObject("dislikes", imgDislike);
        view.addObject("infodata",infodata);
        if(dtoCm != null){
            view.addObject("comemnt", dtoCm);}

        return view;
    }
    @RequestMapping(value = "/likeimg/id={id}&next={next}&prv={prev}", method = RequestMethod.GET)
    public ModelAndView addLike(@PathVariable("id")int id,@PathVariable("next") int next,@PathVariable("prev") int prev) {
        ModelAndView view = new ModelAndView("index");
        Images tmp = repository.getImageByID(id);
        Likes likes = new Likes(1,tmp);
        repository.insertLikes(likes);
        int imglikes = repository.getCountLikes(id);
        int imgDislike =repository.getCountDisLikes(id);
        String infodata ;
        List<CommentDTO> dtoCm = null;
        List<Comment> allCom = repository.getAllComments(id);
        if(allCom!= null){
            dtoCm = DTOCreater.commetDTOLIST(allCom,repository.getLikesCommentDAO());}
        Images image = repository.getImageByID(id);
        infodata= "Vytvořeno: "+image.getCreateDate()+" Autor: "+image.getAutor().getName()+ " Nazev: "+image.getName();
        view.addObject("next", next);
        view.addObject("url", image.getUrl());
        view.addObject("previous", prev);
        view.addObject("mybox",new MyBox());
        view.addObject("current", id);
        view.addObject("likes",imglikes);
        view.addObject("dislikes", imgDislike);
        view.addObject("infodata",infodata);
        if(dtoCm != null){
            view.addObject("comemnt", dtoCm);}

        return view;
    }
    @RequestMapping(value = "/dislikeimg/id={id}&next={next}&prv={prev}", method = RequestMethod.GET)
    public ModelAndView addDisLike(@PathVariable("id")int id,@PathVariable("next") int next,@PathVariable("prev") int prev) {
        ModelAndView view = new ModelAndView("index");
        String infodata ;
        Images tmp = repository.getImageByID(id);
        Likes likes = new Likes(-1,tmp);
        repository.insertLikes(likes);
        int imglikes = repository.getCountLikes(id);
        int imgDislike =repository.getCountDisLikes(id);
        List<CommentDTO> dtoCm = null;
        List<Comment> allCom = repository.getAllComments(id);
        if(allCom!= null){
            dtoCm = DTOCreater.commetDTOLIST(allCom,repository.getLikesCommentDAO());}
        Images image = repository.getImageByID(id);
        infodata= "Vytvořeno: "+image.getCreateDate()+" Autor: "+image.getAutor().getName()+ " Nazev: "+image.getName();
        view.addObject("next", next);
        view.addObject("url", image.getUrl());
        view.addObject("previous", prev);
        view.addObject("mybox",new MyBox());
        view.addObject("current", id);
        view.addObject("likes",imglikes);
        view.addObject("dislikes", imgDislike);
        view.addObject("infodata",infodata);
        if(dtoCm != null){
            view.addObject("comemnt", dtoCm);}

        return view;
    }
    @RequestMapping(value = "/saveAutor", method = RequestMethod.POST)
    public
    @ResponseBody
    List<Box> saveAutors(@RequestBody final List<Box> box) {


        System.out.println("Autor saved: " + repository.insertAutor(box));
        return box;
    }

    @RequestMapping(value = "/saveImage", method = RequestMethod.POST)
    public
    @ResponseBody
    List<Box> saveImages(@RequestBody final List<Box> box) {


        System.out.println("Image saved: " + repository.insertImage(box));
        return box;
    }

    @RequestMapping(value = "/saveTag", method = RequestMethod.POST)
    public
    @ResponseBody
    List<Box> saveTag(@RequestBody final List<Box> box) {
        System.out.println("Tag saved: " + repository.insertTag(box));
        return box;
    }

    @RequestMapping(value = "/saveLike", method = RequestMethod.POST)
    public
    @ResponseBody
    List<Box> saveLike(@RequestBody final List<Box> box) {
        System.out.println("Like saved: " + repository.insertLikes(box));
        return box;
    }

    @RequestMapping(value = "/saveImageTag", method = RequestMethod.POST)
    public
    @ResponseBody
    List<Box> saveImageTag(@RequestBody final List<Box> box) {
        System.out.println("Like imageTag: " + repository.insertImageTag(box));
        return box;
    }

    @RequestMapping(value = "/saveComment", method = RequestMethod.POST)
    public
    @ResponseBody
    List<Box> saveComment(@RequestBody final List<Box> box) {
        System.out.println("Comment imageTag: " + repository.insertComment(box));
        return box;
    }

    @RequestMapping(value = "/saveCommentLike", method = RequestMethod.POST)
    public
    @ResponseBody
    List<Box> saveCommentLike(@RequestBody final List<Box> box) {
        System.out.println("Comment CommentLike: " + repository.insertLikesComment(box));
        return box;
    }

}
