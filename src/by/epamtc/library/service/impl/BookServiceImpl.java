package by.epamtc.library.service.impl;

import by.epamtc.library.dao.DaoException;
import by.epamtc.library.dao.DaoProvider;
import by.epamtc.library.model.Book;
import by.epamtc.library.service.BookService;
import by.epamtc.library.service.ServiceException;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public List<Book> findAllBooks() throws ServiceException {
        List<Book> bookList;
        try{
            bookList = DaoProvider.getInstance().getBookDao().findAllBooks();
        }catch (DaoException e){
            throw new ServiceException("error during findAllBooks", e);
        }
        return bookList;
    }

    @Override
    public Book findByName(String name) throws ServiceException {
        Book book;
        try{
            book = DaoProvider.getInstance().getBookDao().findByName(name);
        }catch (DaoException e){
            throw new ServiceException("error during finding book by name", e);
        }
        return book;
    }

    @Override
    public boolean createNewBook(String bookName, String author, int yearOfPublishing, String category) throws ServiceException{
        boolean result;
        try{
            result = DaoProvider.getInstance().getBookDao().createNewBook(bookName, author, yearOfPublishing, category);
        }catch (DaoException e){
            throw new ServiceException("Error during creating new book", e);
        }
        return result;
    }
}
