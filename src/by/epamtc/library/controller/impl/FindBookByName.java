package by.epamtc.library.controller.impl;

import by.epamtc.library.controller.Command;
import by.epamtc.library.model.Book;
import by.epamtc.library.service.ServiceException;
import by.epamtc.library.service.ServiceProvider;
import by.epamtc.library.view.PrintResult;

public class FindBookByName implements Command {
    @Override
    public String execute(String request) {
        String divider = "=";

        String result = "";
        String bookName = request.substring(request.indexOf(divider) + 1);

        try{
            Book book = ServiceProvider.getInstance().getBookService().findByName(bookName);
            PrintResult.printBook(book);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return result;
    }
}
