package by.epamtc.library.controller.impl;

import by.epamtc.library.controller.Command;
import by.epamtc.library.service.ServiceException;
import by.epamtc.library.service.ServiceProvider;

public class EditBookCategoryCommand implements Command {
    @Override
    public String execute(String request) {
        String[] params = request.split(" ", 3);
        String name = valueParser(params[0]);
        String author = valueParser(params[1]);
        String category = valueParser(params[2]);

        StringBuilder response = new StringBuilder();
        try{
           ServiceProvider.getInstance().getBookService().editBookCategory(name, author, category);
           response.append("Book has been successfully edited");
        }catch(ServiceException e){
            System.out.println("Something went wrong. The book has not been edited: " + e.getMessage());
        }

        return response.toString();
    }
    public String valueParser(String string){
        return string.substring(string.indexOf("=") + 1);
    }
}
