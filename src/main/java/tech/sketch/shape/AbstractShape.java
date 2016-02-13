package tech.sketch.shape;


public abstract class AbstractShape implements Shape {
    private final char fill;


    protected AbstractShape(char fill) {
        this.fill = fill;
    }


    public char getFill() {
        return fill;
    }
}
