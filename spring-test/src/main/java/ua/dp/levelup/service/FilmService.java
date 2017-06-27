package ua.dp.levelup.service;

import ua.dp.levelup.cinema.Film;

import java.util.List;

/**
 * Created by java on 27.06.2017.
 */
public interface FilmService {

    List<Film> getAllFilms();

    Film getFilmById(Long id);


    void createFilm(Film film);

    void deleteFilm(Film film);

    void updateFilm(Film film);
}
