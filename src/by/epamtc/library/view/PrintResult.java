package by.epamtc.library.view;

import by.epamtc.library.model.Book;

import java.util.List;

public class PrintResult {
    public static void printString(String string){
        System.out.println(string);
    }
    public static void printBookList(List<Book> bookList){
        for (Book book: bookList){
            System.out.println(book.getBookName() + " " + book.getAuthor());
        }
    }
    public static void printBook(Book book){
        System.out.println(book.getBookName() + " " + book.getAuthor() + " " + book.getCategory()
        + " " + book.getYearOfPublishing());
    }

}
