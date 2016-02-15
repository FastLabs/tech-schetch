package tech.sketch.canvas;


import tech.sketch.command.CommandResult;
import tech.sketch.command.CreateCanvasCommand;
import tech.sketch.command.SketchCommand;

import static tech.sketch.command.CommandResult.errorCommand;
import static tech.sketch.command.CommandResult.success;

/**
 * Graphical shell implementation that executes render commands.
 */
public class TextGraphicShell implements GraphicShell {

    private SketchCanvas currentCanvas;
    private final SketchRenderer renderer;

    private final int maxWidth, maxHeight;

    public TextGraphicShell(SketchRenderer renderer, int maxWidht, int maxHeight) {
        this.renderer = renderer;
        this.maxWidth = maxWidht;
        this.maxHeight = maxHeight;

    }

    public TextGraphicShell() {
        this(new SysConsoleRenderer(), 50, 50);
    }

    @Override
    @SuppressWarnings("unchecked")
    public CommandResult execute(SketchCommand cmd) {
        if (!cmd.isValidCommand()) {
            return errorCommand(String.format("Expected command format: %s", cmd.getCommandFormat()));
        }
        if (currentCanvas != null) {
            return cmd.execute(currentCanvas, renderer);
        }
        return errorCommand("Cannot  sketch on empty canvas, create the canvas first. e.g C 20 20");
    }

    @Override
    public CommandResult newSketchCanvas(CreateCanvasCommand cmd) {
        if (cmd.isValidCommand()) {
            currentCanvas = new SketchCanvas(cmd.getWidth(), cmd.getHeight());
            if (cmd.getWidth() > currentCanvas.getWidth() || cmd.getHeight() > currentCanvas.getHeight()) {
                return errorCommand(String.format("Canvas boundaries are out of graphic shell. Expected W:%s, H:%s",
                        maxWidth, maxHeight));
            }
            renderer.render(currentCanvas.draw(cmd.sketchIt()));
            return success();
        } else {
            return errorCommand(String.format("Expected canvas creation format: %s", cmd.getCommandFormat()));
        }
    }


}
