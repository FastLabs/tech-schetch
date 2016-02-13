package tech.sketch.command;

import tech.sketch.shape.Line;
import tech.sketch.shape.Shape;


public class LineSketchCommand extends AbstractSketchCommand {


    final int x1, y1, x2, y2;


    public LineSketchCommand(String[] commandSpec) {
        super(commandSpec);
        x1 = Integer.parseInt(commandSpec[1]);
        y1 = Integer.parseInt(commandSpec[2]);
        x2 = Integer.parseInt(commandSpec[3]);
        y2 = Integer.parseInt(commandSpec[4]);
    }

    @Override
    public boolean isValidCommand() {
        return super.isValidCommand();
    }

    @Override
    public Shape sketchIt() {
        int x1 = Integer.parseInt(commandSpec[1]),
                y1 = Integer.parseInt(commandSpec[2]),
                x2 = Integer.parseInt(commandSpec[3]),
                y2 = Integer.parseInt(commandSpec[4]);

        return new Line(x1, y1, x2, y2);
    }

    @Override
    public String getCommandFormat() {
        return "L %i %i %i %i";
    }
}
