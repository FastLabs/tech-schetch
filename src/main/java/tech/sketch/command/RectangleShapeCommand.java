package tech.sketch.command;

import tech.sketch.shape.Shape;


public class RectangleShapeCommand extends AbstractShapeCommand  {

    RectangleShapeCommand(String[] commandSpec) {
        super(commandSpec);
    }

    public RectangleShapeCommand(String command) {
        super(command);
    }

    @Override
    public Shape sketchIt() {
        return null;
    }

    @Override
    public String getCommandFormat() {
        return null;
    }
}
