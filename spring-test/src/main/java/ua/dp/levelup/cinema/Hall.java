package ua.dp.levelup.cinema;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by unike on 10.07.2017.
 */


@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "HALLS")
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

        @Column
    private int[][] seatsAndRanges;

    /*@Column
    private int[] Seats;
    @Column
    private int[] Ranges;*/



}
