package com.company.Photoalbum;

/**
 * Created by unike on 07.12.2016.
 */
public class Page {

    int pageNumber;
    int photosOnPage;
    public Photo photoOnPage[];

    public Page(int pageNumber, int photosOnPage) {
        this.pageNumber = pageNumber;
        this.photosOnPage = photosOnPage;
        photoOnPage = new Photo[photosOnPage];
    }
}
