package com.company.Vegetables.Alliums;

import com.company.Vegetables.Vegetable;

/**
 * Created by unike on 11.12.2016.
 */
public class Alliums extends Vegetable {


    String species;


    public Alliums(double proteins, double carbohydrates, double fats, double calories, double weight, String species) {
        super(proteins, carbohydrates, fats, calories, "Alliums", weight);
        this.species = species;
    }
}

