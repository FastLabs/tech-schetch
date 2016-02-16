package tech.sketch.command;


import tech.sketch.canvas.CanvasException;
import tech.sketch.canvas.SketchCanvas;
import tech.sketch.canvas.SketchRenderer;
import tech.sketch.shape.Shape;

import static tech.sketch.command.CommandResult.errorCommand;

public abstract class AbstractShapeCommand extends AbstractSketchCommand<SketchCanvas> {

    AbstractShapeCommand(String[] commandSpec) {
        super(commandSpec);
    }


    @Override
    public CommandResult execute(SketchCanvas canvas, SketchRenderer renderer) {
        if (isValidCommand()) {
            try {
                renderer.render(canvas.draw(sketchIt()));
            }catch (CanvasException e ) {
                return CommandResult.errorCommand(e.getMessage());
            }
            return CommandResult.success();
        } else {
            return errorCommand(String.format("Expected command command: %s", this.getCommandFormat()));
        }
    }

    protected abstract Shape sketchIt();
}
