package ua.dp.levelup.cinema;

import lombok.*;

import javax.persistence.*;

/**
 * Created by unike on 02.07.2017.
 */


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TICKETS")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ticketId;
    private double price;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private MovieSession movieSession;
    @ManyToOne
    private Order order;

    public Ticket(double price, MovieSession movieSession) {
        this.price = price;
        this.movieSession = movieSession;
    }
}
