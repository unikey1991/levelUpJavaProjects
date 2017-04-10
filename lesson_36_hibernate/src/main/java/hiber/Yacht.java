package hiber;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by java on 07.04.2017.
 */

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Yacht extends Boat{

    @Column
    private double maxSpeed;

    @Column
    private double length;

    public Yacht(String model, int maxPassengers, double maxSpeed, double length) {
        super(model, maxPassengers);
        this.maxSpeed = maxSpeed;
        this.length = length;
    }
}
