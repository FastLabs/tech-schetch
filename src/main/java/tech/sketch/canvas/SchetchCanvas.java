package tech.sketch.canvas;


import tech.sketch.shape.Shape;

import java.util.Set;

public class SchetchCanvas {


    private final int height;
    private final int width;
    private final char[][] canvas;

    public SchetchCanvas(int width, int height) {
        this.height = height;
        this.width = width;
        this.canvas = buildCanvas(width + 2, height + 2);

    }

    private char[][] buildCanvas(int width, int height) {
        final char[][] canvas = new char[height][];
        for (int i = 0; i < height; i++) {
            canvas[i] = new char[width];
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1) {
                    canvas[i][j] = '-';
                } else {
                    if (j == 0 || j == width - 1) {
                        canvas[i][j] = '|';
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

    public String draw(Set<Shape> shapes) {
        final String content = printCanvas();
        return content;
    }
}
