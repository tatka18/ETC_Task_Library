package by.epamtc.library.run;

import by.epamtc.library.controller.Controller;
import by.epamtc.library.view.PrintResult;

public class Run {
    public static void main(String[] args) {
        Controller controller = new Controller();

        String request;
        String response;

        request = "authorization login=Youk password=gh";
        response = controller.action(request);
        PrintResult.printString(response);

        request = "registration login=Youk password=gh firstName=Cool lastName=Nok " +
                "mail=tyui@mail.ru userRole=reader";
        response = controller.action(request);
        PrintResult.printString(response);

        request = "show_all_catalog";
        response = controller.action(request);

    }
}
