package hiber;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by java on 04.04.2017.
 */

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "employee")
@Entity
@Table(name = "PHONE_NUMBERS")
public class PhoneNumber {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 15)
    private String number;

    @OneToOne(mappedBy = "phoneNumber")
    private Employee employee;

    public PhoneNumber(String number, Employee employee) {
        this.number = number;
        this.employee = employee;
    }
}
