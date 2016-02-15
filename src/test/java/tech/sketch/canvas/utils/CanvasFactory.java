package tech.sketch.canvas.utils;


import tech.sketch.canvas.SketchCanvas;
import tech.sketch.shape.Rectangle;

public class CanvasFactory {


    public static SketchCanvas defaultCanvas() {
        int width = 20, height = 12;
        final SketchCanvas canvas = new SketchCanvas(width, height);
        final Rectangle r = new Rectangle(-1, -1, width + 1, height + 1, '-', '|');
        canvas.draw(r);
        return canvas;
    }
}
