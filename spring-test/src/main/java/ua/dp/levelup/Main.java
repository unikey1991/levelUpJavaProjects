package ua.dp.levelup;

import com.google.gson.Gson;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.dp.levelup.cinema.Film;
import ua.dp.levelup.cinema.MovieSession;
import ua.dp.levelup.service.FilmService;
import ua.dp.levelup.service.MovieSessionService;

import java.util.Date;

/**
 * Created by unity on 13.06.2017.
 */
public class Main {

    public static void main(String[] args) {


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Gson gson = new Gson();






//        System.out.println(film.toString());

        Film film1 = new Film("Hren' vozvrashaetsa", "Film ujasov");


        FilmService filmService = context.getBean(FilmService.class);
        MovieSessionService movieSessionService = context.getBean(MovieSessionService.class);

       // filmService.createFilm(film1);

        MovieSession movieSession1 = new MovieSession(1, new Date(),4,60,140);

        movieSessionService.createMovieSession(movieSession1);


    }
}
