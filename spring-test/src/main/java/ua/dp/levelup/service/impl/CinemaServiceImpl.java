package ua.dp.levelup.service.impl;

import lombok.Setter;
import ua.dp.levelup.cinema.Film;
import ua.dp.levelup.cinema.MovieSession;
import ua.dp.levelup.cinema.Order;
import ua.dp.levelup.dao.FilmDao;
import ua.dp.levelup.dao.MovieSessionDao;
import ua.dp.levelup.dao.OrderDao;
import ua.dp.levelup.service.CinemaService;

import java.util.List;

/**
 * Created by unike on 22.06.2017.
 */

@Setter
public class CinemaServiceImpl implements CinemaService {

    private FilmDao filmDao;
    private MovieSessionDao movieSessionDao;
    private OrderDao orderDao;

    @Override
    public List<Film> getAllFilms() {
        return filmDao.getAllFilms();
    }

    @Override
    public Film getFilmById(Long id) {
        return filmDao.getFilmById(id);
    }

    @Override
    public Film getFilmByName(String filmName) {
        return filmDao.getFilmByName(filmName);
    }

    @Override
    public void createFilm(Film film) {
        filmDao.createFilm(film);
    }

    @Override
    public void deleteFilm(Film film) {
        filmDao.deleteFilm(film);

    }

    @Override
    public void updateFilm(Film film) {
        filmDao.updateFilm(film);
    }

    @Override
    public List<MovieSession> getAllMovieSessions() {
        return movieSessionDao.getAllMovieSessions();
    }

    @Override
    public MovieSession getMovieSessionById(Long id) {
        return movieSessionDao.getMovieSessionById(id);
    }

    @Override
    public void createMovieSession(MovieSession movieSession) {
        movieSessionDao.createMovieSession(movieSession);
    }

    @Override
    public void deleteMovieSession(MovieSession movieSession) {
        movieSessionDao.deleteMovieSession(movieSession);
    }

    @Override
    public void updateMovieSession(MovieSession movieSession) {
        movieSessionDao.updateMovieSession(movieSession);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderDao.getOrderById(id);
    }

    @Override
    public void createOrder(Order order) {
        orderDao.createOrder(order);
    }

    @Override
    public void deleteOrder(Order order) {
        orderDao.deleteOrder(order);
    }

    @Override
    public void updateOrder(Order order) {
        orderDao.updateOrder(order);
    }
}
