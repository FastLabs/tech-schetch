package tech.sketch.command;

import tech.sketch.shape.Line;
import tech.sketch.shape.Shape;


public class LineSketchCommand extends AbstractSketchCommand {



    @Override
    public Shape sketchIt() {
        return new Line(0, 0, 10, 10);
    }
}
