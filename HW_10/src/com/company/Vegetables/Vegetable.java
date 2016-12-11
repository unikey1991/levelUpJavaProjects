package com.company.Vegetables;

/**
 * Created by unike on 11.12.2016.
 */
public class Vegetable {

    private final double proteins;
    private final double carbohydrates;
    private final double fats;
    private final double calories;
    private final String group;
    private double weight;


    public Vegetable(double proteins, double carbohydrates, double fats, double calories, String group, double weight) {
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
        this.calories = calories;
        this.group = group;
        this.weight = weight;
    }


    public double getCalories() {
        return calories;
    }

    public double getProteins() {
        return proteins;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getFats() {
        return fats;
    }

    public double getWeight() {
        return weight;
    }


}
