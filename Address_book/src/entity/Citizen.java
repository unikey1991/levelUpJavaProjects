package entity;

/**
 * Created by java on 10.01.2017.
 */
public class Citizen {

    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private Long streetId;


    public Citizen(String firstName, String lastName, int age, Long streetId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.streetId = streetId;
    }


    public Citizen(String firstName, Long id, String lastName, int age, Long streetId) {
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
        this.age = age;
        this.streetId = streetId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getStreetId() {
        return streetId;
    }

    public void setStreetId(Long streetId) {
        this.streetId = streetId;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", streetId=" + streetId +
                '}';
    }
}
