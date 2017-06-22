package ua.dp.levelup.dao.impl;

import ua.dp.levelup.cinema.MovieSession;
import ua.dp.levelup.dao.MovieSessionDao;

import java.util.*;

/**
 * Created by unike on 22.06.2017.
 */
public class MovieSessionDaoImpl implements MovieSessionDao{

    private Map<Long, MovieSession> movieSessionById = new HashMap<>();

    public void init() {
        List<MovieSession> movieSessions = Arrays.asList(
                new MovieSession(1L, 1L, new Date(2017,6,25,14,0),2,70,130),
                new MovieSession(2L, 2L, new Date(2017,6,26,14,0),1,70,130),
                new MovieSession(3L, 3L, new Date(2017,6,27,14,0),2,70,130),
                new MovieSession(4L, 4L, new Date(2017,6,28,14,0),1,70,130)
        );

        for (MovieSession m: movieSessions){
            createMovieSession(m);
        }
    }

    @Override
    public List<MovieSession> getAllMovieSessions() {
        return (List<MovieSession>) movieSessionById.values();
    }

    @Override
    public MovieSession getMovieSessionById(Long id) {
        return movieSessionById.get(id);
    }

    @Override
    public void createMovieSession(MovieSession movieSession) {
        movieSessionById.put(movieSession.getId(),movieSession);
    }

    @Override
    public void deleteMovieSession(MovieSession movieSession) {
        movieSessionById.remove(movieSession.getId());
    }

    @Override
    public void updateMovieSession(MovieSession movieSession) {
        movieSessionById.put(movieSession.getId(),movieSession);
    }
}
