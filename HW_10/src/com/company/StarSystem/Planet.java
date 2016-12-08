package com.company.StarSystem;

/**
 * Created by unike on 08.12.2016.
 */
public class Planet {

    private int distanceToStar;
    private String name;
    private int area;
    private int age;
    private int numOfCompanions;
    private Moon moon[];

    public Planet(int distanceToStar, String name, int area, int age, int numOfCompanions) {
        this.distanceToStar = distanceToStar;
        this.name = name;
        this.area = area;
        this.age = age;
        this.numOfCompanions = numOfCompanions;
        if (numOfCompanions > 0) moon = new Moon[numOfCompanions] ;
    }


}
