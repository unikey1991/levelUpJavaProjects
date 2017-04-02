package hiber;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by unike on 02.04.2017.
 */

@Entity
@Table(name = "employees_tangibles")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {})
public class EmployeesTangibles {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tangible_id", nullable = false)
    private Tangible tangible;

    @Column(name = "uniq_number", unique = true)
    private int uniqNumber;

    @Column(name = "date_create")
    private Date dateCreate = new Date();
}
