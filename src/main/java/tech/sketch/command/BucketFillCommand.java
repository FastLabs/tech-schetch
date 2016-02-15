package tech.sketch.command;

import tech.sketch.canvas.SketchCanvas;
import tech.sketch.canvas.SketchRenderer;

/**
 * Implementation of the recursive flood fill (bucket fill) algorithm
 */
public class BucketFillCommand extends AbstractSketchCommand<SketchCanvas> {
    private final int x, y;
    private final char fill;

    public BucketFillCommand(String[] commandSpec) {
        super(commandSpec);
        this.x = Integer.parseInt(commandSpec[1]);
        this.y = Integer.parseInt(commandSpec[2]);
        this.fill = commandSpec[3].charAt(0);
    }

    public BucketFillCommand(String command) {
        this(command.split(SketchCommand.COMMAND_PARAM_SEPARATOR));
    }

    @Override
    public String getCommandFormat() {
        return "B %i %i %c";
    }

    @Override
    public CommandResult execute(SketchCanvas context, SketchRenderer renderer) {
        renderer.render(fill(x + 1, y + 1, SketchCanvas.DEFAULT_FILL, this.fill, context));
        return CommandResult.success();
    }


    public String fill(int x, int y, char targetFill, char replacementFill, SketchCanvas sketchCanvas) {
        final char[][] canvas = sketchCanvas.getCanvas();
        if (targetFill == replacementFill) {
            return "";
        }
        if (canvas[y][x] != targetFill) {
            return "";
        }
        if (x == 0 || y == 0 || x == sketchCanvas.getWidth() + 1 || y == sketchCanvas.getHeight() + 1) {
            return "";
        }
        canvas[y][x] = replacementFill;
        fill(x, y - 1, targetFill, replacementFill, sketchCanvas);
        fill(x, y + 1, targetFill, replacementFill, sketchCanvas);
        fill(x - 1, y, targetFill, replacementFill, sketchCanvas);
        fill(x + 1, y, targetFill, replacementFill, sketchCanvas);
        return sketchCanvas.printCanvas();
    }
}
