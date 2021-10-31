package by.epamtc.library.controller.impl;

import by.epamtc.library.controller.Command;
import by.epamtc.library.model.Book;
import by.epamtc.library.service.ServiceException;
import by.epamtc.library.service.ServiceProvider;
import by.epamtc.library.view.PrintResult;

import java.util.List;

public class ShowAllCatalogCommand implements Command {
    @Override
    public String execute(String request) {
        try{
            List<Book> bookList = ServiceProvider.getInstance().getBookService().findAllBooks();
            PrintResult.printBookList(bookList);
        }catch (ServiceException e){
            e.printStackTrace();
        }
        return null;
    }
}
