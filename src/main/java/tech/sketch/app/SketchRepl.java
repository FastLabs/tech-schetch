package tech.sketch.app;


import tech.sketch.command.CommandResult;
import tech.sketch.command.CommandResult.CommandStatus;
import tech.sketch.command.SketchCommandProcessor;

import java.io.Console;

/**
 * The repl cannot be launched from ide, run the application from the command line.
 * e.g. java -cp tech-sketch-0.0.1-SNAPSHOT.jar "tech.sketch.app.Main"
 */
public class SketchRepl {

    private final SketchCommandProcessor commandProcessor = new SketchCommandProcessor();

    public void start() {

        final Console c = System.console();
        if (c != null) {
            CommandResult commandResult;
            do {
                final String line = c.readLine("Enter sketch: ");
                commandResult = commandProcessor.processCommand(line);
                switch (commandResult.getStatus()) {
                    case ERROR:
                    case UNKNOWN:
                        System.out.println(commandResult.getMessage());
                        break;
                }

            }
            while (commandResult.getStatus() == CommandStatus.EXIT); //TODO: maybe I need more semantics on exit commands

            System.out.println("Job Done! Bye!");
        } else {
            System.err.println("Error: could not load the console!");
        }
    }

}