package tech.sketch.shape;

/**
 * A connected simple path with from and to point and filling for that path
 */
public class SimplePath implements Path {


    private final Point from;
    private final Point  to;
    private final char fill;


    public SimplePath(Point from, Point to, char fill) {
        this.from = from;
        this.to = to;
        this.fill = fill;
    }

    public SimplePath(Point from, Point to) {
        this(from, to, '*');
    }

    public SimplePath (int x1, int y1, int x2, int y2 ) {
        this(x1, y1, x2, y2, '*');
    }
    public SimplePath (int x1, int y1, int x2, int y2 , char fill) {
        this(new Point(x1, y1), new Point (x2, y2), fill);
    }

    @Override
    public String toString() {
        return "SimplePath{" +
                "from=" + from +
                ", to=" + to +
                ", fill=" + fill +
                '}';
    }

    @Override
    public Point getFrom() {
        return from;
    }

    @Override
    public Point getTo() {
        return to;
    }

    @Override
    public char getFill() {
        return fill;
    }
}
