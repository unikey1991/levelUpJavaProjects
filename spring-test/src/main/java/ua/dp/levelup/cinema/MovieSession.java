package ua.dp.levelup.cinema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

/**
 * Created by unike on 22.06.2017.
 */

@Getter
@AllArgsConstructor
@ToString
public class MovieSession {

    private long id;
    private long filmId;
    private Date date;
    private int cinemaRoom;
    private int standartPrice;
    private int comfortPrice;

}
