package ua.dp.levelup.service;

import ua.dp.levelup.cinema.MovieSession;

import java.util.List;

/**
 * Created by java on 27.06.2017.
 */


public interface MovieSessionService {

    List<MovieSession> getAllMovieSessions();

    MovieSession getMovieSessionById(Long id);

    void createMovieSession(MovieSession movieSession);

    void deleteMovieSession(MovieSession movieSession);

    void updateMovieSession(MovieSession movieSession);

}
