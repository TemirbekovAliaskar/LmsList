package models;


import java.util.ArrayList;
import java.util.List;

public class Library {
    private Long id;
    private String name;
    private String address;
    public List<Book> bookList = new ArrayList<>();
    public List<Reader> readerList;

    public Library(Long id, String name, String address, List<Book> bookList, List<Reader> readerList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.bookList = bookList;
        this.readerList = readerList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Reader> getReaderList() {
        return readerList;
    }

    public void setReaderList(List<Reader> readerList) {
        this.readerList = readerList;
    }

    @Override
    public String toString() {
        return "Library Information:\n" +
                "ID:      " + id + "\n" +
                "Name:    '" + name + "'\n" +
                "Address: '" + address + "'\n" +
                "Books:   " + bookList + "\n" +
                "Readers: " + readerList;
    }
}
