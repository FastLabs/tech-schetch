package tech.sketch.command;


import tech.sketch.shape.Shape;


//TODO: rename all the commands in ending with cmd to make it less verbose
public interface SketchCommand {

    String COMMAND_PARAM_SEPARATOR = " ";

    boolean isValidCommand();

    Shape sketchIt();

    String getCommandFormat();

    String getCommandName();


}
