package by.epamtc.library.service;

import by.epamtc.library.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks() throws ServiceException;
    Book findByName(String name);
}
