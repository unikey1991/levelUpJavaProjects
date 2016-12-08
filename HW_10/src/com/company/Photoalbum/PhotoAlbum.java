package com.company.Photoalbum;

import java.util.Arrays;

/**
 * Created by unike on 07.12.2016.
 */
public class PhotoAlbum {
    private int numOfPages;
    private int photosOnPage;
    protected Page pages[];


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
        for (int i = 0; i < pages.length; i++){
            System.out.println("Сраница альбома №"+(i+1));
            for (int j = 0; j < pages[i].photoOnPage.length; j++){
                if (pages[i].photoOnPage[j] != null) System.out.print(pages[i].photoOnPage[j].name);
            }
            System.out.println();
        }
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhotoAlbum that = (PhotoAlbum) o;

        if (numOfPages != that.numOfPages) return false;
        if (photosOnPage != that.photosOnPage) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(pages, that.pages);
    }

    @Override
    public int hashCode() {
        int result = numOfPages;
        result = 31 * result + photosOnPage;
        result = 31 * result + Arrays.hashCode(pages);
        return result;
    }
}
