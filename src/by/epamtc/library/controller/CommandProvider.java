package by.epamtc.library.controller;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();

//    public Command getCommand(String strCommandName) {
//        CommandName commandName;
//        Command command;
//
//        commandName = CommandName.valueOf(strCommandName.toUpperCase());
//        command = commands.get(commandName);
//
//        return command;
//    }
}
