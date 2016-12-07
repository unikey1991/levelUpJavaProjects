package com.company.Photoalbum;

/**
 * Created by unike on 07.12.2016.
 */
public class Page extends PhotoAlbum {

    int pageNumber;

    Photo photoOnPage[] = new Photo[super.photosOnPage];


    public Page(int numOfPages, int photosOnPage, int pageNumber) {
        super(numOfPages, photosOnPage);
        this.pageNumber = pageNumber;
    }
}
