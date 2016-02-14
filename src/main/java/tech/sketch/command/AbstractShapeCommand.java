package tech.sketch.command;


import tech.sketch.canvas.SketchCanvas;
import tech.sketch.canvas.SketchRenderer;
import tech.sketch.shape.Shape;

public abstract class AbstractShapeCommand extends AbstractSketchCommand<SketchCanvas>{

    AbstractShapeCommand(String[] commandSpec) {
        super(commandSpec);
    }

    public AbstractShapeCommand(String command) {
        super(command);
    }

    @Override
    public CommandResult execute(SketchCanvas canvas, SketchRenderer renderer) {
        renderer.render(canvas.draw(sketchIt()));
        return CommandResult.success();
    }

    protected abstract Shape sketchIt();
}
