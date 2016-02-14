package tech.sketch.canvas;


import tech.sketch.command.*;

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
    @SuppressWarnings("unchecked")
    public CommandResult execute(SketchCommand cmd) {
        if (currentCanvas != null) {
            return cmd.execute(currentCanvas, renderer);

        }
        return CommandResult.errorCommand("Cannot  sketch on empty canvas"); //TODO: make this a better message
    }

    @Override
    public CommandResult newSketchCanvas(CreateCanvasCommand cmd) {
        currentCanvas = new SketchCanvas(cmd.getWidth(), cmd.getHeight());

        renderer.render(currentCanvas.draw(cmd.sketchIt()));
        return CommandResult.success();
    }


}
