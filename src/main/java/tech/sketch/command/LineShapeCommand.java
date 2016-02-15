package tech.sketch.command;

import tech.sketch.shape.Line;
import tech.sketch.shape.Shape;

/**
 * Command implementation for line
 */
public class LineShapeCommand extends AbstractShapeCommand {

    private int x1, y1, x2, y2;

    public LineShapeCommand(String[] commandSpec) {
        super(commandSpec);
        try {
            x1 = Integer.parseInt(commandSpec[1]);
            y1 = Integer.parseInt(commandSpec[2]);
            x2 = Integer.parseInt(commandSpec[3]);
            y2 = Integer.parseInt(commandSpec[4]);
        } catch (NumberFormatException ex) {
            x1 = Integer.MIN_VALUE;
            x2 = Integer.MIN_VALUE;
            y1 = Integer.MIN_VALUE;
            y2 = Integer.MIN_VALUE;
        }
    }

    public LineShapeCommand(String command) {
        this(command.split(SketchCommand.COMMAND_PARAM_SEPARATOR));
    }

    @Override
    public boolean isValidCommand() {
        final boolean allPositive = x1 >= 0 && x2 >= 0 && y1 >= 0 && y2 >= 0,
                vertical = x1 == x2,
                horizontal = y1 == y2;
        return allPositive && (vertical || horizontal);
    }

    @Override
    public Shape sketchIt() {
        return new Line(x1, y1, x2, y2);
    }

    @Override
    public String getCommandFormat() {
        return "L %i %i %i %i";
    }
}
