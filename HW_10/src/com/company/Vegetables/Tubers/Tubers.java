package com.company.Vegetables.Tubers;

import com.company.Vegetables.Vegetable;

/**
 * Created by unike on 11.12.2016.
 */
public class Tubers extends Vegetable {

    String species;

    public Tubers(double proteins, double carbohydrates, double fats, double calories, double weight, String species) {
        super(proteins, carbohydrates, fats, calories, "tubers", weight);
        this.species = species;
    }
}
