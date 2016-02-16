package tech.sketch.shape;


import java.awt.geom.Rectangle2D;

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

    @Override
    public Rectangle getBounds() {
        int x, y, w, h;
        if (one.getX() < two.getX()) {
            x = one.getX();
            w = two.getX() - one.getX();
        } else {
            x = two.getX();
            w = one.getX() - two.getX();
        }
        if (one.getY() < two.getY() ) {
            y = one.getY();
            h = two.getY() - one.getY();
        } else {
            y = two.getY();
            h = one.getY() - two.getY();
        }
        return new Rectangle(x, y, w, h);
    }


}
