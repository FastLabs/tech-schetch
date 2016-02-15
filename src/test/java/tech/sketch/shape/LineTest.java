package tech.sketch.shape;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LineTest {

    @Test
    public void testHorizontalLine() {
        final Line horizontalLine = new Line(0, 0, 0, 2, '@');
        assertTrue(horizontalLine.isVertical());
        assertEquals('@', horizontalLine.getFill());
        final Path[] paths = horizontalLine.getPaths();
        assertEquals(1, paths.length);
        final Point from = paths[0].getFrom(),
                to = paths[0].getTo();
        assertEquals(0, from.getX());
        assertEquals(0, from.getY());
        assertEquals(0, to.getX());
        assertEquals(2, to.getY());
    }

    @Test
    public void testVerticalLine() {
        final Line verticalLine = new Line(1, 1, 10, 1);
        assertTrue(verticalLine.isHorisontal());
        assertEquals('*', verticalLine.getFill());
        final Path[] paths = verticalLine.getPaths();
        assertEquals(1, paths.length);
        final Point from = paths[0].getFrom(),
                to = paths[0].getTo();
        assertEquals(1, from.getX());
        assertEquals(1, from.getY());
        assertEquals(10, to.getX());
        assertEquals(1, to.getY());

    }
}
