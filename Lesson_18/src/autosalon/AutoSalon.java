package autosalon;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by java on 13.01.2017.
 */
public class AutoSalon {

    private Car[] cars;

    public AutoSalon(Car[] cars){
        this.cars = cars;
    }

    public double calculateCarsPrice(){
        double totalPrice = 0;

        for (Car c: cars){
            totalPrice += c.getPrice();
        }
        return totalPrice;
    }

    public Car[] getCarsBySpeedRange(int from, int to){
        List<Car> carList = new ArrayList<>();
        for(Car c : cars) {
            if(c.getMaxSpeed() <= to && c.getMaxSpeed() >= from){
                carList.add(c);
            }
        }
        return carList.toArray(new Car[1]);
    }

    public Car[] sortByFuelConsumption() {
        Car[] res = new Car[cars.length];
        System.arraycopy(cars, 0, res, 0, cars.length);
        Arrays.sort(res, getComparator());
        return res;
    }

    private Comparator<Car> getComparator() {
        return (c1, c2) -> Double.compare(c1.getFuelConsumption(), c2.getFuelConsumption());
    }
}
