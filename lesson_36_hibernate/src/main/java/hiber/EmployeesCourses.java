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
@Table(name = "employees_courses")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class EmployeesCourses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(name = "date_start")
    private Date dateStart;

    @Column(name = "date_finish")
    private Date dateFinish;

    @Column(name = "is_organization_paid")
    private boolean isOrganizationPaid;

    @Column(name = "date_create")
    private Date dateCreate;

}
