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

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private boolean allowAccess;

    @Column
    @Enumerated (EnumType.STRING)
    private Role role;

    @Column
    private String verificationKey;

    public User(String login, String password, String name, String lastName, String phone, String email, String verificationKey, Role role) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.allowAccess = false;
        this.verificationKey = verificationKey;
        this.role = role;
    }

    public User() {
    }
}
