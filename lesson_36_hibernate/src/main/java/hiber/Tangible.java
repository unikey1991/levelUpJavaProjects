package hiber;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by unike on 02.04.2017.
 */

@Entity
@Table(name = "tangibles")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Tangible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @Column
    private double price;

    @Column
    private String description;

    @Column(name = "date_create")
    private Date dateCreate = new Date();

}
