package tul.ppj.controlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tul.ppj.PpjApplication;

import tul.ppj.Repository.repo;

/**
 * Created by Marek on 28.05.2016.
 */
@Controller
@Profile("mongo")
@RequestMapping("/")
public class TEst {
    @Autowired
    repo repod;
    final static Logger logger = LoggerFactory.getLogger(PpjApplication.class);
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("index");

        return view;
    }
}
