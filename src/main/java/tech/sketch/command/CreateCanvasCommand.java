package tech.sketch.command;


import tech.sketch.shape.Rectangle;
import tech.sketch.shape.Shape;

public class CreateCanvasCommand extends AbstractShapeCommand {

    private int width;
    private int height;

    public CreateCanvasCommand(String[] commandSpec) {
        super(commandSpec);
        if (commandSpec.length != 3) {
            commandError();
        } else {
            try {
                width = Integer.parseInt(commandSpec[1]);
                height = Integer.parseInt(commandSpec[2]);
            } catch (NumberFormatException ex) {
                commandError();

            }
        }
    }

    private void commandError() {
        width = Integer.MIN_VALUE;
        height = Integer.MIN_VALUE;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public boolean isValidCommand() {
        return width >= 0 && height >= 0;
    }

    @Override
    public Shape sketchIt() {
        return new Rectangle(-1, -1, width - 1, height - 1, '-', '|');
    }

    @Override
    public String getCommandFormat() {
        return "C %W %H";
    }
}
