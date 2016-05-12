package tul.ppj.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tul.ppj.POJO.Box;
import tul.ppj.Repository.MyRepository;
import tul.ppj.entities.Autor;

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
    public ModelAndView index(Model model) {
        ModelAndView view = new ModelAndView("index");

        view.addObject("next",2);
        view.addObject("previous",1);

        return view;
    }
    @RequestMapping(value = "/next/id={id}", method = RequestMethod.GET)
    public ModelAndView next(@PathVariable("id") int id, Model model) {
        System.out.println("next "+ id);
        ModelAndView view = new ModelAndView("index");

            view.addObject("next",id+1);
            view.addObject("previous",id-1);


        return view;
    }
    @RequestMapping(value = "/previous/id={id}", method = RequestMethod.GET)
    public ModelAndView previous(@PathVariable("id") int id, Model model) {
        System.out.println("previous "+id);
        ModelAndView view = new ModelAndView("index");

        view.addObject("next",id+1);
        view.addObject("previous",id-1);

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
