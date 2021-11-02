package by.epamtc.library.dao.impl;

import by.epamtc.library.dao.BookDao;
import by.epamtc.library.dao.DaoException;
import by.epamtc.library.dao.FillObject;
import by.epamtc.library.model.Book;
import by.epamtc.library.scaner.Scan;
import by.epamtc.library.util.ListData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private final FillObject fillObject = new FillObjectImpl();
    @Override
    public List<Book> findAllBooks() throws DaoException {
        List<Book> bookList = new ArrayList<>();
        try{
            List<String> stringList = Scan.readTextFromFile(ListData.BOOKS);
            for (String string: stringList){
                Book book = fillObject.fillBook(string);
                bookList.add(book);
            }
        }catch (IOException e){
            throw new DaoException("error during finding all books", e);
        }
        return bookList;
    }

    @Override
    public Book findByName(String name) throws DaoException {
        try{
            List<String> stringList = Scan.readTextFromFile(ListData.BOOKS);
            for (String string: stringList){
                Book book = fillObject.fillBook(string);
                if(book.getBookName().equals(name)){
                    return book;
                }
            }
        }catch (IOException e){
            throw new DaoException("error by finding book by name", e);
        }

        return null;
    }
}
