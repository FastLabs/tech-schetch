package tech.sketch.canvas;


import tech.sketch.command.CommandResult;
import tech.sketch.command.CreateCanvasCommand;
import tech.sketch.command.SketchCommand;

/**
 * Implemented by a graphical engine that renders graphical commands
 */
public interface GraphicShell {


    CommandResult execute(SketchCommand command);

    CommandResult newSketchCanvas(CreateCanvasCommand command);


}
