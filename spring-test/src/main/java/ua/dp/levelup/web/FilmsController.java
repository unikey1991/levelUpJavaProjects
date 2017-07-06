package ua.dp.levelup.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import ua.dp.levelup.cinema.Film;
import ua.dp.levelup.service.FilmService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by unike on 06.07.2017.
 */

@Controller
@RequestMapping("/cinema")
public class FilmsController {

    private FilmService filmService;


    @Autowired
    @Qualifier(value = "filmService")
    public void setFilmService(FilmService filmService) {
        this.filmService = filmService;
    }

    @RequestMapping("/today")
    public ModelAndView today() {


        return new ModelAndView();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveFilm(@RequestParam String filmName, @RequestParam String filmDescription) {

        Film film = new Film(filmName, filmDescription);
        System.out.println(film.toString());
        filmService.createFilm(film);

        return new ModelAndView("redirect:/cinema/add");
    }

    @RequestMapping(value = "/add")
    public ModelAndView addFilm() {
        return new ModelAndView("add-film");
    }

}
