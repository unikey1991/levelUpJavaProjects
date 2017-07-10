package ua.dp.levelup.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.dp.levelup.cinema.Hall;
import ua.dp.levelup.dao.HallDao;

/**
 * Created by unike on 10.07.2017.
 */

@Transactional
@Repository("hallDao")
public class HallDaoImpl implements HallDao {


    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void createHall(Hall hall) {
        hibernateTemplate.save(hall);
    }

    @Override
    public void updateHall(Hall hall) {
        hibernateTemplate.update(hall);
    }

    @Override
    public void deleteHall(Hall hall) {
        hibernateTemplate.delete(hall);
    }

    @Override
    public void getHallById(Long id) {
        hibernateTemplate.get(Hall.class, id);
    }
}
