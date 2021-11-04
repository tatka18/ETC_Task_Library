package by.epamtc.library.controller.impl;

import by.epamtc.library.controller.Command;
import by.epamtc.library.service.ServiceException;
import by.epamtc.library.service.ServiceProvider;

public class EditBookCategoryCommand implements Command {
    @Override
    public String execute(String request) {
        String divider = "=";
        String[] params = request.split(" ", 3);
        String name = params[0].substring(params[0].indexOf(divider) + 1);
        String author = params[1].substring(params[1].indexOf(divider) + 1);
        String category = params[2].substring(params[2].indexOf(divider) + 1);

        StringBuilder response = new StringBuilder();
        try{
           ServiceProvider.getInstance().getBookService().editBookCategory(name, author, category);
           response.append("Book has been successfully edited");
        }catch(ServiceException e){
            e.printStackTrace();
            response.append("Something went wrong. The book has not been edited");
        }

        return response.toString();
    }
}
