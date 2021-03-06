package tech.sketch.shape;


import org.junit.Test;

import java.awt.geom.Rectangle2D;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RectangleTest {
    @Test
    public void testRectangle() {
        final Rectangle r = new Rectangle(2, 3, 15, 16);
        final Path[] paths = r.getPaths();
        assertEquals(4, paths.length);
        final Path top = paths[0],
                right = paths[1],
                bottom = paths[2],
                left = paths[3];
        //Top path
        assertEquals(2, top.getFrom().getX());
        assertEquals(3, top.getFrom().getY());
        assertEquals(17, top.getTo().getX());
        assertEquals(3, top.getTo().getY());
        //Right path
        assertEquals(17, right.getFrom().getX());
        assertEquals(4, right.getFrom().getY());
        assertEquals(17, right.getTo().getX());
        assertEquals(18, right.getTo().getY());
        //bottom path
        assertEquals(2, bottom.getFrom().getX());
        assertEquals(19, bottom.getFrom().getY());
        assertEquals(17, bottom.getTo().getX());
        assertEquals(19, bottom.getTo().getY());
        //left path
        assertEquals(2, left.getFrom().getX());
        assertEquals(4, left.getFrom().getY());
        assertEquals(2, left.getTo().getX());
        assertEquals(18, left.getTo().getY());
    }

    @Test
    public void testBoundaries() {
        Rectangle inner = new Rectangle(2, 2, 10, 10);
        Rectangle outer = new Rectangle(1, 1, 11, 11);

        assertTrue(outer.contains(inner));
        outer = new Rectangle(2, 3, 10, 12);
        assertFalse(outer.contains(inner));
    }
}
