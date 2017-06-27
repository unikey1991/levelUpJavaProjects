package ua.dp.levelup.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.dp.levelup.cinema.MovieSession;
import ua.dp.levelup.dao.MovieSessionDao;

import java.util.List;

/**
 * Created by java on 27.06.2017.
 */

@Repository
@Transactional
public class MovieSessionMysqlDaoImpl implements MovieSessionDao {

    @Autowired
    private HibernateTemplate template;

//    @Value(value = "${my.value}")
//    private String value;

    @Override
    public List<MovieSession> getAllMovieSessions() {
        return template.loadAll(MovieSession.class);
    }

    @Override
    public MovieSession getMovieSessionById(Long id) {
        return template.get(MovieSession.class, id);
    }

    @Override
    public void createMovieSession(MovieSession movieSession) {
        template.save(movieSession);
    }

    @Override
    public void deleteMovieSession(MovieSession movieSession) {
        template.delete(movieSession);
    }

    @Override
    public void updateMovieSession(MovieSession movieSession) {
        template.update(movieSession);
    }
}
