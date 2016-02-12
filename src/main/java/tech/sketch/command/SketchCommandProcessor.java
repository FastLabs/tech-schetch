package tech.sketch.command;

import static tech.sketch.command.CommandResult.errorCommand;
import static tech.sketch.command.CommandResult.unknownCommand;

/**
 * Processes a string literal of the command and produces a executable command
 */
public class SketchCommandProcessor {
    private static final String COMMAND_SEPARATOR = " ";

    private static final String SUPPORTED_COMMAND_FORMAT = "XXX"; //TODO: specify the correct format


    public CommandResult processCommand(final String command) {
        final String[] commandSpec = command.split(COMMAND_SEPARATOR);
        if (commandSpec.length > 0) {
            final String commandName = commandSpec[0];
            switch (commandName) {
                case "Q":
                    return CommandResult.exitCommand();
                default:
                    return unknownCommand(commandName);
            }
        }
        return errorCommand(String.format("Error processing command %s use the format %s", command, SUPPORTED_COMMAND_FORMAT));
    }
}
