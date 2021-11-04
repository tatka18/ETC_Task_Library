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
        List<Book> bookList;
        try{
             bookList = createBookList();
        }catch (IOException e){
            throw new DaoException("error during finding all books", e);
        }
        return bookList;
    }

    @Override
    public Book findByName(String name) throws DaoException {
        try{
            List<Book> bookList = createBookList();
            for (Book book: bookList){
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
    public Book findByNameAndAuthor(String name, String author) throws DaoException {
        try{
            List<Book> bookList = createBookList();
            for (Book book: bookList){
                if(book.getBookName().equals(name) && book.getAuthor().equals(author)){
                    return book;
                }
            }
        }catch (IOException e){
            throw new DaoException("error by finding book by name", e);
        }
        return null;
    }

    @Override
    public boolean createNewBook(Book book) throws DaoException {
        try(FileWriter writer = new FileWriter(ListData.BOOKS, true)){
            List<Book> bookList = createBookList();
            int lastId = bookList.size();

            int id = lastId + 1;
            book.setId(id);
            createStringBook(book);
            writer.write(book.toString());
            writer.flush();
        }catch (IOException e){
            throw new DaoException( "Error during creating a new book", e);
        }
        return true;
    }

    @Override
    public boolean editBookDataFile(List<Book> bookList) throws DaoException{
        try{
           rewriteDataFile(buildDataFileString(bookList));
        }catch (IOException e){
            throw new DaoException("Error during editing book", e);
        }
        return true;
    }

    private List<Book> createBookList() throws IOException {
        List<Book> bookList = new ArrayList<>();
        try {
            List<StringBuilder> stringList = Scan.readTextFromFile(ListData.BOOKS);
            for (StringBuilder string : stringList) {
                Book book = fillObject.fillBook(string.toString());
                bookList.add(book);
            }
        }catch (IOException e){
            throw new IOException("Error during Creating Book List", e);
        }
        return bookList;
    }

    private StringBuilder createStringBook(Book book){
        StringBuilder newBookString = new StringBuilder();
        newBookString.append("id=").append(book.getId())
                .append(" bookName=").append(book.getBookName())
                .append(" author=").append(book.getAuthor())
                .append(" yearOfPublishing=").append(book.getYearOfPublishing())
                .append(" category=").append(book.getCategory())
                .append("\r\n");
        return newBookString;
    }

    private StringBuilder buildDataFileString(List<Book> bookList){
        StringBuilder dataString = new StringBuilder();
        for(Book book : bookList){
            dataString.append(createStringBook(book));
        }return dataString;
    }

    private void rewriteDataFile(StringBuilder string) throws IOException{
        try(FileWriter writer = new FileWriter(ListData.BOOKS, false)){
            writer.write(string.toString());
            writer.flush();
        }catch (IOException e){
            throw new IOException("Error during rewrite file", e);
        }
    }
}
