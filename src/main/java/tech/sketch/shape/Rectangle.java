package tech.sketch.shape;

public class Rectangle extends AbstractShape {

    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final char verticalFill;

    public Rectangle(int x, int y, int width, int height, char fill, char verticalFill) {
        super(fill);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.verticalFill = verticalFill;
    }


    public Rectangle(int x, int y, int width, int height) {
        this(x, y, width, height, '*', '*');
    }


    @Override
    public Path[] getPaths() {
        final Path top = new SimplePath(x, y, x + width, y, getFill()),
                right = new SimplePath(x + width, y + 1, x + width, y + height - 1, verticalFill),
                bottom = new SimplePath(x, y + height, x + width, y + height, getFill()),
                left = new SimplePath(x, y + 1, x, y + height - 1, verticalFill);
        return new Path[]{top, right, bottom, left};
    }

    @Override
    public Rectangle getBounds() {
        return this;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    public boolean isEmpty() {
        return (width <= 0.0 || height <= 0.0);
    }

    public boolean contains(Rectangle r) {
        if (isEmpty()) {
            return false;
        }
        double x0 = getX();
        double y0 = getY();
        return (r.getX() >= x0 &&
                r.getY() >= y0 &&
                (r.getX() + r.getWidth()) <= x0 + getWidth() &&
                (r.getY() + r.getHeight()) <= y0 + getHeight());
    }
}
