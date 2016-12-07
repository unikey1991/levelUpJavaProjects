package com.company.Photoalbum;

/**
 * Created by unike on 07.12.2016.
 */
public class Photo{
    String name;


    public Photo(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Photo photo = (Photo) o;

        return name != null ? name.equals(photo.name) : photo.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
