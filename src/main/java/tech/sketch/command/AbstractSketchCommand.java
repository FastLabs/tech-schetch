package tech.sketch.command;


public abstract class AbstractSketchCommand implements SketchCommand {



    protected final String [] commandSpec;


     AbstractSketchCommand(String[] commandSpec) {
        this.commandSpec = commandSpec;
    }

    public AbstractSketchCommand(String command) {
        this(command.split(COMMAND_PARAM_SEPARATOR));
    }

    public boolean isValidCommand() {
        return true;
    }

    @Override
    public String getCommandName() {
        return commandSpec[0];
    }
}
