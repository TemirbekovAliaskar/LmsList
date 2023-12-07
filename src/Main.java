import models.*;
import service.BookService;
import service.LibraryService;
import service.ReaderService;
import service.impl.BookServiceimpl;
import service.impl.LibraryServiceimpl;
import service.impl.ReaderServiceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Reader> readers = new ArrayList<>(Arrays.asList(
                new Reader(1L, "Jigit", "g@gmail.com", "0500383838", Gender.MALE),
                new Reader(2L, "Myrzaiym", "myrza@gmail.com", "0500500514", Gender.FEMALE),
                new Reader(3L, "Ali", "aliaskar@gmail.com", "0500389438", Gender.MALE)
        ));
        ArrayList<Reader> readers2 = new ArrayList<>(Arrays.asList(
                new Reader(5L, "Jigit", "g@gmail.com", "0500383838", Gender.MALE)

        ));

        ArrayList<Book> books = new ArrayList<>(Arrays.asList(
                new Book(1L, "Ak-Keme", "Chyngyz", Genre.CLASSIC),
                new Book(2L, "Шпион ", "James Cameron", Genre.DETECTIVE)
        ));

        ArrayList<Library> libraries = new ArrayList<>(Arrays.asList(
                new Library(1L, "Alykul Osmonov", "Park Pobedy", books, readers),
                new Library(2L, "Pobeda ", "Vostok 5", books, readers2)
        ));


        DataBase.readers.addAll(readers);
        DataBase.books.addAll(books);
        DataBase.libraries.addAll(libraries);


        while (true) {
            System.out.println("""
                    1.Readers     2. Books     3. Library
                    """);

                switch (new Scanner(System.in).nextLine()) {
                    case "1" -> method();
                    case "2"-> bookMethod();
                    case "3"-> libraryMethod();


            }
        }
    }

    public static void method() {

        ReaderService readerService = new ReaderServiceimpl();

        innerLoop:
        while (true) {
            System.out.println("""
                    1. Save Readers
                    2. Get All Readers
                    3. Get Reader by Id
                    4. Update Reader
                    5. as Sign Reader to Library
                    0. Exit
                    """);

            switch (new Scanner(System.in).nextLine()) {
                case "1" -> {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("ID :");
                    int id = scanner.nextInt();
                    System.out.println("Name : ");
                    String name = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("email : ");
                    String email = scanner.nextLine();
                    System.out.println("Phone number : ");
                    String num = scanner.nextLine();
                    System.out.println("Gender : ");
                    Reader reader = new Reader(id, name, email, num, Gender.FEMALE);
                    DataBase.readers.add(reader);
                }
                case "2" -> {
                    System.out.println(readerService.getAllReaders());
                }
                case "3" -> {
                    System.out.println("Id : ");
                    System.out.println(readerService.getReaderById(new Scanner(System.in).nextLong()));
                }
                case "4" -> {
                    readerService.updateReader(3L, new Reader(6, "Hann", "H@gmail.com", "7999", Gender.FEMALE));
                }
                case "5" ->{
                    readerService.assignReaderToLibrary(1L,2L);
                }
                case "0" -> {
                    break innerLoop;
                }
            }
        }

    }

    public static void bookMethod(){

        BookService bookService = new BookServiceimpl();
        while (true) {
            System.out.println("""
                           1.SaveBook
                           2.GetAllBooks 
                           3.GetBookById
                           4.DeleteBook
                           5.ClearBooks
                           0. Exit
                            """);
            switch (new Scanner(System.in).nextLine()) {
                case "1" -> {
                    DataBase.books.add(bookService.saveBook(1L, new Book(7L, "Wolf", "Ali", Genre.DETECTIVE)));
                }
                case "2" -> {
                    bookService.getAllBooks(1L);
                }
                case "3" ->{
                    System.out.println("  Книги :  " + bookService.getBookById(2L, 7L));
                }
                case "4" ->{
                    System.out.println(bookService.deleteBook(2L, 7L));
                }
                case "5" ->{
                    bookService.clearBooksByLibraryId(1L);
                }
                case "0" -> {
                    return;
                }
            }
        }
    }

    public static void libraryMethod(){
        LibraryService libraryService = new LibraryServiceimpl();
        ArrayList<Book> books = new ArrayList<>(Arrays.asList(
                new Book(8L, "Feruza ", "James Building", Genre.DETECTIVE)
        ));
        ArrayList<Reader> readers = new ArrayList<>(Arrays.asList(
                new Reader(6L, "Jan Voinov", "g@gmail.com", "0500383838", Gender.MALE),
                new Reader(7L, "Myrza", "myrza@gmail.com", "0500500514", Gender.FEMALE),
                new Reader(8L, "Ali", "aliaskar@gmail.com", "0500389438", Gender.MALE)
        ));
        ArrayList<Library>libraries =new ArrayList<>(Arrays.asList((new Library(4L,"Aly","Bisnkek",books,readers))));


        while (true){
            System.out.println("""
                    1.SaveLibrary
                    2.Get All Library
                    3.Get Library by id
                    4.Update Library
                    5.Delete Library
                    """);

            switch (new Scanner(System.in).nextLine()){
                case "1"->{
                    libraryService.saveLibrary(libraries) ;
                }
                case "2" ->{
                    System.out.println(libraryService.getAllLibraries());
                }
                case "3" ->{
                    System.out.println(libraryService.getLibraryById(1L));
                }
                case "4" ->{
                    libraryService.updateLibrary(1L,new Library(1L,"Ayul","Bishkek",books,readers));
                }
                case "5" ->{
                    System.out.println(libraryService.deleteLibrary(2L));
                }
            }
        }

    }
}