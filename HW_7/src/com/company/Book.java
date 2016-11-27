package com.company;


/**
 * Created by unike on 27.11.2016.
 */
public class Book {

    String name;
    int year;
    String autor;
    BookType bookType;


    public Book(String name, int year, String autor, BookType bookType) {
        this.name = name;
        this.year = year;
        this.autor = autor;
        this.bookType = bookType;
    }
}

enum BookType {
    ROMAN,
    SKAZKA,
    KOMEDIA,
    DRAMA,
    NAU4NAYA_FANTASTIKA,
    DETEKTIV
}




