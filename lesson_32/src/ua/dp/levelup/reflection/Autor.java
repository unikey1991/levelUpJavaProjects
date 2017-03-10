package ua.dp.levelup.reflection;

/**
 * Created by java on 07.03.2017.
 */
public class Autor {

    @ToXML
    private String firstName;
    @ToXML
    private String lastName;
    @ToXML
    private long age;

    public Autor(String firstName, String lastName, long age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Autor() {
    }

    @Override
    public String toString() {
        return "Autor{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
