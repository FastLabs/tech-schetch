package tech.sketch.command;


public abstract class AbstractSketchCommand<T> implements SketchCommand<T> {



    protected final String [] commandSpec;


     AbstractSketchCommand(String[] commandSpec) {
        this.commandSpec = commandSpec;
    }


    public boolean isValidCommand() {
        return true;
    }

    @Override
    public String getCommandName() {
        return commandSpec[0];
    }
}
