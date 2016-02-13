package tech.sketch.canvas;


import tech.sketch.command.CommandResult;
import tech.sketch.command.CreateCanvasCommand;
import tech.sketch.command.SketchCommand;

public interface GraphicShell {


    //TODO: do i need this?
    @Deprecated
    SketchCanvas getCurrentCanvas();

    CommandResult execute(SketchCommand command);

    CommandResult newSketchCanvas(CreateCanvasCommand command);


}
