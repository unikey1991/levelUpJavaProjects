package explorer;

/**
 * Created by java on 24.02.2017.
 */
public class Citizen {

    private long id;
    private String firsName;
    private String lastName;
    private int age;

    public Citizen(long id, String firsName, String lastName, int age) {
        this.id = id;
        this.firsName = firsName;
        this.lastName = lastName;
        this.age = age;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
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

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
