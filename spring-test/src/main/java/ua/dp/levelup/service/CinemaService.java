package ua.dp.levelup.service;

import ua.dp.levelup.cinema.Film;
import ua.dp.levelup.cinema.MovieSession;
import ua.dp.levelup.cinema.Order;

import java.util.List;

/**
 * Created by unike on 22.06.2017.
 */
public interface CinemaService {



    List<Film> getAllFilms();

    Film getFilmById(Long id);

    Film getFilmByName(String filmName);

    void createFilm(Film film);

    void deleteFilm(Film film);

    void updateFilm(Film film);


    ////////

    List<MovieSession> getAllMovieSessions();

    MovieSession getMovieSessionById(Long id);

    void createMovieSession(MovieSession movieSession);

    void deleteMovieSession(MovieSession movieSession);

    void updateMovieSession(MovieSession movieSession);

    ///////

    List<Order> getAllOrders();

    Order getOrderById(Long id);

    void createOrder(Order order);

    void deleteOrder(Order order);

    void updateOrder(Order order);




}
