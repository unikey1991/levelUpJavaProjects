package ua.dp.levelup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dp.levelup.cinema.Film;
import ua.dp.levelup.dao.FilmDao;
import ua.dp.levelup.service.FilmService;

import java.util.List;

/**
 * Created by java on 27.06.2017.
 */

@Service("filmService")
public class FilmServiceImpl implements FilmService {


    private FilmDao filmDao;

    @Autowired
    public void setFilmDao(FilmDao filmDao) {
        this.filmDao = filmDao;
    }

    @Override
    public List<Film> getAllFilms() {
        return filmDao.getAllFilms();
    }

    @Override
    public Film getFilmById(Long id) {
        return filmDao.getFilmById(id);
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
}
