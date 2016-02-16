package tech.sketch.canvas.utils;


import tech.sketch.canvas.CanvasException;
import tech.sketch.canvas.SketchCanvas;
import tech.sketch.shape.Rectangle;

import java.util.Arrays;

public class CanvasFactory {


    public static SketchCanvas defaultCanvas() {
        int width = 20, height = 12;
        final SketchCanvas c = new SketchCanvas(width, height);
        char[][] canvas = c.getCanvas();
        Arrays.fill(canvas[0], '-');
        Arrays.fill(canvas[canvas.length - 1], '-');
        for(int i = 1 ;i< canvas.length-1;i++) {
            char [] x = canvas[i];
            Arrays.fill(x, ' ');
            x[0] = '|';
            x[x.length-1] = '|';
        }
        return c;
    }
}
