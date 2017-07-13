package ua.dp.levelup.cinema;

import lombok.*;

import javax.persistence.*;

/**
 * Created by unike on 02.07.2017.
 */


@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@Table(name = "TICKETS")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ticketId;

    private Long movieSessionId;
//    @ManyToOne
//    private Order order;

    @Column
    private int lineNumber;

    @Column
    private int seatNumber;

    @Column
    private int hallId;

    public Ticket(Long movieSessionId, int lineNumber, int seatNumber) {
        this.movieSessionId = movieSessionId;
        this.lineNumber = lineNumber;
        this.seatNumber = seatNumber;
    }
}
