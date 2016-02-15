package tech.sketch.shape;


public class Line extends AbstractShape {
    private final Point one;
    private final Point two;


    public Line(int x1, int y1, int x2, int y2, char fill) {
        super(fill);
        one = new Point(x1, y1);
        two = new Point(x2, y2);

    }

    public Line(int x1, int y1, int x2, int y2) {
        this(x1, y1, x2, y2, '*');
    }

    public boolean isVertical() {
        return one.getX() == two.getX();
    }

    public boolean isHorizontal() {
        return one.getY() == two.getY();
    }

    @Override
    public Path[] getPaths() {
        return new Path[]{new SimplePath(one, two, getFill())};
    }


}
