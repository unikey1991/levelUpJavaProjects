package ua.dp.levelup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dp.levelup.cinema.Hall;
import ua.dp.levelup.dao.HallDao;
import ua.dp.levelup.service.HallService;

/**
 * Created by unike on 10.07.2017.
 */

@Service("hallService")
public class HallServiceImpl implements HallService {


    @Autowired
    HallDao hallDao;


    @Override
    public void createHall(Hall hall) {
        hallDao.createHall(hall);
    }

    @Override
    public void updateHall(Hall hall) {
        hallDao.updateHall(hall);
    }

    @Override
    public void deleteHall(Hall hall) {
        hallDao.deleteHall(hall);
    }

    @Override
    public void getHallById(Long id) {
        hallDao.getHallById(id);
    }
}
