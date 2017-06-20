package ua.dp.levelup;

/**
 * Created by java on 16.06.2017.
 */
public class User {

    private long id;
    private String email;
    private String name;
    private String lastName;
    private double balance = 0;

    public User(long id, String email, String name, String lastName) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public double increaseBalance(double inc){
        return balance+= inc;
    }

    public double decreaseBalance(double dec){
        return balance-= dec;
    }

    public double getBalance() {
        return balance;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", balance=" + balance +
                '}';
    }

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

