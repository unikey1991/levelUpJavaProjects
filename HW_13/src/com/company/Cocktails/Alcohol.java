package com.company.Cocktails;

/**
 * Created by unike on 18.12.2016.
 */
public class Alcohol {

    //Vodka("vodka", 20), Pivo("pivo", 30), Vino("vino", 20);


    String name;
    int amount;

    public Alcohol(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
