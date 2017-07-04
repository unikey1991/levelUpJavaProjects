package ua.dp.levelup.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by java on 04.07.2017.
 */

@Controller
public class MovieSessionController {


    @RequestMapping("/")
    public ModelAndView getAll(){
        return new ModelAndView("movie-session-page");
    }

    @RequestMapping("/movies")
    public ModelAndView getAllMovieSessions(){
        return new  ModelAndView("movie-session-page");
    }
}
