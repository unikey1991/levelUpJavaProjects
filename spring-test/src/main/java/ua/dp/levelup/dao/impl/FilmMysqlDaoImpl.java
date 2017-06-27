package ua.dp.levelup.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.dp.levelup.cinema.Film;
import ua.dp.levelup.dao.FilmDao;

import java.util.List;

/**
 * Created by java on 23.06.2017.
 */
@Transactional
@Repository
public class FilmMysqlDaoImpl implements FilmDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;


    @Override
    public List<Film> getAllFilms() {
        return hibernateTemplate.loadAll(Film.class);
    }

    @Override
    public Film getFilmById(Long id) {
        return hibernateTemplate.get(Film.class, id);
    }

    @Override
    public void createFilm(Film film) {
        hibernateTemplate.save(film);
    }

    @Override
    public void deleteFilm(Film film) {
        hibernateTemplate.delete(film);
    }

    @Override
    public void updateFilm(Film film) {
        hibernateTemplate.update(film);
    }
}
