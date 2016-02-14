package tech.sketch.canvas;


import tech.sketch.shape.Path;
import tech.sketch.shape.Point;
import tech.sketch.shape.Shape;

import java.util.Arrays;


//TODO: do i need to build a hierarchy?

public class SketchCanvas {

    private final int BORDER_OFFSET = 1;
    public static final char DEFAULT_FILL = ' ';


    private final int height;
    private final int width;
    private final char[][] canvas;

    public SketchCanvas(int width, int height) {
        this.height = height;
        this.width = width;
        this.canvas = buildCanvas(width + 2 * BORDER_OFFSET, height + 2* BORDER_OFFSET);

    }

    private char[][] buildCanvas(int width, int height) {
        final char[][] canvas = new char[height][];
        for (int i = 0; i < height; i++) { //TODO: review this with a better array filling: Array.fill
            canvas[i] = new char[width];
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1) {

                    canvas[i][j] = DEFAULT_FILL;
                } else {
                    //if (j == 0 || j == width - 1) {

                      //  canvas[i][j] = ' ';
                    //} else {
                        canvas[i][j] = DEFAULT_FILL;
                    //}
                }
            }
        }

        return canvas;
    }
    //TODO: check how do i expose this
    public char [] [] getCanvas() {
        return  canvas;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
//TODO: check the exposing this method
    public String printCanvas() {
        final StringBuilder result = new StringBuilder();
        for (char[] line : canvas) {
            result.append(line).append("\n");
        }

        return result.toString();

    }

    private void renderShape(Shape shape) {
        final Path[] paths = shape.getPaths();
        for (Path path : paths) {
            final Point from = path.getFrom(),
                    to = path.getTo();
            for (int i = from.getX() + BORDER_OFFSET; i <= to.getX() + BORDER_OFFSET; i++) {
                for (int j = from.getY() + BORDER_OFFSET; j <= to.getY() + BORDER_OFFSET; j++) {
                    canvas[j][i] = path.getFill();
                }
            }
        }


    }

    public String draw(Shape... shapes) {
        Arrays.stream(shapes).forEach(this::renderShape);
        return printCanvas();

    }
}
