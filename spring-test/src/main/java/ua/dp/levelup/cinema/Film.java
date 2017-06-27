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
@Table(name = "FILMS")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String filmName;

    @Column
    private String filmDescription;

    public Film(String filmName, String filmDescription) {
        this.filmName = filmName;
        this.filmDescription = filmDescription;
    }
}
