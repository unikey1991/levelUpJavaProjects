package ua.dp.levelup;

/**
 * Created by unike on 15.06.2017.
 */

public class Car {

    private double maxSpeed;
    private String model;
    private Color color;

    public Car() {
    }

    public Car(double maxSpeed, String model, Color color) {
        this.maxSpeed = maxSpeed;
        this.model = model;
        this.color = color;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "maxSpeed=" + maxSpeed +
                ", model='" + model + '\'' +
                ", color=" + color +
                '}';
    }
}
