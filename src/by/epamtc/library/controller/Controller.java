package by.epamtc.library.controller;

public class Controller {
    private final CommandProvider commandProvider = new CommandProvider();

    public String action(String request) {
        String[] params;
        Command command;

        params = request.split(" ", 2);
        command = commandProvider.getCommand(params[0]);

        return command.execute(params[1]);
    }
}
