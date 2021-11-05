package by.epamtc.library.controller.impl;

import by.epamtc.library.controller.Command;
import by.epamtc.library.controller.CashClass;
import by.epamtc.library.service.ServiceException;
import by.epamtc.library.service.ServiceProvider;
import by.epamtc.library.service.UserService;

public class RegistrationCommand implements Command {
    @Override
    public String execute(String request) {
        String[] params;

        UserService service = ServiceProvider.getInstance().getUserService();
        params = request.split(" ", 6);

        String login = valueParser(params[0]);
        String password = valueParser(params[1]);
        String firstName = valueParser(params[2]);
        String lastName = valueParser(params[3]);
        String email = valueParser(params[4]);
        String userRole = valueParser(params[5]);

        StringBuilder response = new StringBuilder();

        try {
            if(CashClass.getCashedUserRole().equals("admin")) {
                service.registration(login,password,firstName, lastName, email, userRole);
                response.append("Registration is successfully completed!");
            }else {
                response.append("Sorry, but you have no rights for user registration!");
            }
        } catch (ServiceException e) {

            System.out.println("Error. Registration is NOT completed. Try again : " + e.getMessage());
        }
        return response.toString();
    }
    public String valueParser(String string){
        return string.substring(string.indexOf("=") + 1);
    }
}
