package tech.sketch.command;


import tech.sketch.shape.Rectangle;
import tech.sketch.shape.Shape;

public class CreateCanvasCommand  extends AbstractSketchCommand {



    private final int width;
    private final int height;

    public CreateCanvasCommand(String[] commandSpec) {
        super(commandSpec);
        width = Integer.parseInt(commandSpec[1]);
        height = Integer.parseInt(commandSpec[2]);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {

        return width;
    }

    @Override
    public Shape sketchIt() {
        return new Rectangle(-1, -1, width-1, height-1);
    }

    @Override
    public String getCommandFormat() {
        return "C %W %H";
    }
}
