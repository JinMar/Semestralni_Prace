package tul.ppj.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tul.ppj.POJO.Box;
import tul.ppj.Repository.MyRepository;
import tul.ppj.entities.Autor;
import tul.ppj.entities.Images;

import javax.servlet.http.HttpServletRequest;
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
        Images image;
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
        if(count!=0){
            image = repository.getImageByID(current);
            System.out.println("current: "+ current);
        view.addObject("next", next);
        view.addObject("url",image.getUrl());
        view.addObject("previous", previos);}

        return view;
    }

    @RequestMapping(value = "/next/id={id}", method = RequestMethod.GET)
    public ModelAndView next(@PathVariable("id") int id, Model model) {
        System.out.println("next " + id);
        ModelAndView view = new ModelAndView("index");
        System.out.println("počet obrázků" + repository.getCountImages());
        view.addObject("next", id + 1);
        view.addObject("previous", id - 1);


        return view;
    }

    @RequestMapping(value = "/previous/id={id}", method = RequestMethod.GET)
    public ModelAndView previous(@PathVariable("id") int id, Model model) {
        System.out.println("previous " + id);
        ModelAndView view = new ModelAndView("index");

        view.addObject("next", id + 1);
        view.addObject("previous", id - 1);

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
