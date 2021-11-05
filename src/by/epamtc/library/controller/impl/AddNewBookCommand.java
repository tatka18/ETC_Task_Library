package by.epamtc.library.controller.impl;

import by.epamtc.library.controller.Command;
import by.epamtc.library.service.ServiceException;
import by.epamtc.library.service.ServiceProvider;

public class AddNewBookCommand implements Command {
    @Override
    public String execute(String request) {
        String[] params;
        params = request.split(" ", 4);

        String bookName = valueParser(params[0]);
        String author = valueParser(params[1]);
        String yearOfPublishing = valueParser(params[2]);
        String category = valueParser(params[3]);
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
    public String valueParser(String string){
        return string.substring(string.indexOf("=") + 1);
    }
}
