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
        try{
            return DaoProvider.getInstance().getBookDao().findAllBooks();
        }catch (DaoException e){
            throw new ServiceException("error during findAllBooks", e);
        }

    }

    @Override
    public Book findByName(String name) {
        return null;
    }
}
