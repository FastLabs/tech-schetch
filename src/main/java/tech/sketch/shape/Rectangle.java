package tech.sketch.shape;

public class Rectangle extends AbstractShape {

    private final int x;
    private final int y;
    private final int widht;
    private final int height;

    public Rectangle(int x, int y, int widht, int height, char fill) {
        super(fill);
        this.x = x;
        this.y = y;
        this.widht = widht;
        this.height = height;
    }


    public Rectangle(int x, int y, int widht, int height) {
        this(x, y, widht, height, '*');
    }


    @Override
    public Path[] getPaths() {
        final Path top = new SimplePath(x, y, x + widht, y, getFill()),
                right = new SimplePath(x + widht, y, x + widht, y + height),
                bottom = new SimplePath(x, y+height, x +widht, y+height),
        left = new SimplePath(x, y, x, y+ height);
        return new Path[]{top, right, bottom, left};
    }
}
