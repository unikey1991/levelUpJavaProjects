package autosalon;

/**
 * Created by java on 13.01.2017.
 */
public abstract class Car implements Action {


    private int maxSpeed;
    private double fuelConsumption;
    private Configuration configuration;
    private int speed;

    public Car(int maxSpeed, double fuelConsumption, Configuration configuration) {
        this.fuelConsumption = fuelConsumption;
        this.maxSpeed = maxSpeed;
        this.configuration = configuration;
    }



    public abstract double getPrice();

    @Override
    public void stop() {
        speed = 0;
        System.out.println("Car is stopped. Current speed is "+speed);
    }

    @Override
    public void drive() {
        speed = maxSpeed;
        System.out.println("Car is moving. Current speed is "+speed);

    }

    @Override
    public void beep() {

        System.out.println("FA-FA MOTHER FUCKER!");
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public String toString() {
        return "Car{" +
                "maxSpeed=" + maxSpeed +
                ", fuelConsumption=" + fuelConsumption +
                ", configuration=" + configuration +
                '}';
    }


}
