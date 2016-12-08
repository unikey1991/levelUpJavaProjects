package com.company.StarSystem;

/**
 * Created by unike on 07.12.2016.
 */
public class StarSystem {

    private int size;
    private String name;
    private int age;
    private int numOfPlanets;
    private Star star;
    private Planet planet[];

    public StarSystem(int size, String name, int age, int numOfPlanets, int starSize, String starName, int starTemp, int starWeight) {
        this.size = size;
        this.name = name;
        this.age = age;
        this.numOfPlanets = numOfPlanets;
        star = new Star(starSize, starName, starTemp, starWeight);
        planet = new Planet[numOfPlanets];
    }

    public void addPlanetToSystem(int planetPlaceId, int distanceToStar, String name, int area,int age, int numOfCompanions){
        planet[planetPlaceId] = new Planet(distanceToStar, name, area, age, numOfCompanions);
    }

    public int getNumOfPlanets() {
        return numOfPlanets;
    }

    public String getStarName() {
        return star.getName();
    }
}
