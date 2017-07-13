package ua.dp.levelup.web;

import com.google.gson.Gson;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.hibernate.annotations.Parameter;
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
import ua.dp.levelup.cinema.*;
import ua.dp.levelup.service.*;

import java.util.*;

/**
 * Created by java on 04.07.2017.
 */

@Controller
@RequestMapping("/movie")
public class MovieSessionController {


    private MovieSessionService movieSessionService;
    private TicketService ticketService;
    private FilmService filmService;
    private HallService hallService;
    private OrderService orderService;

    @Autowired(required = true)
    @Qualifier(value = "ticketService")
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Autowired(required = true)
    @Qualifier(value = "filmService")
    public void setFilmService(FilmService filmService) {
        this.filmService = filmService;
    }

    @Autowired(required = true)
    @Qualifier(value = "hallService")
    public void setHallService(HallService hallService) {
        this.hallService = hallService;
    }

    @Autowired(required = true)
    @Qualifier(value = "orderService")
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

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

        /////////
        /*Film filmById = filmService.getFilmById(1L);
        MovieSession movieSession = new MovieSession(new Date(),1,50,120,filmById.getId());
        movieSessionService.createMovieSession(movieSession);

        List<MovieSession> allMovieSessions = movieSessionService.getAllMovieSessions();
        MovieSession movieSession1 = allMovieSessions.get(0);

        Ticket ticket = new Ticket(movieSession1.getId(),2,5);
        ticketService.createTicket(ticket);*/
        ////////

        List<Hall> allHalls = hallService.getAllHalls();
        ModelAndView modelAndView = new ModelAndView("hall-map");
        modelAndView.addObject("allHalls",new Gson().toJson(allHalls));


        return modelAndView;
    }

    @RequestMapping(value = "/getHall", method = RequestMethod.POST)
    @ResponseBody
    public List<Ticket> getHallJson(@RequestParam String hallId){

        Long id = Long.parseLong(hallId);
        System.out.println(id);

        return ticketService.getTicketsOfMovieSession(id);
    }


}
