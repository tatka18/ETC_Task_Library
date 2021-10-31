package by.epamtc.library.dao.impl;

import by.epamtc.library.dao.FillObject;
import by.epamtc.library.model.Book;
import by.epamtc.library.model.User;

public class FillObjectImpl implements FillObject {
    @Override
    public User fillUser(String string) {
        User user = new User();
        String[] params = string.split(" ");

        user.setId(Long.parseLong(parser(params[0])));
        user.setLogin(parser(params[1]));
        user.setPassword(parser(params[2]));
        user.setFirstName(parser(params[3]));
        user.setLastName(parser(params[4]));

        return user;
    }

    @Override
    public Book fillBook(String string) {
        Book book = new Book();
        String[] params = string.split(" ");

        book.setId(Long.parseLong(parser(params[0])));
        book.setBookName(parser(params[1]));
        book.setAuthor(parser(params[2]));
        book.setYearOfPublishing(Integer.parseInt(parser(params[3])));
        book.setCategory(parser(params[4]));

        return book;
    }

    private String parser(String string){
        String delimiter = "=";
        StringBuilder result = new StringBuilder(string);
        return result.substring(result.indexOf(delimiter) + 1);
    }
}
