package by.epamtc.library.controller.impl;

import by.epamtc.library.controller.Command;
import by.epamtc.library.model.Book;
import by.epamtc.library.service.ServiceException;
import by.epamtc.library.service.ServiceProvider;

public class FindBookByName implements Command {
    @Override
    public String execute(String request) {
        String divider = "=";
        String bookName = request.substring(request.indexOf(divider) + 1);

        StringBuilder response = new StringBuilder();
        try{
            Book book = ServiceProvider.getInstance().getBookService().findByName(bookName);
            if(book != null){
                response.append(book.toString());
            }else {
                response.append("Sorry, but we haven't the book with this name");
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            response.append("Something went wrong. We can't find book");
        }
        return response.toString();
    }
}
