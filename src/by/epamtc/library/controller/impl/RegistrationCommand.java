package by.epamtc.library.controller.impl;

import by.epamtc.library.controller.Command;
import by.epamtc.library.service.ServiceException;
import by.epamtc.library.service.ServiceProvider;
import by.epamtc.library.service.UserService;

public class RegistrationCommand implements Command {
    @Override
    public String execute(String request) {
        String[] params;

        String login;
        String password;
        String firstName;
        String lastName;
        String email;
        String userRole;

        String response = "";
        String divider = "=";

        UserService service = ServiceProvider.getInstance().getUserService();
        params = request.split(" ", 6);

        login = params[0].substring(params[0].indexOf(divider) + 1);
        password = params[1].substring(params[1].indexOf(divider) + 1);
        firstName = params[2].substring(params[2].indexOf(divider) + 1);
        lastName = params[3].substring(params[3].indexOf(divider) + 1);
        email = params[4].substring(params[4].indexOf(divider) + 1);
        userRole = params[5].substring(params[5].indexOf(divider) + 1);

        try {
            service.registration(login,password,firstName, lastName, email, userRole);
            response = "Registration is succesfully completed!";
        } catch (ServiceException e) {
            // log
            response = "Error. Registration is NOT completed. Try again";
        }

        return response;
    }
}
