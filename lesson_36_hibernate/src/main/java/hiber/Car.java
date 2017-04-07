package hiber;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.awt.*;

/**
 * Created by java on 07.04.2017.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class Car {

    @Column
    private String model;

    @Enumerated(EnumType.STRING)
    @Column
    private Color color = Color.BLACK;

    @Column
    private double maxSpeed;
}
