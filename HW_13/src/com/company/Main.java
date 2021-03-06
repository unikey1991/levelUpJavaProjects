package com.company;

import com.company.Exceptions.DrinkNotFoundException;
import com.company.Exceptions.NegativeTipsException;
import com.company.Exceptions.NotExistBarException;
import com.company.Exceptions.OrderDrinkOverException;

public class Main {

    public static void main(String[] args) throws NotExistBarException, NegativeTipsException, DrinkNotFoundException, OrderDrinkOverException {
        // write your code here


        Bar bar = new Bar("The Blue Oyster Bar");

        bar.addPersonal("Brad", 25, "портвейн 777","бармен", bar);
        bar.addPersonal("Julia", 18, "b52","бармен" , bar);
        bar.addPersonal("Sergio", 23,"sd","официант", bar);


        System.out.println(bar.getAlcohol()[0].getAmount());
        System.out.println(bar.getAlcohol()[1].getAmount());
        System.out.println(bar.getAlcohol()[2].getAmount());

        bar.delPersonal("Julia","бармен");


        bar.addOrder(0, "Beer", 10);
        bar.addOrder(0, "Vodka", 6);
        bar.addOrder(0, "Juice", 7);

        System.out.println(bar.getAlcohol()[0].getAmount());
        System.out.println(bar.getAlcohol()[1].getAmount());
        System.out.println(bar.getAlcohol()[2].getAmount());

        bar.performeOrder(0, bar);
        bar.performeOrder(0, bar);
        bar.performeOrder(0, bar);

        bar.takeTips(500,0);
        bar.shareTip();

    }
}
