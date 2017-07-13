package ua.dp.levelup.cinema;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private int totalPrice;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
//    private List<Ticket> tickets = new ArrayList<>();

    public Order(long clientId, List<Ticket> tickets) {
        this.clientId = clientId;
//        this.tickets = tickets;

        //calculateSumm();
    }

//    private void calculateSumm() {
//        for (Ticket t: tickets){
//            totalPrice += t.getPrice();
//            biletsCount++;
//        }
//    }

//    public void addTicket(Ticket t){
//        tickets.add(t);
//    }

//    public List<Ticket> getTickets(){
//        return tickets;
//    }

}
