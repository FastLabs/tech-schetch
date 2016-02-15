package tech.sketch.canvas;


import org.junit.Test;
import tech.sketch.shape.Line;
import tech.sketch.shape.Rectangle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SketchCanvasTest {


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
        final String[] expected = new String[]{
                "                      ",
                " *                    ",
                " *                    ",
                " *                    ",
                " *                    ",
                " *                    ",
                " *                    ",
                " *                    ",
                " *                    ",
                " *                    ",
                " *                    ",
                " *                    "
        };
        validate(content.split("\n"), expected);
    }

    @Test
    public void testBorder() {
        final SketchCanvas canvas = new SketchCanvas(20, 10);
        final Rectangle r = new Rectangle(-1, -1, 9, 9);
        final String content = canvas.draw(r);
        assertNotNull(content);
        final String[] expected = new String[]{
                "**********            ",
                "*        *            ",
                "*        *            ",
                "*        *            ",
                "*        *            ",
                "*        *            ",
                "*        *            ",
                "*        *            ",
                "*        *            ",
                "**********            ",
                "                      ",
                "                      "
        };
        validate(content.split("\n"), expected);
    }

    private void validate(String[] content, String[] expect) {
        for (int i = 0; i < content.length; i++) {
            assertEquals("Lne: " + i, expect[i], content[i]);
        }
    }

}
