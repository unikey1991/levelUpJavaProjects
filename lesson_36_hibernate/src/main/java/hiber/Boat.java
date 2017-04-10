package hiber;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "boat")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Boat{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String model;

    @Column
    private int maxPassengers;

    public Boat(String model, int maxPassengers) {
        this.model = model;
        this.maxPassengers = maxPassengers;
    }
}
