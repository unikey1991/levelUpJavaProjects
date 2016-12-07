package com.company;

import com.company.Animal.Puppy;
import com.company.Photoalbum.PhotoAlbum;

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


        System.out.println(photoAlbum1.pages.length);
        System.out.println(photoAlbum1.pages[0].photoOnPage.length);

        photoAlbum1.getSumOfPfotos();



    }
}
