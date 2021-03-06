package by.epamtc.library.controller;

import by.epamtc.library.controller.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> commands = new HashMap<>();

    CommandProvider(){
        commands.put(CommandName.AUTHORIZATION, new AuthorizationCommand());
        commands.put(CommandName.REGISTRATION, new RegistrationCommand());
        commands.put(CommandName.SHOW_ALL_CATALOG, new ShowAllCatalogCommand());
        commands.put(CommandName.FIND_BOOK_BY_NAME, new FindBookByName());
        commands.put(CommandName.ADD_NEW_BOOK, new AddNewBookCommand());
        commands.put(CommandName.EDIT_BOOK_CATEGORY, new EditBookCategoryCommand());
    }

    public Command getCommand(String stringCommandName) {
        CommandName commandName;
        Command command;

        commandName = CommandName.valueOf(stringCommandName.toUpperCase());
        command = commands.get(commandName);

        return command;
    }
}
