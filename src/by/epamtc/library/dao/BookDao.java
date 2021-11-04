package by.epamtc.library.dao;

import by.epamtc.library.model.Book;

import java.util.List;

public interface BookDao {
    List<Book> findAllBooks() throws DaoException;
    Book findByName(String name) throws DaoException;
    Book findByNameAndAuthor(String name, String author) throws DaoException;
    boolean createNewBook(Book book) throws DaoException;
    boolean editBookDataFile(List<Book> list) throws DaoException;
}
