package ua.dp.levelup.list.Home;

import ua.dp.levelup.list.List.Student;

/**
 * Created by unike on 09.02.2017.
 */
public class Home implements Comparable<Home> {

    private int homeNumber;
    private String city;
    private String street;
    private int numberOfFloors;
    private int intnumberOfResidents;

    public Home(int homeNumber, String city, String street, int numberOfFloors, int intnumberOfResidents) {
        this.homeNumber = homeNumber;
        this.city = city;
        this.street = street;
        this.numberOfFloors = numberOfFloors;
        this.intnumberOfResidents = intnumberOfResidents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Home home = (Home) o;

        if (homeNumber != home.homeNumber) return false;
        if (numberOfFloors != home.numberOfFloors) return false;
        if (intnumberOfResidents != home.intnumberOfResidents) return false;
        if (city != null ? !city.equals(home.city) : home.city != null) return false;
        return street != null ? street.equals(home.street) : home.street == null;
    }

    @Override
    public int hashCode() {
        int result = homeNumber;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + numberOfFloors;
        result = 31 * result + intnumberOfResidents;
        return result;
    }

    @Override
    public String toString() {
        return "Home{" +
                "homeNumber=" + homeNumber +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                ", intnumberOfResidents=" + intnumberOfResidents +
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
//        if (this.intnumberOfResidents == o.getIntnumberOfResidents()){
//            if (this.city.equals(o.getCity())){
//                if (this.street.equals(o.getStreet())){
//                    return 0;
//                }return this.street.compareTo(o.getStreet());
//            }return this.city.compareTo(o.getCity());
//        }return Integer.compare(this.intnumberOfResidents, o.getIntnumberOfResidents());
//    }

    //который будет сортировать дома по названию города/улицы
    @Override
    public int compareTo(Home o) {
        if (this.city.equals(o.getCity())) {
            if (this.street.equals(o.getStreet())) {
                if (this.homeNumber == o.getHomeNumber()) {
                    return 0;
                }
                return Integer.compare(this.homeNumber, o.getHomeNumber());
            }

            return this.street.compareTo(o.getStreet());
        }
        return this.city.compareTo(o.getCity());
    }

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

    public int getIntnumberOfResidents() {
        return intnumberOfResidents;
    }

    public void setIntnumberOfResidents(int intnumberOfResidents) {
        this.intnumberOfResidents = intnumberOfResidents;
    }
}
