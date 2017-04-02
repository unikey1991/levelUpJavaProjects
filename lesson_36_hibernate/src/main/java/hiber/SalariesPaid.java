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
@Table(name = "salaries_paid")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class SalariesPaid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column
    private int salary;

    @Column(name = "date_pay")
    private Date datePay = new Date();

    @Column(name = "date_create")
    private Date dateCreate = new Date();

}
