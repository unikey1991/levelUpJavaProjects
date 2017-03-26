package entity;

/**
 * Created by unike on 23.03.2017.
 */
public class Citizen extends Entity{
    private String firstName;
    private String lastName;
    private Long age;
    private Long streetId;

    public Citizen(Long id, String firstName, String lastName, Long age, Long streetId) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.streetId = streetId;
    }

    public Citizen(String firstName, String lastName, Long age, Long streetId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.streetId = streetId;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getAge() {
        return age;
    }

    public Long getStreetId() {
        return streetId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public void setStreetId(Long streetId) {
        this.streetId = streetId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Citizen citizen = (Citizen) o;

        if (!firstName.equals(citizen.firstName)) return false;
        if (!lastName.equals(citizen.lastName)) return false;
        if (!age.equals(citizen.age)) return false;
        return streetId != null ? streetId.equals(citizen.streetId) : citizen.streetId == null;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + age.hashCode();
        result = 31 * result + (streetId != null ? streetId.hashCode() : 0);
        return result;
    }
}
