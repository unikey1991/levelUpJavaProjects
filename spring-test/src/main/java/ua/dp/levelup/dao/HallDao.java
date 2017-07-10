package ua.dp.levelup.dao;

import ua.dp.levelup.cinema.Hall;

/**
 * Created by unike on 10.07.2017.
 */
public interface HallDao {


    void createHall(Hall hall);
    void updateHall(Hall hall);
    void deleteHall(Hall hall);
    void getHallById(Long id);
}
