/**
 * Created by java on 21.03.2017.
 */
public class Employee {
    private int id;
    private String name_first;
    private String name_last;
    private String name_second;
    private int salary;
    private int department_id;
    private int post_id;
    private String date;

    public Employee(int id, String name_first, String name_last, String name_second, int salary, int department_id, int post_id, String date) {
        this.id = id;
        this.name_first = name_first;
        this.name_last = name_last;
        this.name_second = name_second;
        this.salary = salary;
        this.department_id = department_id;
        this.post_id = post_id;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name_first='" + name_first + '\'' +
                ", name_last='" + name_last + '\'' +
                ", name_second='" + name_second + '\'' +
                ", salary=" + salary +
                ", department_id=" + department_id +
                ", post_id=" + post_id +
                ", date='" + date + '\'' +
                '}';
    }
}
