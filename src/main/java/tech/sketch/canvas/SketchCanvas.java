package tech.sketch.canvas;


import tech.sketch.shape.Path;
import tech.sketch.shape.Point;
import tech.sketch.shape.Shape;

import java.util.Arrays;


//TODO: do i need to build a hierarchy?

public class SketchCanvas {


    private final int height;
    private final int width;
    private final char[][] canvas;

    public SketchCanvas(int width, int height) {
        this.height = height;
        this.width = width;
        this.canvas = buildCanvas(width + 2, height + 2);

    }

    private char[][] buildCanvas(int width, int height) {
        final char[][] canvas = new char[height][];
        for (int i = 0; i < height; i++) { //TODO: review this with a better array filling: Array.fill
            canvas[i] = new char[width];
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1) {
                    // canvas[i][j] = '-';
                    canvas[i][j] = ' ';
                } else {
                    if (j == 0 || j == width - 1) {
                        //    canvas[i][j] = '|';
                        canvas[i][j] = ' ';
                    } else {
                        canvas[i][j] = ' ';
                    }
                }
            }
        }

        return canvas;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    private String printCanvas() {
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
            boolean vertical = from.getX() == to.getX();
            for (int i = from.getX() +1; i <= to.getX()+1; i++) {
                for(int j = from.getY()+1; j<= to.getY()+1;j++){
                    //if( vertical) {
                        canvas[j][i] = path.getFill();
               //     } else {
                 //       canvas[i][j] = path.getFill();
                   // }
                }
            }
        }


    }

    public String draw(Shape... shapes) {
        Arrays.stream(shapes).forEach(this::renderShape);
        return printCanvas();

    }
}
