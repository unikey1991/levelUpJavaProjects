package com.company.Vegetables.Roots;

import com.company.Vegetables.Vegetable;

/**
 * Created by unike on 11.12.2016.
 */
public class Roots extends Vegetable {


    String species;

    public Roots(double proteins, double carbohydrates, double fats, double calories, double weight, String species) {
        super(proteins, carbohydrates, fats, calories, "roots", weight);
        this.species = species;
    }
}
