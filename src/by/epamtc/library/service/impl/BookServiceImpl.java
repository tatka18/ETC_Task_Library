package by.epamtc.library.service.impl;

import by.epamtc.library.dao.DaoException;
import by.epamtc.library.dao.DaoProvider;
import by.epamtc.library.model.Book;
import by.epamtc.library.service.BookService;
import by.epamtc.library.service.ServiceException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public boolean createNewBook(String bookName, String author, String yearOfPublishing, String category) throws ServiceException{
        String stringPattern = "\\d+";
        Pattern pattern = Pattern.compile(stringPattern);

        Matcher matcher = pattern.matcher(yearOfPublishing);
        boolean result;
        try {
            if (!matcher.matches()) {
                throw new NumberFormatException("incoming value is not number");
            }
        int parsedYear = Integer.parseInt(yearOfPublishing);
        Book book = new Book(bookName, author, parsedYear, category);
            result = DaoProvider.getInstance().getBookDao().addNewBook(book);
        }catch (DaoException e){
            throw new ServiceException("Error during creating new book", e);
        } catch (NumberFormatException e){
            throw new ServiceException("Wrong number format", e);
        }
        return result;
    }

    @Override
    public boolean editBookCategory(String name, String author, String category) throws ServiceException{
        try{
            List<Book> bookList = DaoProvider.getInstance().getBookDao().findAllBooks();
            for(Book book : bookList){
                if(book.getBookName().equals(name) && book.getAuthor().equals(author)){
                    book.setCategory(category);
                }
            }
            return DaoProvider.getInstance().getBookDao().editBookDataFile(bookList);
        }catch(DaoException e){
            throw new ServiceException("Error during edit book", e);
        }
    }
}
