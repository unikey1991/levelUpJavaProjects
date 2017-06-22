package ua.dp.levelup.dao;

import ua.dp.levelup.cinema.Film;

import java.util.List;

/**
 * Created by unike on 22.06.2017.
 */
public interface FilmDao {

    List<Film> getAllFilms();

    Film getFilmById(Long id);

    Film getFilmByName(String filmName);

    void createFilm(Film film);

    void deleteFilm(Film film);

    void updateFilm(Film film);

}
