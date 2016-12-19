package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here


        Bar bar = new Bar("The Blue Oyster Bar");

        bar.addPersonal("Brad", 25, "портвейн 777","бармен", bar);
        bar.addPersonal("Julia", 18, "b52","бармен" , bar);
        bar.addPersonal("Sergio", 23,"sd","официант", bar);

        bar.fillWarehouse("pivo", 50);
        bar.fillWarehouse("vodka", 30);
        bar.fillWarehouse("vino", 20);
        bar.fillWarehouse("vino", 20);

        System.out.println(bar.getAlcohol()[0].getAmount());
        System.out.println(bar.getAlcohol()[1].getAmount());
        System.out.println(bar.getAlcohol()[2].getAmount());

        bar.delPersonal("Julia","бармен");


        bar.addOrder(0, "pivo", 5);
        bar.addOrder(0, "vodka", 6);
        bar.addOrder(0, "vino", 7);

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
