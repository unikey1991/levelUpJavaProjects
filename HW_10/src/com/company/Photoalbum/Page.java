package com.company.Photoalbum;

/**
 * Created by unike on 07.12.2016.
 */
public class Page {

    private int pageNumber;
    public Photo photoOnPage[];

    Page(int pageNumber, int photosOnPage) {
        this.pageNumber = pageNumber;
        photoOnPage = new Photo[photosOnPage];
    }
}
