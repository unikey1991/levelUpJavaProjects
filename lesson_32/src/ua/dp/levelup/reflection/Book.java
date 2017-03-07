package ua.dp.levelup.reflection;

/**
 * Created by java on 07.03.2017.
 */
public class Book {

    @ToXML
    final long id;
    @ToXML
    private String bookName;
    private int pageCount;
    public String autor;

    public Book(long id, String bookName, int pageCount, String autor) {
        this.id = id;
        this.bookName = bookName;
        this.pageCount = pageCount;
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public long getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
