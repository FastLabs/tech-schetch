package tech.sketch.command;

import tech.sketch.canvas.GraphicShell;

import static tech.sketch.command.CommandResult.errorCommand;
import static tech.sketch.command.CommandResult.unknownCommand;

/**
 * Processes a string literal of the command and produces a executable command
 */
public class SketchCommandProcessor {


    private static final String SUPPORTED_COMMAND_FORMAT = "CMD_NAME [CMD_PARAMS]";

    private final GraphicShell graphicShell;

    public SketchCommandProcessor(GraphicShell graphicShell) {
        this.graphicShell = graphicShell;
    }


    public CommandResult processCommand(final String command) {
        final String[] commandSpec = command.split(SketchCommand.COMMAND_PARAM_SEPARATOR);
        if (commandSpec.length > 0) {
            final String commandName = commandSpec[0];
            switch (commandName) {
                case "Q":
                    return CommandResult.exitCommand();
                case "L":
                    return executeCommand(new LineShapeCommand(commandSpec));
                case "C":
                    return newCanvas(new CreateCanvasCommand(commandSpec));
                case "R":
                    return executeCommand(new RectangleShapeCommand(commandSpec));
                case "B":
                    return executeCommand(new BucketFillCommand(commandSpec));
                default:
                    return unknownCommand(commandName);
            }
        }
        return errorCommand(String.format("Error processing command %s use the format %s", command, SUPPORTED_COMMAND_FORMAT));
    }

    private CommandResult newCanvas(CreateCanvasCommand cmd) {
        return graphicShell.newSketchCanvas(cmd);
    }

    private CommandResult executeCommand(SketchCommand cmd) {
        try {
            if (cmd.isValidCommand()) {
                return graphicShell.execute(cmd);
            } else {
                return errorCommand(String.format("Invalid command format. Required: %s", cmd.getCommandFormat()));
            }
        } catch (RuntimeException ex) {
            return errorCommand(String.format("Error executing the command: %s expected format: %s",
                    cmd.getCommandName(),
                    cmd.getCommandFormat()));
        }
    }
}
