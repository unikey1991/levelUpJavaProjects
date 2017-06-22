package ua.dp.levelup.dao;

import ua.dp.levelup.cinema.MovieSession;

import java.util.List;

/**
 * Created by unike on 22.06.2017.
 */
public interface MovieSessionDao {

    List<MovieSession> getAllMovieSessions();

    MovieSession getMovieSessionById(Long id);

    void createMovieSession(MovieSession movieSession);

    void deleteMovieSession(MovieSession movieSession);

    void updateMovieSession(MovieSession movieSession);
}
