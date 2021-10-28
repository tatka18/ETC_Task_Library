package by.epamtc.library.controller.impl;

import by.epamtc.library.controller.Command;
import by.epamtc.library.model.User;
import by.epamtc.library.service.ServiceException;
import by.epamtc.library.service.ServiceProvider;

public class AuthorizationCommand implements Command {
    @Override
    public String execute(String request) {
        String []params = request.split(" ", 2);
        String login;
        String password;
        String divider = "=";

        login = params[0].substring(params[0].indexOf(divider) + 1);
        password = params[1].substring(params[1].indexOf(divider) + 1);

        String result = "";
        try{
            User user = ServiceProvider.getInstance().getUserService().authorization(login, password);
            System.out.println();
            result = user.getFirstName() + " " + user.getLastName() + ", welcome to our library!";
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return result;
    }
}
