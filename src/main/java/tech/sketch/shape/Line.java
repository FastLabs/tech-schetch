package tech.sketch.shape;


import java.awt.*;

public class Line extends AbstractShape {
    private final Point one;
    private final Point two;

    public Line (int x1, int y1, int x2, int y2) {
        one = new Point(x1, y1);
        two = new Point(x2, y2);
    }

    @Override
    protected Path[] getPaths() {
        return new Path[0];
    }
}
