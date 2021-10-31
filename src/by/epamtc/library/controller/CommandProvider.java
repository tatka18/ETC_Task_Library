package by.epamtc.library.controller;

import by.epamtc.library.controller.impl.AuthorizationCommand;
import by.epamtc.library.controller.impl.RegistrationCommand;
import by.epamtc.library.controller.impl.ShowAllCatalogCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> commands = new HashMap<>();

    CommandProvider(){
        commands.put(CommandName.AUTHORIZATION, new AuthorizationCommand());
        commands.put(CommandName.REGISTRATION, new RegistrationCommand());
        commands.put(CommandName.SHOW_ALL_CATALOG, new ShowAllCatalogCommand());
    }

    public Command getCommand(String stringCommandName) {
        CommandName commandName;
        Command command;

        commandName = CommandName.valueOf(stringCommandName.toUpperCase());
        command = commands.get(commandName);

        return command;
    }
}
