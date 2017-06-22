package ua.dp.levelup.cinema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by unike on 22.06.2017.
 */

@AllArgsConstructor
@ToString
@Getter
public class Order {


    private long id;
    private long clientId;
    private int biletsCount;
    private int seanceId;
    private int cost;

}
