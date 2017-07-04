package ua.dp.levelup;

import com.google.gson.Gson;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.dp.levelup.cinema.Film;
import ua.dp.levelup.cinema.MovieSession;
import ua.dp.levelup.cinema.Order;
import ua.dp.levelup.cinema.Ticket;
import ua.dp.levelup.service.FilmService;
import ua.dp.levelup.service.MovieSessionService;
import ua.dp.levelup.service.OrderService;
import ua.dp.levelup.service.TicketService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by unity on 13.06.2017.
 */
public class Main {

    public static void main(String[] args) {


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/application-context.xml");
        Gson gson = new Gson();






        FilmService filmService = context.getBean(FilmService.class);
        MovieSessionService movieSessionService = context.getBean(MovieSessionService.class);
        OrderService orderService = context.getBean(OrderService.class);
        TicketService ticketService = context.getBean(TicketService.class);

        /*Film film1 = new Film("Hren' vozvrashaetsa", "Film ujasov");
        Film film2 = new Film("Hren' 2", "Film ujasov");
        Film film3 = new Film("Hren' 3", "Film ujasov");
        Film film4 = new Film("Hren' 4", "Film ujasov");
        Film film5 = new Film("Hren' 5", "Film ujasov");

        filmService.createFilm(film1);
        filmService.createFilm(film2);
        filmService.createFilm(film3);
        filmService.createFilm(film4);
        filmService.createFilm(film5);*/



        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, Calendar.AUGUST, 4);
        Date date = calendar.getTime();



        /*MovieSession movieSession1 = new MovieSession(date,1,50,100,film1);
        MovieSession movieSession2 = new MovieSession(date,2,50,100,film2);
        MovieSession movieSession3 = new MovieSession(date,3,50,100,film3);
        MovieSession movieSession4 = new MovieSession(date,4,50,100,film4);
        MovieSession movieSession5 = new MovieSession(date,5,50,100,film5);

        movieSessionService.createMovieSession(movieSession1);
        movieSessionService.createMovieSession(movieSession2);
        movieSessionService.createMovieSession(movieSession3);
        movieSessionService.createMovieSession(movieSession4);
        movieSessionService.createMovieSession(movieSession5);


        Ticket ticket1 = new Ticket(50, movieSession1);
        Ticket ticket2 = new Ticket(50, movieSession1);
        Ticket ticket3 = new Ticket(100, movieSession1);
        Ticket ticket4 = new Ticket(100, movieSession1);
        Ticket ticket5 = new Ticket(100, movieSession1);
        Ticket ticket6 = new Ticket(100, movieSession1);
        Ticket ticket7 = new Ticket(50, movieSession1);
        Ticket ticket8 = new Ticket(50, movieSession1);
        Ticket ticket9 = new Ticket(50, movieSession1);

        ticketService.createTicket(ticket1);
        ticketService.createTicket(ticket2);
        ticketService.createTicket(ticket3);
        ticketService.createTicket(ticket4);
        ticketService.createTicket(ticket5);
        ticketService.createTicket(ticket6);
        ticketService.createTicket(ticket7);
        ticketService.createTicket(ticket8);
        ticketService.createTicket(ticket9);

        Order order1 = new Order(1, Arrays.asList(ticket1,ticket2,ticket3,ticket4));
        Order order2 = new Order(2, Arrays.asList(ticket5,ticket6,ticket7,ticket8));
        Order order3 = new Order(3, Arrays.asList(ticket9));

        orderService.createOrder(order1);
        orderService.createOrder(order2);
        orderService.createOrder(order3);*/

        List<Film> allFilms = filmService.getAllFilms();
        List<MovieSession> allMovieSessions = movieSessionService.getAllMovieSessions();
        List<Order> allOrders = orderService.getAllOrders();
        List<Ticket> allOrders1 = ticketService.getAllOrders();

        try {
            Date date1 = new SimpleDateFormat("dd.MM.yyyy").parse("04.08.2017");
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }



    }
}
