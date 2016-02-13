package tech.sketch.canvas;


import tech.sketch.command.CommandResult;
import tech.sketch.command.CreateCanvasCommand;
import tech.sketch.command.SketchCommand;

public class TextGraphicShell implements GraphicShell {

    private SketchCanvas currentCanvas;
    private final SketchRenderer renderer;

    public TextGraphicShell(SketchRenderer renderer) {
        this.renderer = renderer;
    }

    public TextGraphicShell() {
        this.renderer = new SysConsoleRenderer();
    }


    @Override// TODO: do i need to expose this? don't think so
    public SketchCanvas getCurrentCanvas() {
        return currentCanvas;
    }

    @Override
    public CommandResult execute(SketchCommand cmd) {
        if (currentCanvas != null) {
            renderer.render(currentCanvas.draw(cmd.sketchIt()));
            return CommandResult.success();
        }
        return CommandResult.errorCommand("Cannot  sketch on empty canvas"); //TODO: meke this a better message
    }

    @Override
    public CommandResult newSketchCanvas(CreateCanvasCommand cmd) {
        currentCanvas = new SketchCanvas(cmd.getWidth(), cmd.getHeight());

        renderer.render(currentCanvas.draw(cmd.sketchIt()));
        return CommandResult.success();
    }


}
