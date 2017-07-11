package ua.dp.levelup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ua.dp.levelup.cinema.MovieSession;
import ua.dp.levelup.dao.MovieSessionDao;
import ua.dp.levelup.service.MovieSessionService;

import java.util.List;

/**
 * Created by java on 27.06.2017.
 */

@Service("movieSessionService")
public class MovieSessionServiceImpl implements MovieSessionService {


    private MovieSessionDao movieSessionDao;

    @Autowired
    public void setMovieSessionDao(final MovieSessionDao movieSessionDao) {
        this.movieSessionDao = movieSessionDao;
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
    public List<MovieSession> getAllMovieSessionsForToday() {
        return null;
    }

    @Scheduled(cron = "0 45 * * ? *")
    private void updateMovieSessionsForToday(){
        System.out.println("updateMovieSessionForToday() scheduled");
    }
}
