package ua.dp.levelup.cinema;

import lombok.*;

import javax.persistence.*;

/**
 * Created by unike on 22.06.2017.
 */

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private long clientId;
    @Column
    private int biletsCount;
    @Column
    private int seanceId;
    @Column
    private int cost;

    public Order(long clientId, int biletsCount, int seanceId, int cost) {
        this.clientId = clientId;
        this.biletsCount = biletsCount;
        this.seanceId = seanceId;
        this.cost = cost;
    }
}
