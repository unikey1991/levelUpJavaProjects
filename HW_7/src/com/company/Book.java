package com.company;


/**
 * Created by unike on 27.11.2016.
 */
public class Book {


    /*Создать класс Book с полями:
    name (строка), bookType (перечисление), author (строка), year (целое число).
    Написать конструктор со всеми параметрами.
    Опишите с помощью enum тип данных для хранения литературных жанров
    (роман, сказка, комедия, драма, научная фантастика, детектив).
    Создать объекты класса книга (число объектов соответствует числу жанров).
*/
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




