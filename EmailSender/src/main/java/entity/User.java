package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by unike on 03.05.2017.
 */

@Entity
@Table(name = "USER", indexes = {
        @Index(columnList = "email", name = "email_idx")
})
@Getter
@Setter
@NoArgsConstructor
@ToString
@SecondaryTable(name = "user_details", pkJoinColumns = @PrimaryKeyJoinColumn(name = "USER_ID"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private long id;

    @Column
    private String email;

    @Column
    private String password;

    @Column(table = "user_details")
    private String name;

    @Column(table = "user_details")
    private String lastName;

    @Column(table = "user_details")
    @Enumerated (EnumType.STRING)
    private AccountType accountType;

    @Column(table = "user_details", name = "quantity_of_messages_left")
    private Long quantityOfMessagesLeftToSendInMounth;

    @Column(table = "user_details")
    private Date dateOfStartMessgesCounter;

    public User(String email, String password, String name, String lastName, AccountType accountType) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.accountType = accountType;
    }
}
