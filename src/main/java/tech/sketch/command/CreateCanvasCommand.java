package tech.sketch.command;


import tech.sketch.canvas.SketchCanvas;
import tech.sketch.canvas.SketchRenderer;
import tech.sketch.shape.Rectangle;
import tech.sketch.shape.Shape;

import java.util.Arrays;

public class CreateCanvasCommand extends AbstractSketchCommand<SketchCanvas> {

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
    public String getCommandFormat() {
        return "C %W %H";
    }

    @Override
    public CommandResult execute(SketchCanvas context, SketchRenderer renderer) {
        char[][] canvas = context.getCanvas();
        Arrays.fill(canvas[0], '-');
        Arrays.fill(canvas[canvas.length - 1], '-');
        for(int i = 1 ;i< canvas.length-1;i++) {
            char [] x = canvas[i];
            Arrays.fill(x, ' ');
            x[0] = '|';
            x[x.length-1] = '|';
        }
        renderer.render(context.printCanvas());
        return CommandResult.success();
    }
}
