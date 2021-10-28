package by.epamtc.library.controller;

import by.epamtc.library.controller.impl.AuthorizationCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> commands = new HashMap<>();

    CommandProvider(){
        commands.put(CommandName.AUTHORIZATION, new AuthorizationCommand());
    }

    public Command getCommand(String stringCommandName) {
        CommandName commandName;
        Command command;

        commandName = CommandName.valueOf(stringCommandName.toUpperCase());
        command = commands.get(commandName);

        return command;
    }
}
