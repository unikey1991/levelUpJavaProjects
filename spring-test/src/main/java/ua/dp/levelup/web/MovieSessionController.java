package ua.dp.levelup.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ua.dp.levelup.cinema.Film;
import ua.dp.levelup.cinema.MovieSession;
import ua.dp.levelup.service.MovieSessionService;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by java on 04.07.2017.
 */

@Controller
@RequestMapping("/movie")
public class MovieSessionController {


    private MovieSessionService movieSessionService;

    @Autowired(required = true)
    @Qualifier(value = "movieSessionService")
    public void setMovieSessionService(MovieSessionService movieSessionService) {
        this.movieSessionService = movieSessionService;
    }

    @RequestMapping("/")
    @ResponseBody
    public Film film() {
        return new Film("Bla", "Bla-bla");
    }


    @RequestMapping("/welcome")
    public ModelAndView welcome() {
        return new ModelAndView("welcome");
    }

    @RequestMapping("/list")
    public ModelAndView getAllMovieSessions() {
        List<MovieSession> allMovieSessions = this.movieSessionService.getAllMovieSessions();
        ModelAndView modelAndView = new ModelAndView("movie-session-page");
        modelAndView.addObject("allMovieSessions",allMovieSessions);
        //return new ModelAndView("movie-session-page");
        return modelAndView;
    }

    @RequestMapping("/hall")
    public ModelAndView test(){


        ModelAndView modelAndView = new ModelAndView("hall-map");
//        modelAndView.addObject("seatsAndRanges",seatsAndRanges);
        return modelAndView;
    }

    @RequestMapping(value = "/getHall", method = RequestMethod.POST)
    public @ResponseBody int[][] getHallJson(){
        int[][] seatsAndRanges = new int[12][19];
        for (int i = 0; i<seatsAndRanges.length; i++){
            for (int j = 0; j<seatsAndRanges[i].length; j++){
                Random random = new Random();
                seatsAndRanges[i][j] = random.nextInt(10);
            }
        }
        return seatsAndRanges;
    }


}
