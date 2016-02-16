package tech.sketch.canvas;


import tech.sketch.shape.Path;
import tech.sketch.shape.Point;
import tech.sketch.shape.Rectangle;
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

    private final Rectangle boundary;

    public SketchCanvas(int width, int height) {
        this.height = height;
        this.width = width;
        this.boundary = new Rectangle(0, 0, width-1, height-1);
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


    private void renderShape(Shape shape) throws CanvasException {
        if (!boundary.contains(shape.getBounds())) {
            throw new CanvasException(String.format("Out of bound error. Accepts : [%s, %s, %s , %s] ",
                    boundary.getX(), boundary.getY(), boundary.getWidth(), boundary.getHeight()));
        }
        final Path[] paths = shape.getPaths();
        for (Path path : paths) {
            final Point from = path.getFrom(),
                    to = path.getTo();

            final int fromX = from.getX() + BORDER_OFFSET,
                    toX = to.getX() + BORDER_OFFSET,
                    fromY = from.getY() + BORDER_OFFSET,
                    toY = to.getY() + BORDER_OFFSET;

            for (int i = fromX; i <= toX; i++) {
                for (int j = fromY; j <= toY; j++) {
                    canvas[j][i] = path.getFill();
                }
            }
        }
    }

    /**
     * Renders a set fo shapes on the canvas
     *
     * @param shapes
     * @return
     */
    public String draw(Shape... shapes) throws CanvasException {
        for (Shape shape : shapes) {
            renderShape(shape);
        }
        return printCanvas();

    }
}
