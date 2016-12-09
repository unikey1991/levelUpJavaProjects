package com.company.Photoalbum;

/**
 * Created by unike on 07.12.2016.
 */
public class Page {

    private int pageNumber;
    public Photo photos[];

    Page(int pageNumber, int photosOnPage) {
        this.pageNumber = pageNumber;
        photos = new Photo[photosOnPage];
    }

    public void addPhoto(int photoNumber, String name){
        if (photos[photoNumber] == null){
            photos[photoNumber] = new Photo(name);
            System.out.println("Фото добавлено");
        }
        else System.out.println("На этом месте уже есть фото");
    }
}
