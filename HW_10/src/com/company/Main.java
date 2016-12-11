package com.company;

import com.company.Animal.Puppy;
import com.company.Figures.Square;
import com.company.Photoalbum.PhotoAlbum;
import com.company.StarSystem.StarSystem;
import com.company.Vegetables.Salad;
import com.company.Vegetables.Vinegret;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here


        Puppy puppy1 = new Puppy(5, "бобик", 5);


        puppy1.barking();
        System.out.println("имя щенка - "+puppy1.getName());
        puppy1.bite();
        puppy1.run();
        puppy1.jump();


        PhotoAlbum photoAlbum1 = new PhotoAlbum(5,4);
        photoAlbum1.addPhotoOnAlbum(0,"photo1",0);
        photoAlbum1.getSumOfPfotos();
        System.out.println(photoAlbum1.toString());


        StarSystem starSys1 = new StarSystem(100000, "Vladeniya Alekseya", 13000, 5, 500, "Solniwko :P", 200, 10);
        starSys1.addPlanetToSystem(0, 100500, "Earth", 100500, 100500, 1);
        System.out.println(starSys1.getNumOfPlanets());
        System.out.println(starSys1.getStarName());


        Square square = new Square("Black", 5, 5);

        Vinegret vinegret = new Vinegret();
        System.out.println(vinegret.calSum());
        vinegret.sortByCalories();
        Salad salad1 = (Salad) vinegret.clone();
        System.out.println(salad1.getName());








    }
}
