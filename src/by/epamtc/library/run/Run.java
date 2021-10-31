package by.epamtc.library.run;

import by.epamtc.library.controller.Controller;
import by.epamtc.library.view.PrintResult;

public class Run {
    public static void main(String[] args) {
        Controller controller = new Controller();

        String request;
        String response;

        request = "authorization login=asd password=asdfg";
        response = controller.action(request);
        PrintResult.printString(response);

        request = "registration login=ashjkd password=gh firstName=Dook lastName=AAss " +
                "mail=tyui@mail.ru userRole=reader";
        response = controller.action(request);
        PrintResult.printString(response);

    }
}
