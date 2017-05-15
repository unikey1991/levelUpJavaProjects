package entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by unike on 15.05.2017.
 */

@Getter
@Setter
@ToString
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String name;

    @Column(name = "last_name")
    private String lastName;

    public User(String login, String password, String name, String lastName) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
    }

    public User() {
    }
}
