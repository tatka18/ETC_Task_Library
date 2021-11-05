package by.epamtc.library.controller.impl;

import by.epamtc.library.controller.Command;
import by.epamtc.library.service.ServiceException;
import by.epamtc.library.service.ServiceProvider;

public class AddNewBookCommand implements Command {
    @Override
    public String execute(String request) {
        String[] params;
        params = request.split(" ", 4);
        String divider = "=";

        String bookName = params[0].substring(params[0].indexOf(divider) + 1);
        String author = params[1].substring(params[1].indexOf(divider) + 1);
        String yearOfPublishing = params[2].substring(params[2].indexOf(divider) + 1);
        String category = params[3].substring(params[3].indexOf(divider) + 1);
        StringBuilder response = new StringBuilder();
        try{
            boolean result = ServiceProvider.getInstance().getBookService()
                    .createNewBook(bookName, author, yearOfPublishing, category);
            if(result){
                response.append("The book ").append(bookName).append(" has been successfully created");
            }else {
                response.append("Something went wrong. Book hasn't been created");
            }
        }catch (ServiceException e){
            System.out.println(e.getMessage());
        }
        return response.toString();
    }
}
