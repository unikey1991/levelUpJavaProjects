package autosalon;

/**
 * Created by java on 13.01.2017.
 */
public class Lanos extends Car {


    public Lanos(int maxSpeed, double fuelConsumption, Configuration configuration) {
        super(maxSpeed, fuelConsumption, configuration);
    }

    @Override
    public double getPrice() {
        switch (getConfiguration()){
            case LUX:
                return 10_000;
            case EXCLUSIVE:
                return 15_000;
            default:
                return 5_000;
        }
    }

    @Override
    public void beep() {
        System.out.println("Beeeep! Beep-beep");
    }
}
