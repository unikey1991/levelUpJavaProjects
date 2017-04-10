package hiber.hw35;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by unike on 10.04.2017.
 */


@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "citizens")
@Getter
@Setter
@Entity
@Table(name = "street")
public class Street {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "street_name")
    private String streetName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "strt")
    private List<Citizen> citizens;
}
