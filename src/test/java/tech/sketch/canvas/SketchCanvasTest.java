package tech.sketch.canvas;


import org.junit.Ignore;
import org.junit.Test;
import tech.sketch.shape.Line;
import tech.sketch.shape.Rectangle;

import static org.junit.Assert.assertEquals;

public class SketchCanvasTest {



    @Test
    @Ignore
    //TODO: fix this as at the moment rendering of the borders has changed
    public void testCanvasRender() {
        final SketchCanvas canvas = new SketchCanvas(20, 10);
        final String content = canvas.draw(null);
        final String[] lines = content.split("\n");
        assertEquals("Total lines including borders", 12, lines.length);
        assertEquals("First Line", "----------------------", lines[0]);
        assertEquals("Last Line", "----------------------", lines[lines.length - 1]);
        for (int i = 1; i < lines.length - 1; i++) {
            assertEquals("Empty screen line " + i, "|                    |", lines[i]);
        }
    }

    @Test
    public void testHorizontal() {
        final SketchCanvas canvas = new SketchCanvas(20, 10);
        final Line l = new Line(0, 0, 10, 0, '-');
        final String result = canvas.draw(l);
        final String[] lines = result.split("\n");
        assertEquals(12, lines.length);
        assertEquals("First Line excluding the border", " -----------          ", lines[1]);
    }

    @Test
    public void testVerticalLine() {
         final SketchCanvas canvas = new SketchCanvas(20, 10);
        final Line l = new Line(0, 0, 0, 10);
        final String content = canvas.draw(l);
        System.out.println(content);
    }

    @Test
    public void testBorder() {
        final SketchCanvas canvas = new SketchCanvas(20, 10);
        final Rectangle r = new Rectangle(-1, -1, 9, 9);
        String content = canvas.draw(r);
        System.out.println(content);
    }

   /* @Test
    public void testSimpleFill() {
        final SketchCanvas canvas = new SketchCanvas(20, 10);
        final Rectangle r  = new Rectangle(-1, -1, 9, 9);
        final Line l = new Line(2,2, 2, 6);
        canvas.draw(r);
        String c1 = canvas.draw(l);
        String result = canvas.fill(4, 4, ' ', '@');
        System.out.println(result);
    }
    @Test
    public void testEnclosedAreaFill() {
        final SketchCanvas canvas = new SketchCanvas(20, 10);
        final Rectangle border  = new Rectangle(-1, -1, 9, 9);
        final Rectangle r  = new Rectangle(0, 1, 5, 5);
        canvas.draw(border);
        final String c1 = canvas.draw(r);
        final String c2 = canvas.fill(3,4, ' ', '@');
        System.out.println(c2);



    }*/
}
