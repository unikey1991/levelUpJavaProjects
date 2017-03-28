package hiber;

import javax.persistence.*;

/**
 * Created by java on 28.03.2017.
 */

@Entity
@Table(name = "USER", indexes = {
        @Index(columnList ="email", name = "email_idx")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private long id;
    @Column(name = "full_name")
    private String name;
    @Column(unique = true)
    private String email;
    @Column
    private String password;
    @Column
    private boolean blocked;


    public User() {
    }

    public User(String name, String email, String password, boolean blocked) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.blocked = blocked;
    }

    public User(long id, String name, String email, String password, boolean blocked) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.blocked = blocked;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }



}
