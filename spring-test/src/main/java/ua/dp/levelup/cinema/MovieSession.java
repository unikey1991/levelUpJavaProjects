package ua.dp.levelup.cinema;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by unike on 22.06.2017.
 */

@Setter
@ToString
@Getter
@NoArgsConstructor
@Entity
@Table(name = "MOVIE_SESSIONS")
public class MovieSession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private Date date;


    @Column
    private int cinemaRoom;
    @Column
    private int standartPrice;
    @Column
    private int comfortPrice;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn (name = "film_id")
    private Film filmId;

    public MovieSession(Date date, int cinemaRoom, int standartPrice, int comfortPrice, Film filmId) {
        this.date = date;
        this.cinemaRoom = cinemaRoom;
        this.standartPrice = standartPrice;
        this.comfortPrice = comfortPrice;
        this.filmId = filmId;
    }
}
