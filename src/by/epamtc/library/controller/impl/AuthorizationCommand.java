package by.epamtc.library.controller.impl;

import by.epamtc.library.controller.Command;
import by.epamtc.library.model.User;
import by.epamtc.library.controller.CashClass;
import by.epamtc.library.service.ServiceException;
import by.epamtc.library.service.ServiceProvider;

public class AuthorizationCommand implements Command {
    @Override
    public String execute(String request) {
        String []params = request.split(" ", 2);

        String login = valueParser(params[0]);
        String password = valueParser(params[1]);

        StringBuilder response = new StringBuilder();
        try{
            User user = ServiceProvider.getInstance().getUserService().authorization(login, password);
            CashClass.setCashedUserRole(user.getUserRole());
            response.append(user.getFirstName()).append(" ").append(user.getLastName()).append(", welcome to our library!");
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        return response.toString();
    }

    public String valueParser(String string){
        return string.substring(string.indexOf("=") + 1);
    }
}
