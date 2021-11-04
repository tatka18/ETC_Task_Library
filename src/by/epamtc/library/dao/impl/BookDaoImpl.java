package by.epamtc.library.dao.impl;

import by.epamtc.library.dao.BookDao;
import by.epamtc.library.dao.DaoException;
import by.epamtc.library.dao.FillObject;
import by.epamtc.library.model.Book;
import by.epamtc.library.scaner.Scan;
import by.epamtc.library.util.ListData;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private final FillObject fillObject = new FillObjectImpl();
    @Override
    public List<Book> findAllBooks() throws DaoException {
        List<Book> bookList = new ArrayList<>();
        try{
            List<StringBuilder> stringList = Scan.readTextFromFile(ListData.BOOKS);
            for (StringBuilder string: stringList){
                Book book = fillObject.fillBook(string.toString());
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
            List<StringBuilder> stringList = Scan.readTextFromFile(ListData.BOOKS);
            for (StringBuilder string: stringList){
                Book book = fillObject.fillBook(string.toString());
                if(book.getBookName().equals(name)){
                    return book;
                }
            }
        }catch (IOException e){
            throw new DaoException("error by finding book by name", e);
        }

        return null;
    }

    @Override
    public boolean createNewBook(String bookName, String author, int yearOfPublishing, String category) throws DaoException {
        try(FileWriter writer = new FileWriter(ListData.BOOKS, true)){
            List<StringBuilder> stringList = Scan.readTextFromFile(ListData.BOOKS);
            int lastId = stringList.size();

            int id = lastId + 1;
            StringBuilder nextLine = new StringBuilder("\r\n");
            StringBuilder newString;
            newString = nextLine
                    .append("id=").append(id)
                    .append(" bookName=").append(bookName)
                    .append(" author=").append(author)
                    .append(" yearOfPublishing=").append(yearOfPublishing)
                    .append(" category=").append(category);
            writer.write(newString.toString());
        }catch (IOException e){
            throw new DaoException( "Error during creating a new book", e);
        }
        return true;
    }
}
