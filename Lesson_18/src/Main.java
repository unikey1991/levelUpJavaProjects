import autosalon.*;
import model.Employee;
import model.Junior;
import model.Middle;
import model.Senior;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {



        /*Employee[] employees = {new Junior(), new Middle(), new Senior()};

        for (Employee emp:employees) {
            emp.calculateSalary();
        }*/


        Car[] cars = {new Lanos(160, 10, Configuration.BASIC),
                new Mercedes(220, 15, Configuration.LUX),
                new Opel(220, 18, Configuration.EXCLUSIVE),
                new Opel(180, 18, Configuration.BASIC),
                new Lanos(170, 12, Configuration.LUX),
                new Mercedes(180, 18, Configuration.BASIC)
        };

        AutoSalon autoSalon = new AutoSalon(cars);

        System.out.println("Total price: "+autoSalon.calculateCarsPrice());
        System.out.println(Arrays.toString(autoSalon.sortByFuelConsumption()));
        System.out.println(Arrays.toString(autoSalon.getCarsBySpeedRange(120,160)));

    }
}
