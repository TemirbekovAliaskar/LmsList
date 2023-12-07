package service.impl;

import models.Book;
import models.DataBase;
import service.BookService;

import java.util.List;

public class BookServiceimpl implements BookService {
    @Override
    public Book saveBook(long libraryId, Book book) {
        for (int i = 0; i < DataBase.libraries.size(); i++) {
            if (DataBase.libraries.get(i).getId() == libraryId){
               DataBase.libraries.get(i).bookList.add(book);
            }
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks(Long libraryId) {
        for (int i = 0; i < DataBase.libraries.size(); i++) {
            if (DataBase.libraries.get(i).getId().equals(libraryId)){
                System.out.println("DataBase.books = " + DataBase.books);
            }
        }return DataBase.books;
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        for (int i = 0; i < DataBase.libraries.size(); i++) {
            if (DataBase.libraries.get(i).getId().equals(libraryId )){
                for (int j = 0; j < DataBase.libraries.get(i).bookList.size(); j++) {
                    if (DataBase.libraries.get(i).bookList.get(j).getId() == bookId){
                        return DataBase.libraries.get(i).bookList.get(j);

                    }
                }
            }
        }return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        for (int i = 0; i < DataBase.libraries.size(); i++) {
            if (DataBase.libraries.get(i).getId().equals( libraryId)){
                for (int j = 0; j < DataBase.books.size(); j++) {
                    if (DataBase.books.get(i).getId() == libraryId){
                        DataBase.books.remove(DataBase.books.get(i));
                        System.out.println("Successful deleted book!!!");
                    }
                }
            }
        }return "";
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        for (int i = 0; i < DataBase.libraries.size(); i++) {
            if (DataBase.libraries.get(i).getId().equals(libraryId)){
                DataBase.books.clear();
                DataBase.libraries.get(i).bookList.clear();
                System.out.println("Успешно удалено все книги ! ");
            }
        }
    }
}
