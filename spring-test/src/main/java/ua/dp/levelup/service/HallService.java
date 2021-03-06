package ua.dp.levelup.service;

import ua.dp.levelup.cinema.Hall;

import java.util.List;

/**
 * Created by unike on 10.07.2017.
 */
public interface HallService {




    void createHall(Hall hall);
    void updateHall(Hall hall);
    void deleteHall(Hall hall);
    void getHallById(Long id);
    List<Hall> getAllHalls();
}
