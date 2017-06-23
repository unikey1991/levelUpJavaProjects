package ua.dp.levelup.dao.impl;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import ua.dp.levelup.cinema.Film;
import ua.dp.levelup.dao.FilmDao;

import java.util.List;

/**
 * Created by java on 23.06.2017.
 */
@Transactional
public class FilmMysqlDaoImpl implements FilmDao {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public List<Film> getAllFilms() {
        return null;
    }

    @Override
    public Film getFilmById(Long id) {
        return null;
    }

    @Override
    public Film getFilmByName(String filmName) {
        return null;
    }

    @Override
    public void createFilm(Film film) {
        hibernateTemplate.save(film);
    }

    @Override
    public void deleteFilm(Film film) {

    }

    @Override
    public void updateFilm(Film film) {

    }
}
