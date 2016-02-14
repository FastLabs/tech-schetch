package tech.sketch.command;

import tech.sketch.canvas.SketchCanvas;


public interface CanvasCommand {
    CommandResult execute(SketchCanvas canvas);
}
