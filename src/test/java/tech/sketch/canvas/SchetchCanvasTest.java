package tech.sketch.canvas;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SchetchCanvasTest {

    @Test
    public void testCanvasRender() {
        final SchetchCanvas canvas = new SchetchCanvas(20, 10);
        final String content = canvas.draw(null);
        final String[] lines = content.split("\n");
        assertEquals("Total lines including borders", 12, lines.length);
        assertEquals("First Line", "----------------------", lines[0]);
        assertEquals("Last Line", "----------------------", lines[lines.length - 1]);
        for (int i = 1; i < lines.length - 1; i++) {
            assertEquals("Empty screen line " + i, "|                    |", lines[i]);
        }


    }
}
