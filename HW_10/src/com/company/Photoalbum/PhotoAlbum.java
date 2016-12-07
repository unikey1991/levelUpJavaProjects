package com.company.Photoalbum;

import java.util.Arrays;

/**
 * Created by unike on 07.12.2016.
 */
public class PhotoAlbum {
    int numOfPages;
    int photosOnPage;
    public Page pages[];


    public PhotoAlbum(int numOfPages, int photosOnPage) {
        this.numOfPages = numOfPages;
        this.photosOnPage = photosOnPage;
        pages = new Page[numOfPages];
        for (int i = 0; i < numOfPages; i++){
            pages[i] = new Page(i, photosOnPage);
        }
    }

    public void addPhotoOnAlbum(int pageNumber, String name, int photoNumber){
        pages[pageNumber].photoOnPage[photoNumber] = new Photo(name);
    }

    public void getSumOfPfotos(){
        int count = 0;
        for (int i = 0; i < pages.length; i++){
            for (int j = 0; j < pages[i].photoOnPage.length; j++){
                if (pages[i].photoOnPage[j] != null) count++;
            }
        }
        System.out.println("Количество фото - "+count);
    }

    @Override
    public String toString() {
        return "PhotoAlbum{" +
                "numOfPages=" + numOfPages +
                ", photosOnPage=" + photosOnPage +
                '}';
    }
}