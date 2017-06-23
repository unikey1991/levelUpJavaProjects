package ua.dp.levelup.dao.impl;

import org.springframework.transaction.annotation.Transactional;
import ua.dp.levelup.cinema.Film;
import ua.dp.levelup.dao.FilmDao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by unike on 22.06.2017.
 */
public class FilmDaoImpl implements FilmDao {

    private Map<Long, Film> filmById = new HashMap<>();
    private Map<String, Long> idByFilmName = new HashMap<>();


    public void init() {
        List<Film> films = Arrays.asList(
                new Film("Dimon i ego velikan", "Doktor Dimon izgonin vse soki iz pacientki"),
                new Film("Lord of the rings", ""),
                new Film("Mechanic", "")
        );

        for (Film f: films){
            createFilm(f);
        }
    }



    @Override
    public List<Film> getAllFilms() {
        return (List<Film>) filmById.values();
    }

    @Override
    public Film getFilmById(Long id) {
        return filmById.get(id);
    }

    @Override
    public Film getFilmByName(String filmName) {
        return filmById.get(idByFilmName.get(filmName));
    }

    @Override
    public void createFilm(Film film) {
        filmById.put(film.getId(), film);

    }

    @Override
    public void deleteFilm(Film film) {
        filmById.remove(film.getId());
    }

    @Override
    public void updateFilm(Film film) {
        filmById.put(film.getId(),film);
    }
}
