package tech.sketch.command;

import tech.sketch.shape.Rectangle;
import tech.sketch.shape.Shape;


public class RectangleShapeCommand extends AbstractShapeCommand {

    private int x, y, height, width;

    RectangleShapeCommand(String[] commandSpec) {
        super(commandSpec);

        if (commandSpec.length != 5) {
            commandError();
        } else {
            try {
                x = Integer.parseInt(commandSpec[1].trim());
                y = Integer.parseInt(commandSpec[2].trim());
                width = Integer.parseInt(commandSpec[3].trim());
                height = Integer.parseInt(commandSpec[4].trim());
            } catch (NumberFormatException ex) {
                commandError();
            }
        }

    }

    private void commandError() {
        x = y = width = height = Integer.MIN_VALUE;
    }

    @Override
    public boolean isValidCommand() {
        return x >= 0 && y >= 0 && height >= 0 && width >= 0;
    }

    public RectangleShapeCommand(String command) {
        this(command.split(SketchCommand.COMMAND_PARAM_SEPARATOR));
    }

    @Override
    public Shape sketchIt() {
        if (isValidCommand()) {
            return new Rectangle(x, y, width, height);
        }
        return new Rectangle(0, 0, 0, 0);
    }

    @Override
    public String getCommandFormat() {
        return "R %topX %topY %width %height";
    }
}
