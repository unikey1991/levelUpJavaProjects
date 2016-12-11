package com.company.Vegetables;

import java.util.Arrays;

/**
 * Created by unike on 10.12.2016.
 */
public class Salad {

    private String name;
    private int numOfIngredients;
    private double caloriesSum;
    Vegetable vegetable[];


    public Salad(String name, int numOfIngredients) {
        this.name = name;
        this.numOfIngredients = numOfIngredients;
        vegetable = new Vegetable[numOfIngredients];
    }


    public double calSum(){
        for (int i = 0; i < vegetable.length; i++){
            if (vegetable[i] != null) caloriesSum += vegetable[i].getCalories()/100*vegetable[i].getWeight();
        }
        return caloriesSum;
    }

    public String getName() {
        return name;
    }

    public void sortByCalories(){
        int i = 1, test = 2;
        Vegetable buffer;
        while (test > 0) {
            if (vegetable[i - 1].getCalories() > vegetable[i].getCalories()) {
                buffer = vegetable[i];
                vegetable[i] = vegetable[i - 1];
                vegetable[i - 1] = buffer;
                test = 2;
            }
            i++;
            if (i == vegetable.length) {
                i = 1;
                test--;
            }
        }
        for (Vegetable v:vegetable) {
            System.out.println(v.getCalories());
        }
    }

    public int getNumOfIngredients() {
        return numOfIngredients;
    }

    public double getCaloriesSum() {
        return caloriesSum;
    }

    @Override
    public Object clone() {
        Salad salad = new Salad(getName(), getNumOfIngredients());
        for (int i = 0; i < getNumOfIngredients(); i++){
            salad.vegetable[i] = vegetable[i];
        }
        return salad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Salad salad = (Salad) o;

        if (numOfIngredients != salad.numOfIngredients) return false;
        if (Double.compare(salad.caloriesSum, caloriesSum) != 0) return false;
        if (name != null ? !name.equals(salad.name) : salad.name != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(vegetable, salad.vegetable);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + numOfIngredients;
        temp = Double.doubleToLongBits(caloriesSum);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + Arrays.hashCode(vegetable);
        return result;
    }
}
