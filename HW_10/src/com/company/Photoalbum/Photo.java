package com.company.Photoalbum;

/**
 * Created by unike on 07.12.2016.
 */
public class Photo extends Page{
    String name;

    public Photo(int numOfPages, int photosOnPage, int pageNumber, String name) {
        super(numOfPages, photosOnPage, pageNumber);
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
