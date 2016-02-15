package tech.sketch.command;

import tech.sketch.canvas.SketchRenderer;

public interface SketchCommand <T>{
    String COMMAND_PARAM_SEPARATOR = "( )+";

    boolean isValidCommand();

    String getCommandFormat();

    String getCommandName();

    CommandResult execute(T context, SketchRenderer renderer);
}
