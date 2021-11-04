package by.epamtc.library.controller.impl;

import by.epamtc.library.controller.Command;
import by.epamtc.library.model.Book;
import by.epamtc.library.service.ServiceException;
import by.epamtc.library.service.ServiceProvider;

import java.util.List;

public class ShowAllCatalogCommand implements Command {
    @Override
    public String execute(String request) {
        StringBuilder response = new StringBuilder();
        try{
            List<Book> bookList = ServiceProvider.getInstance().getBookService().findAllBooks();
            for(Book book : bookList){
                response.append(book.toString()).append("\n");
            }
        }catch (ServiceException e){
            e.printStackTrace();
            response.append("Something went wrong. We cant show you all catalog");
        }
        return response.toString();
    }
}
