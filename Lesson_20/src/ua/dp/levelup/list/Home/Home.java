package ua.dp.levelup.list.Home;

import ua.dp.levelup.list.List.Student;

import java.util.Comparator;

/**
 * Created by unike on 09.02.2017.
 */
public class Home {

    private int homeNumber;
    private String city;
    private String street;
    private int numberOfFloors;
    private int numberOfResidents;

    public Home(int homeNumber, String city, String street, int numberOfFloors, int numberOfResidents) {
        this.homeNumber = homeNumber;
        this.city = city;
        this.street = street;
        this.numberOfFloors = numberOfFloors;
        this.numberOfResidents = numberOfResidents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Home home = (Home) o;

        return homeNumber == home.homeNumber && city.equals(home.city);

    }

    @Override
    public int hashCode() {
        int result = homeNumber;
        result = 31 * result + city.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Home{" +
                "homeNumber=" + homeNumber +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                ", numberOfResidents=" + numberOfResidents +
                '}';
    }


    //который будет сортировать дома по номеру
//    @Override
//    public int compareTo(Home o) {
//        if (this.homeNumber == o.getHomeNumber()){
//            if (this.city.equals(o.getCity())){
//                if (this.street.equals(o.getStreet())){
//                    return 0;
//                }return this.street.compareTo(o.getStreet());
//            }return this.city.compareTo(o.getCity());
//        }return Integer.compare(this.homeNumber, o.getHomeNumber());
//    }


    //который будет сортировать дома по количеству жильцов
//    @Override
//    public int compareTo(Home o) {
//        if (this.numberOfResidents == o.getIntnumberOfResidents()){
//            if (this.city.equals(o.getCity())){
//                if (this.street.equals(o.getStreet())){
//                    return 0;
//                }return this.street.compareTo(o.getStreet());
//            }return this.city.compareTo(o.getCity());
//        }return Integer.compare(this.numberOfResidents, o.getIntnumberOfResidents());
//    }


    public int getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(int homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public int getNumberOfResidents() {
        return numberOfResidents;
    }

    public void setNumberOfResidents(int numberOfResidents) {
        this.numberOfResidents = numberOfResidents;
    }
}
