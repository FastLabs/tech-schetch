package tech.sketch.canvas;


import tech.sketch.shape.Path;
import tech.sketch.shape.Point;
import tech.sketch.shape.Shape;

import java.util.Arrays;


/**
 * Simple text symbol canvas implementation
 */

public class SketchCanvas {

    private final int BORDER_OFFSET = 1;
    public static final char DEFAULT_FILL = ' ';


    private final int height;
    private final int width;
    private final char[][] canvas;

    public SketchCanvas(int width, int height) {
        this.height = height;
        this.width = width;
        this.canvas = buildCanvas(width + 2 * BORDER_OFFSET, height + 2 * BORDER_OFFSET);

    }

    private char[][] buildCanvas(int width, int height) {
        final char[][] canvas = new char[height][];
        for (int i = 0; i < height; i++) {
            canvas[i] = new char[width];
            Arrays.fill(canvas[i], DEFAULT_FILL);
        }

        return canvas;
    }


    public char[][] getCanvas() {
        return canvas;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


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

    /**
     * Renders a set fo shapes on the canvas
     * @param shapes
     * @return
     */
    public String draw(Shape... shapes) {
        Arrays.stream(shapes).forEach(this::renderShape);
        return printCanvas();

    }
}
