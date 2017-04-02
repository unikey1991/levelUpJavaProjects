package hiber;

/**
 * Created by java on 31.03.2017.
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name_first")
    private String firstName;

    @Column(name = "name_last")
    private String lastName;

    @Column(name = "name_second")
    private String secondName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Column
    private int salary;

    @Type(type = "timestamp")
    @Column(name = "date_create")
    private Date creationDate = new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;





    public Employee(String firstName, String lastName, String secondName, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondName = secondName;
        this.salary = salary;
    }



}
