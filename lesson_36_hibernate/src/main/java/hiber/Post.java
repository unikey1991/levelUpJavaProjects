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
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @Column(name = "date_create")
    private Date dateCreate = new Date();
}
